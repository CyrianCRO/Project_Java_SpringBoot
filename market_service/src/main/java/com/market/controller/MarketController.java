package com.market.controller;


import com.market.model.BuyRequest;
import com.market.service.MarketService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/market")
public class MarketController {

    private MarketService marketService;


  /*  @PostMapping("/buy")
    public void buyCard(BuyRequest buyrequest){
        marketService.buyCard(buyrequest);

    }
    @GetMapping("/getCard/{id}")
    public ResponseEntity<?> listCards(@PathVariable("id")  Long id){
        return ResponseEntity.ok( marketService.getCard(id));
    }
    @GetMapping("/listAllCard")
    public ResponseEntity<?> listCards(){
       return ResponseEntity.ok( marketService.listCards());
    }*/




}
