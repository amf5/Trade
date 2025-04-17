package com.trade.trading.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trade.trading.domain.VerificationType;
import com.trade.trading.entity.ForgotPasswordToken;
import com.trade.trading.entity.User;
import com.trade.trading.entity.VerificationCode;
import com.trade.trading.request.ForgotPasswordTokenRequest;
import com.trade.trading.request.ResetPasswordRequest;
import com.trade.trading.response.ApiResponse;
import com.trade.trading.response.AuthResponse;
import com.trade.trading.service.EmailService;
import com.trade.trading.service.ForgotPasswordService;
import com.trade.trading.service.UserService;
import com.trade.trading.service.VerificationCodeService;
import com.trade.trading.utils.OtpUtils;

@RestController
public class UserController {
@Autowired 
private UserService userService;
@Autowired
private EmailService emailService;
@Autowired
private VerificationCodeService verificationCodeService;
@Autowired
private ForgotPasswordService forgotPasswordService;

@GetMapping("/api/users/profile")
public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String jwt) throws Exception
{
User  user=userService.findUserProfileByJwt(jwt);  	

return new ResponseEntity<>(user,HttpStatus.OK);
}



@PostMapping("/api/users/verification/{verificationType}/send-otp")
public ResponseEntity<String> sendAuthenticationOtp(@RequestHeader("Authorization") String jwt,
		@PathVariable VerificationType verificationType) throws Exception{

User  user=userService.findUserProfileByJwt(jwt);
VerificationCode verificationCode=verificationCodeService.getVerificationCodeByUser(user.getId());
if(verificationCode==null) {
verificationCode=verificationCodeService.sendVerificationCode(user, verificationType);
}
if(verificationType.equals(VerificationType.EMAIL))
{
emailService.sendVerificationOtpEmail(user.getEmail(), verificationCode.getOtp());	
}
return new ResponseEntity<>("verification otp send sucessfully",HttpStatus.OK);
}







@PatchMapping("/api/users/enable-two-factor/verify-otp/{otp}")
public ResponseEntity<User> enableTwoFactorAuthentication(@RequestHeader("Authorization") String jwt,@PathVariable String otp) throws Exception
{
User  user=userService.findUserProfileByJwt(jwt);  	
VerificationCode verificationCode=verificationCodeService.getVerificationCodeByUser(user.getId());
String sendTo=verificationCode.getVerificationType().equals(VerificationType.EMAIL)?
		verificationCode.getEmail():verificationCode.getMobile();
boolean isVerified=verificationCode.getOtp().equals(otp);

if(isVerified) {
User updatedUser=userService.enableTwoFactorAuthentication(verificationCode.getVerificationType(), sendTo, user);
verificationCodeService.deleteVerificationById(verificationCode);

return new ResponseEntity<>(updatedUser,HttpStatus.OK);
}

throw new Exception("wrong otp");
}





@PostMapping("/auth/users/reset-password/send-otp")
public ResponseEntity<AuthResponse> sendForgotPasswordOtp(
		@RequestBody ForgotPasswordTokenRequest forgotPasswordTokenRequest) throws Exception{
User user=userService.findUserByEmail(forgotPasswordTokenRequest.getSendTo());
String otp=OtpUtils.generateOtp();
UUID uuid=UUID.randomUUID();
String id=uuid.toString();
ForgotPasswordToken token=forgotPasswordService.findByUser(user.getId());
if(token==null) {
	
	token=forgotPasswordService.createToken(user, id, otp, forgotPasswordTokenRequest.getVerificationType(),forgotPasswordTokenRequest.getSendTo());
}
if(forgotPasswordTokenRequest.getVerificationType().equals(VerificationType.EMAIL)) {
	emailService.sendVerificationOtpEmail(user.getEmail(),token.getOtp());
}AuthResponse response=new AuthResponse();
response.setSession(token.getId());
response.setMessage("password reset otp sent Successfully");



return new ResponseEntity<>(response,HttpStatus.OK);
}





@PatchMapping("/auth/users/reset-password/verify-otp")
public ResponseEntity<ApiResponse> resetPassword(@RequestHeader("Authorization") String jwt
		,@RequestParam String id,
		@RequestBody ResetPasswordRequest req) throws Exception
{
User  user=userService.findUserProfileByJwt(jwt);  	
ForgotPasswordToken token=forgotPasswordService.findById(id);
boolean isVerified=token.getOtp().equals(req.getOtp());
if(isVerified) {
	
	userService.updatePassword(token.getUser(), req.getPassword());
	ApiResponse response=new ApiResponse();
	response.setMessage("password update successfully");

return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
}
throw new Exception("wrong otp");



}

















}
