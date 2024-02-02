package com.market.service;

import com.market.model.CardUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TransactionService {
	@Autowired
	private UserService uService;
	@Autowired
	private CardService cService;
	
	
	/**
	 * Purchase a card with the specified ID by transferring ownership from the current owner to the new owner.
	 * 
	 * @param newOwner The new owner of the card
	 * @param idCard The ID of the card being purchased
	 * @return A HTTP response indicating whether the transaction was successful or not
	 */
	public ResponseEntity<String> buyCard(CardUser newOwner, Integer idCard) {
	    try {
	        // Get current owner using the id of the card
	        CardUser currentOwner = cService.getCardUser(idCard);
	        // Make the transaction
	        this.makeTransaction(newOwner, currentOwner, idCard);
	        return ResponseEntity.ok("Transaction successful");
	    } catch (ResponseStatusException ex) {
	        return ResponseEntity.status(ex.getStatus()).body("Transaction failed: " + ex.getReason());
	    }
	}

	
	/**
	 * Update a card's status to indicate that it is for sale.
	 * 
	 * @param idCard The ID of the card to mark as for sale
	 * @return A ResponseEntity containing the updated Card object, with its status set to "for sale"
	 */
	public ResponseEntity<String> sellCard(Integer idCard) {
	    try {
	        // Update the card's status to indicate that it is for sale
	        cService.updateCardForSale(true, idCard);
	        return ResponseEntity.ok("Card is now for sale");
	    } catch (ResponseStatusException ex) {
	        return ResponseEntity.status(ex.getStatus()).body("" + ex.getReason());
	    }
	}

	
	/**
	 * Make a transaction by transferring a card from the current owner to the new owner,
	 * and updating their respective balances.
	 * 
	 * @param newOwner The new owner of the card
	 * @param currentOwner The current owner of the card
	 * @param idCard The ID of the card being traded
	 * @return True if the transaction succeeded, false otherwise
	 * @throws ResponseStatusException If the transaction failed due to insufficient funds or a system error
	 */
	public boolean makeTransaction(CardUser newOwner, CardUser currentOwner, int idCard) { 
	    boolean ret = false;
		// Get the price of the card 
	    int price = cService.getPrice(idCard);
	    boolean isForSale = cService.getForSale(idCard);
	    
	    // Check if the new owner has enough money to make the transaction and if the car is for sale
	    if (newOwner.getMoney() < price && isForSale) {
	        // Return a custom response to the client indicating that the transaction failed due to insufficient funds
	        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Transaction failed due to insufficient funds or/and the card is not for sale");
	    } else {
	        try {
	            // Make the trade
	            int newOwnerMoney = uService.getUserById(newOwner.getId()).getMoney() - price;
	            int currentOwnerMoney = currentOwner.getMoney() + price;
	            // Update money of both of the user 
	            uService.updateUserMoney(newOwner, newOwnerMoney);
	            uService.updateUserMoney(currentOwner, currentOwnerMoney);
	            // Change the current owner of the card 
	            cService.updateCardUser(newOwner, idCard);
	            // Change the status of the "for sale" status
	            cService.updateCardForSale(false, idCard);
	            ret = true; // Transaction succeeded
	        } catch (Exception e) {
	            // Catch any exceptions and return a custom response to the client
	            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Transaction failed due to a system error");
	        }
	    }
	    return ret;
	    
	}
}
