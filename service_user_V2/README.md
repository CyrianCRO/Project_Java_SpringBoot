# Microservice User

Ce microservice gère les utilisateurs et leurs informations associées.

## Endpoints

### Créer un utilisateur

- URL: `/api/user`
- Méthode: POST
- Corps de la requête :
  - `username`: Nom d'utilisateur (String)
  - `password`: Mot de passe (String)
- Réponse: Un objet CardUser contenant les informations de l'utilisateur créé.

### Récupérer tous les utilisateurs

- URL: `/api/users`
- Méthode: GET
- Réponse: Une liste d'objets CardUserDTO contenant les informations essentielles des utilisateurs (userId, username et money).

### Récupérer un utilisateur par ID

- URL: `/api/user/{id}`
- Méthode: GET
- Paramètre d'URL: 
  - `id`: ID de l'utilisateur (Integer)
- Réponse: Un objet CardUserDTO contenant les informations essentielles de l'utilisateur (userId, username et money).

### Récupérer un utilisateur par nom d'utilisateur

- URL: `/api/user/{username}`
- Méthode: GET
- Paramètre d'URL: 
  - `username`: Nom d'utilisateur (String)
- Réponse: Un objet CardUser contenant toutes les informations de l'utilisateur.

### Mettre à jour les informations d'un utilisateur

- URL: `/api/user/{id}`
- Méthode: PUT
- Paramètre d'URL: 
  - `id`: ID de l'utilisateur (Integer)
- Corps de la requête :
  - `username`: Nom d'utilisateur (String, optionnel)
  - `password`: Mot de passe (String, optionnel)
  - `money`: Montant d'argent (int, optionnel)
- Réponse: Un objet CardUser contenant les informations de l'utilisateur mis à jour.

### Supprimer un utilisateur

- URL: `/api/user/{id}`
- Méthode: DELETE
- Paramètre d'URL: 
  - `id`: ID de l'utilisateur (Integer)
- Réponse: Un message de confirmation indiquant que l'utilisateur a été supprimé.

## Modèles de données

### CardUser

- `userId`: Identifiant de l'utilisateur (Integer)
- `username`: Nom d'utilisateur (String)
- `password`: Mot de passe (String)
- `money`: Montant d'argent (int)

### CardUserDTO

- `userId`: Identifiant de l'utilisateur (Integer)
- `username`: Nom d'utilisateur (String)
- `money`: Montant d'argent (int)