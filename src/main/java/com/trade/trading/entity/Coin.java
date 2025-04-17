package com.trade.trading.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Coin {
    @Id
	@JsonProperty("id")
	private String id;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;
    @JsonProperty("current_price")
    private Double currentPrice;
    @JsonProperty("market_cap")
    private Long marketCap;
    @JsonProperty("market_cap_rank")
    private int marketCapRank;
    @JsonProperty("fully-diluted-valuation")
    private Long fullyDilutedValuation;
    @JsonProperty("total_volume")
    private Long totalVolume;
    @JsonProperty("high_24h")
    private Double high24h;
    @JsonProperty("low_24h")
    private Double low24h;
    @JsonProperty("price_change_24h")
    private Double priceChange24h;
    @JsonProperty("price_change_percentage_24h")
    private Double priceChangePrecentage24h;
    @JsonProperty("market_cap_change_24h")
    private Long marketCapChange24h;
    @JsonProperty("market_cap_change_percentage_24h")
    private Double marketCapChangePercentage24h;
    @JsonProperty("circulating_supply")
    private Long circulatingSupply;
    @JsonProperty("total_supply")
    private Long totalSupply;
    @JsonProperty("max_supply")
    private Long maxSupply;
    @JsonProperty("ath")
    private int ath;
    @JsonProperty("ath_change_percentage")
    private Double athChangePercentage;
    @JsonProperty("ath_date")
    private Date athDate;
    @JsonProperty("atl")
    private Double atl;
    @JsonProperty("atl_change_percentage")
    private Double atlChangePercentage;
    @JsonProperty("atl_date")
    private Date atlDate;
    @JsonProperty("roi")
    @JsonIgnore
    private String roi;
    @JsonProperty("last_update")
    private Date LastUpdate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Long getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(Long marketCap) {
		this.marketCap = marketCap;
	}
	public int getMarketCapRank() {
		return marketCapRank;
	}
	public void setMarketCapRank(int marketCapRank) {
		this.marketCapRank = marketCapRank;
	}
	public Long getFullyDilutedValuation() {
		return fullyDilutedValuation;
	}
	public void setFullyDilutedValuation(Long fullyDilutedValuation) {
		this.fullyDilutedValuation = fullyDilutedValuation;
	}
	public Long getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(Long totalVolume) {
		this.totalVolume = totalVolume;
	}
	public Double getHigh24h() {
		return high24h;
	}
	public void setHigh24h(Double high24h) {
		this.high24h = high24h;
	}
	public Double getLow24h() {
		return low24h;
	}
	public void setLow24h(Double low24h) {
		this.low24h = low24h;
	}
	public Double getPriceChange24h() {
		return priceChange24h;
	}
	public void setPriceChange24h(Double priceChange24h) {
		this.priceChange24h = priceChange24h;
	}
	public Double getPriceChangePrecentage24h() {
		return priceChangePrecentage24h;
	}
	public void setPriceChangePrecentage24h(Double priceChangePrecentage24h) {
		this.priceChangePrecentage24h = priceChangePrecentage24h;
	}
	public Long getMarketCapChange24h() {
		return marketCapChange24h;
	}
	public void setMarketCapChange24h(Long marketCapChange24h) {
		this.marketCapChange24h = marketCapChange24h;
	}
	public Double getMarketCapChangePercentage24h() {
		return marketCapChangePercentage24h;
	}
	public void setMarketCapChangePercentage24h(Double marketCapChangePercentage24h) {
		this.marketCapChangePercentage24h = marketCapChangePercentage24h;
	}
	public Long getCirculatingSupply() {
		return circulatingSupply;
	}
	public void setCirculatingSupply(Long circulatingSupply) {
		this.circulatingSupply = circulatingSupply;
	}
	public Long getTotalSupply() {
		return totalSupply;
	}
	public void setTotalSupply(Long totalSupply) {
		this.totalSupply = totalSupply;
	}
	public Long getMaxSupply() {
		return maxSupply;
	}
	public void setMaxSupply(Long maxSupply) {
		this.maxSupply = maxSupply;
	}
	public int getAth() {
		return ath;
	}
	public void setAth(int ath) {
		this.ath = ath;
	}
	public Double getAthChangePercentage() {
		return athChangePercentage;
	}
	public void setAthChangePercentage(Double athChangePercentage) {
		this.athChangePercentage = athChangePercentage;
	}
	public Date getAthDate() {
		return athDate;
	}
	public void setAthDate(Date athDate) {
		this.athDate = athDate;
	}
	public Double getAtl() {
		return atl;
	}
	public void setAtl(Double atl) {
		this.atl = atl;
	}
	public Double getAtlChangePercentage() {
		return atlChangePercentage;
	}
	public void setAtlChangePercentage(Double atlChangePercentage) {
		this.atlChangePercentage = atlChangePercentage;
	}
	public Date getAtlDate() {
		return atlDate;
	}
	public void setAtlDate(Date atlDate) {
		this.atlDate = atlDate;
	}
	public String getRoi() {
		return roi;
	}
	public void setRoi(String roi) {
		this.roi = roi;
	}
	public Date getLastUpdate() {
		return LastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		LastUpdate = lastUpdate;
	}
	public Coin(String symbol, String name, String image, Double currentPrice, Long marketCap, int marketCapRank,
			Long fullyDilutedValuation, Long totalVolume, Double high24h, Double low24h, Double priceChange24h,
			Double priceChangePrecentage24h, Long marketCapChange24h, Double marketCapChangePercentage24h,
			Long circulatingSupply, Long totalSupply, Long maxSupply, int ath, Double athChangePercentage, Date athDate,
			Double atl, Double atlChangePercentage, Date atlDate, String roi, Date lastUpdate) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.image = image;
		this.currentPrice = currentPrice;
		this.marketCap = marketCap;
		this.marketCapRank = marketCapRank;
		this.fullyDilutedValuation = fullyDilutedValuation;
		this.totalVolume = totalVolume;
		this.high24h = high24h;
		this.low24h = low24h;
		this.priceChange24h = priceChange24h;
		this.priceChangePrecentage24h = priceChangePrecentage24h;
		this.marketCapChange24h = marketCapChange24h;
		this.marketCapChangePercentage24h = marketCapChangePercentage24h;
		this.circulatingSupply = circulatingSupply;
		this.totalSupply = totalSupply;
		this.maxSupply = maxSupply;
		this.ath = ath;
		this.athChangePercentage = athChangePercentage;
		this.athDate = athDate;
		this.atl = atl;
		this.atlChangePercentage = atlChangePercentage;
		this.atlDate = atlDate;
		this.roi = roi;
		LastUpdate = lastUpdate;
	}
	public Coin() {
		super();
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	
	
}
