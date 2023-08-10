package com.groupe6.atelier3.lib.mappers;
import org.springframework.stereotype.Component;
import com.groupe6.atelier3.lib.DTO.CardUserDTO;
import com.groupe6.atelier3.lib.models.CardUser;

@Component
public class UserMapper {
	
	 public static CardUser toEntity(CardUserDTO cardUserDTO) {
        if (cardUserDTO == null) {
        	System.out.println("cardUserDto is null");
            return null;
        }
        CardUserDTO userDto = (CardUserDTO) cardUserDTO;
        CardUser cardUser = new CardUser();
        
        cardUser.setId(cardUserDTO.id);
        cardUser.setUsername(cardUserDTO.username);
        cardUser.setPassword(cardUserDTO.password);
        cardUser.setMoney(cardUserDTO.money);
        return cardUser;
    }
	
}
