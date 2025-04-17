package com.trade.trading.service;

import java.util.List;

import com.trade.trading.entity.Asset;
import com.trade.trading.entity.Coin;
import com.trade.trading.entity.User;

public interface AssetService {
Asset createAsset(User user,Coin coin,double quantity);
Asset getAssetById(Long assetId) throws Exception;
Asset getAssetByUserIdAndId(Long userId,Long assetId);
List<Asset> getUsersAssets(Long userId);
Asset updateAsset(Long assetId,double quantity) throws Exception;
Asset findAssetByUserIdAndCoinId(Long userId,String coinId);
void deleteAsset(Long assetId);
}
