# SpringFormAPI

Ce référentiel contient une application Spring Boot développée pour exposer des services Web en tant qu'API REST, permettant la manipulation de formulaires avec différents types de champs.

## Services Web disponibles

1. Web service 1 - Lecture de formulaire texte :
   Ce service permet de lire un formulaire contenant des champs texte et de récupérer les données sous forme de JSON.

2. Web service 2 - Lecture de formulaire avec liste déroulante :
   Ce service permet de lire un formulaire contenant une liste déroulante et de récupérer les données associées sous forme de JSON.

3. Web service 3 - Lecture de formulaire avec liste déroulante choix multiple :
   Ce service permet de lire un formulaire contenant une liste déroulante à choix multiple et de récupérer les données sélectionnées sous forme de JSON.

4. Web service 4 - Exposition d'objets en API REST :
   Ce service permet d'exposer des objets complexes via des API REST, offrant des opérations CRUD (Create, Read, Update, Delete).

5. Web service 5 - Transformation de formulaire et renvoi d'objet :
   Ce service lit un formulaire, effectue une transformation spécifiée et renvoie l'objet résultant sous forme de JSON.

## Services d'accès à la base de données

6. Persister un objet dans la base de données :
   Ce service permet de sauvegarder un objet dans la base de données à l'aide d'une couche de persistance.

7. Récupérer un objet depuis la base de données, le transformer en JSON et le renvoyer :
   Ce service permet de récupérer un objet depuis la base de données, de le transformer en format JSON et de le renvoyer en réponse à une requête.
