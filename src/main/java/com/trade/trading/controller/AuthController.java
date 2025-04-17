package com.trade.trading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trade.trading.configuration.JwtProvider;
import com.trade.trading.entity.TwoFactorOtp;
import com.trade.trading.entity.User;
import com.trade.trading.repository.UserRepository;
import com.trade.trading.response.AuthResponse;
import com.trade.trading.service.CustomerUserDetailsService;
import com.trade.trading.service.EmailService;
import com.trade.trading.service.TwoFactorOtpService;
import com.trade.trading.utils.OtpUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {
@Autowired
private UserRepository userRepository;
@Autowired
private TwoFactorOtpService twoFactorOtpService;

@Autowired
private EmailService emailService; 
@Autowired
private CustomerUserDetailsService customerUserDetailsService;
@PostMapping("/signup")
public ResponseEntity<AuthResponse> register(@RequestBody User user) throws Exception{
	User isEmailExist=userRepository.findByEmail(user.getEmail());
	if(isEmailExist!=null) {
		throw new Exception("email is aready used with anothor account");
	}
	User newUser=new User();
	newUser.setEmail(user.getEmail());
	newUser.setPassword(user.getPassword());
	newUser.setFullName(user.getFullName());
    User savedUser=userRepository.save(newUser);
	Authentication authentication=new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
	SecurityContextHolder.getContext().setAuthentication(authentication);
	String jwt=JwtProvider.generateToken(authentication);
	AuthResponse response=new AuthResponse();
	response.setJwt(jwt);
	response.setStatus(true);
	response.setMessage("register sucess");
	
	return new  ResponseEntity(response,HttpStatus.CREATED);
}
	


@PostMapping("/signin")
public ResponseEntity<AuthResponse> Login(@RequestBody User user) throws Exception{
	String userName=user.getEmail();
	String password=user.getPassword();
	
	Authentication authentication=authenticate(userName,password);
	SecurityContextHolder.getContext().setAuthentication(authentication);
	String jwt=JwtProvider.generateToken(authentication);
	User authUser=userRepository.findByEmail(userName);
	if(user.getTwoFactorAuth().isEnabled()) {
		AuthResponse response=new AuthResponse();
		response.setMessage("two factor auth is enabled");
		response.setTwoFactorAuthEnabled(true);
		String otp=OtpUtils.generateOtp();
		TwoFactorOtp oldTwoFactorOtp=twoFactorOtpService.findByUser(authUser.getId());
		if(oldTwoFactorOtp!=null) {
		twoFactorOtpService.deleteTwoFactorOtp(oldTwoFactorOtp);
		
		}
		TwoFactorOtp newTwoFactorOtp=twoFactorOtpService.createTwoFactorOtp(authUser, otp, jwt);
		emailService.sendVerificationOtpEmail(userName,otp);
		response.setSession(newTwoFactorOtp.getId());
		return new  ResponseEntity(response,HttpStatus.ACCEPTED);
	}
	
	AuthResponse response=new AuthResponse();
	response.setJwt(jwt);
	response.setStatus(true);
	response.setMessage("login sucess");
	
	return new  ResponseEntity(response,HttpStatus.CREATED);
}



private Authentication authenticate(String userName, String password) {
	UserDetails userDetails=customerUserDetailsService.loadUserByUsername(userName);
	if(userDetails==null) {
		throw new BadCredentialsException("invalid username");
		
	}
	if(!password.equals(userDetails.getPassword())) {
		throw new BadCredentialsException("invalid password");
		
	}
	return new UsernamePasswordAuthenticationToken(userDetails, password,userDetails.getAuthorities());
}

@PostMapping("/two-factor/otp/{otp}")
public ResponseEntity<AuthResponse>verifySigninOtp(
		@PathVariable String otp,
		@RequestParam String id) throws Exception{
	TwoFactorOtp twoFactorOtp=twoFactorOtpService.findById(id);
	if(twoFactorOtpService.verifyTwoFactorOtp(twoFactorOtp, otp)) {
		AuthResponse response=new AuthResponse();
		response.setMessage("two factor  authentication verified");
		response.setTwoFactorAuthEnabled(true);
		response.setJwt(twoFactorOtp.getJwt());
		return new  ResponseEntity(response,HttpStatus.OK);
	}
	throw new Exception("invalid otp");
}






























}
