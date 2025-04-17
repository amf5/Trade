package com.trade.trading.controller;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trade.trading.entity.Coin;
import com.trade.trading.service.CoinService;

@RestController
@RequestMapping("/coins")
public class CoinController {
@Autowired
private CoinService coinService;


@Autowired
private ObjectMapper objectMapper;

@GetMapping
public ResponseEntity<List<Coin>>getCoinList(@RequestParam(name = "page",required = false) int page) throws Exception{
	List<Coin> coins=coinService.getCoinList(page);
	return new ResponseEntity<>(coins,HttpStatus.ACCEPTED);
	
	
}


@GetMapping("/{coinId}/chart")
public ResponseEntity<JsonNode>getMarketChart(@PathVariable String coinId
		,@RequestParam("days")int days) throws Exception{
	String  response=coinService.getMarketChart(coinId, days);
	JsonNode jsonNode=objectMapper.readTree(response);
	
	return new ResponseEntity<>(jsonNode,HttpStatus.ACCEPTED);
	
	
	
	
}



@GetMapping("/search")
public ResponseEntity<JsonNode>searchCoin(@RequestParam("q") String keyword) throws Exception{
	
	String coin=coinService.searchCoin(keyword);
	JsonNode json=objectMapper.readTree(coin);
	return ResponseEntity.ok(json);
	
}





@GetMapping("/top50")
public ResponseEntity<JsonNode>getTop50CoinByMarketCapRank() throws Exception{
	
	String coin=coinService.getTop50CoinsByMarketCapRank();
	JsonNode jsonNode=objectMapper.readTree(coin);
	return ResponseEntity.ok(jsonNode);
	
	
	
	
}
@GetMapping("/treading") 
public ResponseEntity<JsonNode>getTreadingCoin() throws Exception{
	String coin=coinService.getTreadingCoins();
	JsonNode jsonNode=objectMapper.readTree(coin);
	return ResponseEntity.ok(jsonNode);
}


@GetMapping("/details/{coinId}")
public ResponseEntity<JsonNode> getCoinDetails(@PathVariable String coinId) throws Exception{
	
	
	String coin=coinService.getCoinDetails(coinId);
	JsonNode jsonNode=objectMapper.readTree(coin);
	return ResponseEntity.ok(jsonNode);
	
}


}
