package com.cts.portfolioservice.repository;

import com.cts.portfolioservice.model.Portfolio;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface PortfolioRepository extends MongoRepository<Portfolio, BigInteger> {

    Portfolio findByUsername(String username);


}
