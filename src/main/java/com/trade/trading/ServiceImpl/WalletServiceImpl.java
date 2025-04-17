package com.trade.trading.ServiceImpl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.trading.domain.OrderType;
import com.trade.trading.entity.Order;
import com.trade.trading.entity.User;
import com.trade.trading.entity.Wallet;
import com.trade.trading.repository.WalletRepository;
import com.trade.trading.service.WalletService;

@Service
public class WalletServiceImpl  implements WalletService{
@Autowired
private WalletRepository walletRepository;
	@Override
	public Wallet getUserWallet(User user) {
	Wallet wallet=walletRepository.findByUserId(user.getId());
	if(wallet==null) {
		wallet =new Wallet();
		wallet.setUser(user);
		
	}
		return wallet;
	}

	@Override
	public Wallet addBalance(Wallet wallet, Long money) {
       		BigDecimal balance=wallet.getBelance();
       		BigDecimal newBalance=balance.add(BigDecimal.valueOf(money));
       		wallet.setBelance(newBalance);
       		
		return walletRepository.save(wallet);
	}

	@Override
	public Wallet findWalletById(Long id) throws Exception {
		Optional<Wallet> wallet=walletRepository.findById(id);
		if(wallet.isPresent()) {
			return wallet.get();
		}
	throw new Exception("wallet not found");
	}

	@Override
	public Wallet walletToWalletTranfer(User sender, Wallet receiverWallet, Long amount) throws Exception {
		Wallet senderWallet=getUserWallet(sender);
		if(senderWallet.getBelance().compareTo(BigDecimal.valueOf(amount))<0) {
			
			throw  new Exception("Insufficient balance.....");
			
		}
		
		BigDecimal senderBalance=senderWallet.getBelance().subtract(BigDecimal.valueOf(amount));
		senderWallet.setBelance(senderBalance);
		walletRepository.save(senderWallet);
		BigDecimal receiverBalance=receiverWallet.getBelance().add(BigDecimal.valueOf(amount));
		receiverWallet.setBelance(receiverBalance);
		walletRepository.save(receiverWallet);
		return senderWallet;
	}

	@Override
	public Wallet payOrderPayment(Order order, User user) throws Exception {
		Wallet wallet=getUserWallet(user);
		if(order.getOrderType().equals(OrderType.BUY)) {
			
			BigDecimal newBalance=wallet.getBelance().subtract(order.getPrice());
			if(newBalance.compareTo(order.getPrice())<0) {
				
				throw new Exception("Insufficient funds for this transaction");
			}
			wallet.setBelance(newBalance);
		}
		else {
			BigDecimal newBalance=wallet.getBelance().add(order.getPrice());
			wallet.setBelance(newBalance);
		}
		walletRepository.save(wallet);
		return wallet;
	}

}
