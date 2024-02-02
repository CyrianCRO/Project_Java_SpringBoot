function buyCard() {
    const buyCardId = document.getElementById('buyCardId').value;
    fetch(`localhost:8080/buy?id=${buyCardId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({}),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to buy card');
        }
        alert('Card bought successfully!');
    })
    .catch(error => {
        console.error('Error buying card:', error);
    });
}

function getCard() {
    const getCardId = document.getElementById('getCardId').value;
    fetch(`http://localhost:8080/card/${getCardId}`)
    .then(response => response.json())
    .then(card => {
        alert(`Card Details:\nID: ${card.id}\nName: ${card.name}\nprice: ${card.price}`);
    })
    .catch(error => {
        console.error('Error getting card:', error);
    });
}

function listAllCards() {


      const cards = [
              {
                name: "Card 1",
                hp: 100,
                defence: 50,
                attack: 75,
                url: "https://example.com/image1.jpg",
                forSale: true,
                price: 10
              },
               {
                        name: "Card 2",
                        hp: 100,
                        defence: 50,
                        attack: 75,
                        url: "https://static.cardmarket.com/img/048842e067e3e41447b9a12b4cf61f26/items/51/TR/274056.jpg",
                        forSale: true,
                        price: 10
                      },
              // Add more card objects as needed
            ];




    fetch(`http://localhost:8080/card/list`)
    .then(response => response.json())
    .then(cards => {
        const cardList = cards.map(card => `ID: ${card.id}, Name: ${card.name}, Type: ${card.hp}`).join('\n');
        alert(`All Cards:\n${cardList}`);
    })
    .catch(error => {
        console.error('Error listing all cards:', error);
    });








}





  // Function to create and append a card element
function createCard() {

   fetch(`http://localhost:8080/card/list`)
      .then(response => response.json())
      .then(cards => {

    const cardList = cards.map(card =>{
        const cardContainer = document.getElementById("cardContainer");

                    const cardElement = document.createElement("div");
                    cardElement.classList.add("card");

                    const cardImage = document.createElement("img");
                    cardImage.src = card.url;
                    cardImage.alt = card.name;

                    const cardDetails = document.createElement("div");


                    cardDetails.innerHTML = `
                      <p>Name: ${card.name}</p>
                      <p>HP: ${card.hp}</p>
                      <p>Defence: ${card.defence}</p>
                      <p>Attack: ${card.attack}</p>
                      <p>For Sale: ${card.forSale ? "Yes" : "No"}</p>
                      <p>Price: ${card.price}</p>
                    `;

                    const buySellButton = document.createElement("button");
                        buySellButton.textContent = card.forSale ? "Buy" : "Sell";
                        buySellButton.style.backgroundColor = card.forSale ? "green" : "red";

                        buySellButton.addEventListener("click", () => {


                        if (card.forSale) {
                               buyCard(card.id);
                             } else {
                               sellCard(card.id);
                             }
                           alert("Transaction done successfully");
                        });

                    cardElement.appendChild(cardImage);
                    cardElement.appendChild(cardDetails);
                    cardElement.appendChild(buySellButton);
                    cardContainer.appendChild(cardElement);

                // cards.forEach(createCard);
    });

      })
      .catch(error => {
          console.error('Error listing all cards:', error);
      });


      }



      async function buyCard(cardId) {
          try {
            // Fetch user data using GET method
            const userResponse = await fetch(`http://localhost:8080/user/${cardId}`, {
              method: 'GET',
            });

            const userData = await userResponse.json();

            // Make the buy request
            const response = await fetch(`http://localhost:8080/transaction/buy/${cardId}`, {
              method: 'PUT',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify({
                user: userData,
              }),
            });

            const data = await response.json();
            console.log(data); // Log the response from the server


          } catch (error) {
            console.error('Error during buyCard:', error);
          }
        }

        // Function to handle selling a card
        async function sellCard(cardId) {
          try {
            const response = await fetch(`http://localhost:8080/transaction/sell/${cardId}`, {
              method: 'PUT',
            });

            const data = await response.json();
            console.log(data); // Log the response from the server

            // Refresh the page or update the UI as needed
          } catch (error) {
            console.error('Error during sellCard:', error);
          }
        }


        // ... (previous JavaScript code) ...


      window.onload = function() {
        const userId = localStorage.getItem('userId');
        if (userId) {
          fetch(`http://localhost:8080/user/${userId}`, {
            method: 'GET',
          })
          .then(response => response.json())
          .then(userData => {
            console.log('User data:', userData);
            updateUserInfo(userData);
          })
          .catch(error => {
            console.error('Error fetching user data:', error);
          });
        }
        }

        function updateUserInfo(userData) {
          // Update user information in the navbar
          const userMoney = userData.money || 0;
          const username = userData.username || 0;
          document.getElementById('userMoney').textContent = `Money: $${userMoney}`;
            document.getElementById('userName').textContent = `username: ${username}`;


        }

        // ... (remaining JavaScript code) ...
