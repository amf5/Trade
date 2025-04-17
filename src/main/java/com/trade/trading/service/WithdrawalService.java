package com.trade.trading.service;

import java.util.List;

import com.trade.trading.entity.User;
import com.trade.trading.entity.Withdrawal;

public interface WithdrawalService {
Withdrawal requestWithdrawal(Long amount,User user);

Withdrawal proccedWithdrawal(Long withdrawalId,boolean accept) throws Exception;

List<Withdrawal> getUsersWithdrawalHistory(User user);

List<Withdrawal> getAllWithdrawalRequest();


}
