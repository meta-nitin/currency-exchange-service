package org.self.currencyexchangeservice.repo;

import org.self.currencyexchangeservice.pojo.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Integer>{

	public ExchangeValue findByFromAndTo(String from, String to);
}
