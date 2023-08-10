

async function list(id){
    const response = await fetch('http://localhost:8080/transaction/sell/' + id, {
        method: 'PUT',
    });
}

async function fetchCards() {

    try {
      // We are using fetch to get the response
      const response = await fetch('http://localhost:8080/cards/2');
      const data = await response.json();

        let template = document.querySelector("#row");
        console.log(data);
        for(const card of data){
            console.log(card);
            let clone = document.importNode(template.content, true);
            if (card.forSale === false){
            newContent= clone.firstElementChild.innerHTML
                        .replace(/{{img_src}}/g, card.url)
                        .replace(/{{name}}/g, card.name)
                        .replace(/{{hp}}/g, card.hp)
                        .replace(/{{attack}}/g, card.attack)
                        .replace(/{{defense}}/g, card.defence)
                        .replace(/{{price}}/g, card.price)
                        .replace(/{{for_sale}}/g, card.forSale)
                        .replace(/{{icon}}/g, "<div class='ui vertical animated button' tabindex='0' onClick='list("+ card.id + ")'><div class='hidden content'>Add</div> <div class='visible content'>  <i class='plus square icon'></i> </div> </div>");
            }
            else{
                newContent= clone.firstElementChild.innerHTML
                .replace(/{{img_src}}/g, card.url)
                .replace(/{{name}}/g, card.name)
                .replace(/{{hp}}/g, card.hp)
                .replace(/{{attack}}/g, card.attack)
                .replace(/{{defense}}/g, card.defence)
                .replace(/{{price}}/g, card.price)
                .replace(/{{for_sale}}/g, card.forSale)
                .replace(/{{icon}}/g, '<div class="ui vertical animated button" tabindex="0"><div class="hidden content">Remove</div> <div class="visible content">  <i class="minus square icon"></i> </div> </div>');
            }

            clone.firstElementChild.innerHTML= newContent;

            let cardContainer= document.querySelector("#tableContent");
            cardContainer.appendChild(clone);
      
        }
    } catch (error) {
      console.log(error);
    }
  }

fetchCards()






