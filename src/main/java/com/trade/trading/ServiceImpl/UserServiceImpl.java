package com.trade.trading.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.trading.configuration.JwtProvider;
import com.trade.trading.domain.VerificationType;
import com.trade.trading.entity.TwoFactorAuth;
import com.trade.trading.entity.User;
import com.trade.trading.repository.UserRepository;
import com.trade.trading.service.UserService;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserRepository userRepository;
	@Override
	public User findUserProfileByJwt(String jwt) throws Exception {
		String email=JwtProvider.getEmailFromToken(jwt);
		User user=userRepository.findByEmail(email);
		if(user==null) {
			throw new Exception("user not found");
		}
		return user;
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		User user=userRepository.findByEmail(email);
		if(user==null) {
			throw new Exception("user not found");
		}
		return user;
	
	}

	@Override
	public User findUserById(Long userId) throws Exception {
		Optional< User> user=userRepository.findById(userId);
		if(user.isEmpty()) {
			
			throw new Exception("user not found");
		}
		return user.get();
	}

	
	@Override
	public User updatePassword(User user, String newPassword) {
		user.setPassword(newPassword);
		return userRepository.save(user);
	}

	@Override
	public User enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user) {
		TwoFactorAuth twoFactorAuth=new TwoFactorAuth();
		twoFactorAuth.setEnabled(true);
		twoFactorAuth.setSendTo(verificationType);
		user.setTwoFactorAuth(twoFactorAuth);
		
		return userRepository.save(user);
	}

}
