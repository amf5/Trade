package com.trade.trading.entity;

import com.trade.trading.domain.VerificationType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class VerificationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    private String otp;
    
    @OneToOne
    private User user;
    
    private String email;
    
    private String mobile;
    
    private VerificationType verificationType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public VerificationType getVerificationType() {
		return verificationType;
	}

	public void setVerificationType(VerificationType verificationType) {
		this.verificationType = verificationType;
	}

	/**
	 * @param otp
	 * @param user
	 * @param email
	 * @param mobile
	 * @param verificationType
	 */
	public VerificationCode(String otp, User user, String email, String mobile, VerificationType verificationType) {
		super();
		this.otp = otp;
		this.user = user;
		this.email = email;
		this.mobile = mobile;
		this.verificationType = verificationType;
	}

	/**
	 * 
	 */
	public VerificationCode() {
		super();
	}
    

}
