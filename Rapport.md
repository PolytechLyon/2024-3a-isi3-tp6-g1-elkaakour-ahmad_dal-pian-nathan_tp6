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

## Exercices 3

## Exercices 4

## Exercices 5

## Exercices 6

## Exercices 7

## Exercices 8


