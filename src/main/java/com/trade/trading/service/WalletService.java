package com.trade.trading.service;

import com.trade.trading.entity.Order;
import com.trade.trading.entity.User;
import com.trade.trading.entity.Wallet;





public interface WalletService {
Wallet getUserWallet(User user);
Wallet addBalance(Wallet wallet,Long money);
Wallet findWalletById(Long id) throws Exception;
Wallet walletToWalletTranfer(User sender,Wallet receiverWallet,Long amount) throws Exception;
Wallet payOrderPayment(Order order,User user) throws Exception;


}
