async function fetchCard() {
    try {
      // We are using fetch to get the response
      const response = await fetch('http://localhost:8080/card/2');
      const data = await response.json();
      console.log(data)

            // Mise à jour de la page HTML avec les valeurs extraites
            document.querySelector("#cardImgId").src = data.url;
            document.querySelector("#cardPriceId").innerHTML = data.price + '$';
            document.querySelector("#cardDefenceId").innerHTML = 'Defence ' + data.defence;
            document.querySelector("#cardAttackId").innerHTML ='Attack ' + data.attack;
            document.querySelector("#cardHPId").innerHTML = data.hp + 'HP';   
            document.querySelector("#name").innerHTML = data.name;      
    }
     catch (error) {
      console.log(error);
    }
}

fetchCard()
