# Atelier 2

## Routes
Les routes suivantes ont été mises en places:  
`/auth`  
Permet de s'authentifier  
`/cards/{id}`  
Permet de récupérer toutes le carte pour le user passé en paramètre  
`/addCard`  
Permet d'ajouter une carte pour le user donné dans le body  
`/cards/delete/{id}`  
Permet la supression de la carte passée en paramètre  
`/card/id`  
Permet d'obtenir la carte passée en paramètre  
`/transaction/buy/{id}`  
Permet d'acheter une carte  
`/transaction/sell/{id}`  
Permet de mettre une carte en vente  
`/createUser`  
Permet la création d'un utilisateur  

Une collection postman est disponible à la racine du projet pour tester les différentes routes.

## Frontend

Deux pages sont disponibles dans le dossier `atelier2_frontend` à la racine du projet pour tester les routes:  
`card.html`  
Permet de tester la réucpération du carte afin d'afficher ses informations.  
`cardList.html`  
Permet de lister les cartes d'un user et de les mettre en vente.  
La partie authentification et achat d'une carte n'a pas été implémentée dans le frontend.
