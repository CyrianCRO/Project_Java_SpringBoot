package com.market.service;


import com.market.model.BuyRequest;
import com.market.repository.MarketRepository;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

  /*  public void buyCard(BuyRequest buyrequest) {
        marketRepository.save();
    }

    public Object getCard(Long id) {
    }

    public Object listCards() {
    }*/
}
