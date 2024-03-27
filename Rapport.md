# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme :
El Kaakour Ahmad
Dal Pian Nathan

## Exercices 1
Le patron de conception qui reflète ce modèle est le patron de conception composite.
Dans ce modèle :
L'interface MobileObject définit le composant, cette interface déclare des opérations communes à tous les objets mobiles,telles que la récupération de la vitesse et de la masse.

La classe Vehicle représente le composite, elle agrège des objets mobiles (qui peuvent être soit des véhicules, soit d'autres composants de véhicules).Cette classe implémente les méthodes de l'interface MobileObject en calculant la vitesse moyenne pondérée et la masse totale à partir de ses composants. 

Nous avons créé la classe TagAlongBike qui représente un vélo parental traînant un vélo d'enfant. Cette classe hérite de la classe abstraite Bike et nous avons ajouté les composants : un simpleBike et deux roues. Nous sommes pas obligés de réécrire les méthodes getVelocity() et getMass() car elles sont déjà implémentées par Vehicle depuis laquelle la classe Bike est héritée.


## Exercices 2

Le patron de conception utilisé par la méthode **getVelocity()** pour parcourir les composants d'un véhicule est le patron de conception itérateur.
L'avantage de ce patron est qu'il permet de parcourir les éléments d'une collection sans exposer la structure interne de la collection.

Après la modification de la structure de données utilisée pour stocker les composants d'un véhicule de Set à List, il n'est pas nécessaire de modifier la réalisation de la méthode **getVelocity()** car cette méthode parcourt simplement les composants du véhicule à l'aide d'un itérateur, et cela fonctionne de la même manière indépendamment de la structure de données utilisée pour stocker les composants.



## Exercices 3

## Exercices 4

## Exercices 5

## Exercices 6

## Exercices 7

## Exercices 8


