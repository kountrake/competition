# Compétitions Sportives

Le but de ce premier projet est de réaliser une application permettant d'organiser des matchs et des compétitions 
regroupant plusieurs matchs entre différents compétiteurs.

## Pour commencer...

* Chaque match se termine forcément sur la victoire d'un des deux compétiteurs.
* Les championnats se jouent en match aller/retour.
* Les tournois à élimination directe se réalise en plusieurs tours. Seuls les compétiteurs ayant gagné leur match passent
au tour suivant


### Compiler les fichiers 

Pour compiler l'ensemble des sources il faut au préalable créer un dossier classes

```
    mkdir classes
```

On peut maintenant compiler les sources

```
    javac src/*/*.java -d classes
```

Pour créer le .jar

```
    jar cvf Competition.jar classes/*/*.class
```


Pour générer la javadoc

```
    mkdir doc
    javadoc -d doc src/*/*
```
## Lancer les test

Nous avons fait le choix d'utiliser JUNIT 5 et il faut donc télécharger le .jar au préalable

```
    wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0.jar
```

/!\ Lancement manuel des tests encore impossible...



### Problèmes rencontrés

Nous n'avons pu terminer car nous avons voulu créer la classe tournament en ayant comme fonction d'execution du tournoi 
une fonction récursive. Problème, les matchs nécessitant la génération d'un Random, cette dernière classe génère une
erreur au vu du nombre de random et de seed nécessaire dans les appelles récursifs. Il nous aurait donc fallu revoir 
notre code afin de ne plus avoir cette erreur.

L'utilisation d'un IDE nous facilitant certaines tâches telles que la compilation des sources et l'exécution des tests
rend finalement l'exécution et l'écriture manuelle des commandes pour le Readme compliquées. 


## Autheurs

* **David Lucas** 
* **Naessens Bastien**

##IDE utilisés

Intellij Idea Ultimate
