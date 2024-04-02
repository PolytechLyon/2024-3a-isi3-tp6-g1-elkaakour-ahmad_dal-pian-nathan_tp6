# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme :
El Kaakour Ahmad
Dal Pian Nathan

## Exercices 1
Le patron de conception qui reflète ce modèle est le patron de conception composite.
Dans ce modèle :
L'interface **MobileObject** définit le *composant*, cette interface déclare des opérations communes à tous les objets mobiles, telles que la récupération de la vitesse et de la masse.

La classe **Vehicle** représente le *composite*, elle agrège des objets mobiles (qui peuvent être soit des véhicules, soit d'autres composants de véhicules).Cette classe implémente les méthodes de l'interface MobileObject en calculant la vitesse moyenne pondérée et la masse totale à partir de ses composants. 

Nous avons créé la classe **TagAlongBike** qui représente un vélo parental traînant un vélo d'enfant. 
Cette classe hérite de la classe abstraite **Bike** et nous avons ajouté les composants : un *simpleBike* et deux roues. 
Nous ne sommes pas obligés de réécrire les méthodes getVelocity() et getMass() car elles sont déjà implémentées par Vehicle 
depuis laquelle la classe Bike est héritée.


## Exercices 2

Le patron de conception utilisé par la méthode **getVelocity()** pour parcourir les composants d'un véhicule est le patron de conception itérateur.
L'avantage de ce patron est qu'il permet de parcourir les éléments d'une collection sans exposer la structure interne de la collection.

Après la modification de la structure de données utilisée pour stocker les composants d'un véhicule de Set à List, il n'est pas nécessaire de modifier la réalisation de la méthode **getVelocity()** car cette méthode parcourt simplement les composants du véhicule à l'aide d'un itérateur, et cela fonctionne de la même manière indépendamment de la structure de données utilisée pour stocker les composants.

## Exercices 3


Pour réaliser ce pattern, il faut tout d'abord rendre le constructeur de la classe **Clock** *privé*, puis créer un attribut static *instance* qui sera l'instance de notre classe **Clock** commune à toute les classes.
Ensuite, il faut une méthode static **getInstance()** qui retourne l'instance commune et la créer si ce n'est pas déjà fait.
```java
public static Clock getInstance(){
    if (instance == null)
        instance = Clock();
    return instance;
}
```
Finalement, dans la classe **Wheel** nous devons remplacer la ligne 
```java
private final Clock clock = new Clock();
```
par
```java
private final Clock clock = Clock.getInstance();
```

## Exercices 4

Les classes `Bike` et `wheel` ne sont pas dans le même paquetage.
Le type de dépendace est une association dirigée de `Wheel` vers `Bike`.
Cette dépendance n'adhère pas aux bonnes pratiques de conception, car ces deux classes ne sont pas dans le même paquetage.

Dans la fonction **getVelocity()** de la classe `Wheel`, on utilise la fonction **getPush()** de la classe `Bike`.
Il y a bien une abstraction qui isole cette fonctionnalité et c'est la classe `Vehicle` qui se trouve dans le même paquetage que `Wheel`.

Nous avons eu besoin de modifier uniquement la classe `Wheel` en remplaçant l'attribut *drive* de la classe `Bike` en une instance de la classe `Vehicle`.

## Exercices 5

Pour réaliser le patron de conception de méthode, comme les deux classes `FileLogger` et `ConsoleLogger` qui héritent de la classe abstraite `NamedLogger`, implémentent la méthode commune **log(String format, Object... args)**, nous avons créée une méthode **Writelog()** abstraite dans `NamedLogger`, et implémentée  dans ces deux classes afin d'éviter la duplication de code.

Dans `ConosleLogger`
```java
protected void writeLog(String message) {
        System.out.print(message);
    }
```
Dans `FileLogger`
```java
protected void writeLog(String message) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)) {
            fileWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
```

## Exercices 6

Pour centraliser le choix de réalisation de l'interface `Logger`, nous avons créée une classe `LoggerFactory` qui contient une méthode **getLogger()** afin de retourner une instance de la classe `Logger`.

Le design pattern singleton permet d'assurer une unique instance de la classe. Tandis que le design pattern Factory permet d'instancier des instances d'une classe unique.

## Exercices 7

Pour appliquer le design pattern **Decorator**, nous avons créé la classe abstraite `LoggerDecorator`(équivalent de la classe Decorater), qui implémente l'interface `Logger`, 
et la classe `TimestampedLoggerDecorator`(équivalent du DecoraterConcret) qui étend la classe `LoggerDecorator`. 

La classe `LoggerDecorator` possède un attribut logger de type `Logger`. 

Tandis que la classe `TimestampedLoggerDecorator` implément la fonction **log** hérité :

```java
public void log(String format, Object... args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());
        String updatedFormat = date + " : " + format;
        logger.log(updatedFormat, args);
    }
```

## Exercices 8

La classe `Context` suit un design pattern **Facade** vis à vis de la classe `ServiceLoader`.

On peut instancier un nouveau `Bike` sans utiliser *new* comme cela : 
```java 
Bike bike = Context.inject(Bike.class);
```
Pour instancier un `TagAlongBike` à la place d'un `SimpleBike` il suffit de remplacer la ligne "fr.polytech.sim.cycling.SimpleBike" dans `fr.polytech.sim.cycling.Bike` par "fr.polytech.sim.cycling.TagAlongBike".

Il peut y avoir plusieurs lignes dans le fichier `fr.polytech.sim.cycling.Bike`.
Cependant, seul la première ligne est instancié avec la fonction **inject** de `Context`.

## Exercices 9

Le patron de conception proposé par cette méthode et le design patter Iterator.

```java
public static <T> Iterator<T> injectAll(Class<T> klass) {
        return ServiceLoader.load(klass).iterator();
    }
```

```java
Iterator<Bike> bikeIterator = Context.injectAll(Bike.class);

Bike bike;

if (bikeIterator.hasNext()) {
    bike = bikeIterator.next();
    this.logger.log("Bike's speed %.2f Km/h.", bike.getVelocity());
    this.logger.log("Bike's mass %.2f Kg.", bike.getMass());
}

if (bikeIterator.hasNext()) {
    bike = bikeIterator.next();
    this.logger.log("TagAlongBike's speed %.2f Km/h.", bike.getVelocity());
    this.logger.log("TagAlongBike's mass %.2f Kg.", bike.getMass());
}
```
