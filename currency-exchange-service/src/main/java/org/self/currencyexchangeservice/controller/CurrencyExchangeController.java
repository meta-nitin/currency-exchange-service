package org.self.currencyexchangeservice.controller;

import org.self.currencyexchangeservice.pojo.ExchangeValue;
import org.self.currencyexchangeservice.repo.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencyExchange")
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/{from}-to-{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		if(exchangeValue == null)
			exchangeValue = new ExchangeValue();
		exchangeValue.setPort(Integer.parseInt(port));
		
		logger.info("The response in currency-exchange-service is: {}",exchangeValue.toString());
		return exchangeValue;
	}
}
