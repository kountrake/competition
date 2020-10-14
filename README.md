# Compétitions Sportives

Le but de ce premier projet est de réaliser une application permettant d'organiser des matchs et des compétitions 
regroupant plusieurs matchs entre différents compétiteurs.

## Pour commencer...

* Chaque match se termine forcément sur la victoire d'un des deux compétiteurs.
* Les championnats se jouent en match aller/retour.
* Les tournois à élimination directe se réalise en plusieurs tours. Seuls les compétiteurs ayant gagné leur match passent
au tour suivant

## Prérequis pour l'utilisation de ce projet

### Git

Avant toutes choses il est nécessaire de posséder [Git](https://git-scm.com/book/fr/v2/D%C3%A9marrage-rapide-Installation-de-Git) 
afin de récupérer le dépôt du projet.

### Maven

Afin d'automatiser différentes tâches nous avons fait le choix d'inclure à notre projet Maven qui est un outil puissant permettant
de faciliter et d'accélérer l'exécution de tâches telles que la compilation des sources, la réalisation des tests, production
d'un .jar, ...

Il faut donc également posséder [Maven](https://maven.apache.org/install.html) afin de réaliser toutes ces tâches en 
utilisant les différentes commandes de Maven.


## Utilisation du dépôt

#### Récupération du dépôt Git

Il est d'abord primordiale de récupérer le dépôt git du projet. Pour cela il vous faut vous placer dans le dossier où 
vous voulez placer le dépôt.

Exécuter ensuite la commande:

```
    git clone git@gitlab-etu.fil.univ-lille1.fr:naessens/coo-s5-2020.git
```
Cette commande vous permet de récupérer le dépôt via SSH. Dans le cas où cela ne fonctionnerait pas, vous devez 
configurer et créer un clé ssh. Merci de vous référer à l'aide disponible [ici](https://git-scm.com/book/fr/v2/Git-sur-le-serveur-G%C3%A9n%C3%A9ration-des-cl%C3%A9s-publiques-SSH).

Dans le cas où vous voudriez récupérer le dépôt via HTTPS (sans configurer de SSH) utilisez cette commande:

```
    git clone https://gitlab-etu.fil.univ-lille1.fr/naessens/coo-s5-2020.git
```

#### Commandes Maven 

Tous les fichiers générer se retrouvent dans le dossier _/target/_.

##### <ins>Compiler les sources</ins>
On peut maintenant compiler les sources. Placez-vous à l'origine du dépôt et exécutez la commande :

```
    mvn compile
```

Ces fichiers sont compilés dans le dossier _/classes/_.

##### <ins>Générer le .jar</ins>

Si vous voulez générer le .jar, exécutez la commande :

```
    mvn package
```
Celui-ci portera le nom _Competition-project-2.0-SNAPSHOT.jar_

##### <ins>Générer la javadoc</ins>
Afin de générer la javadoc, il vous faut utiliser la commande :

```
    mvn javadoc:javadoc
```

Cette dernière est générée dans le dossier _/site/apidocs/_
##### <ins>Lancer les test</ins>
Pour exécuter l'ensemble des tests, utilisez la commande :

```
    mvn test
```
Chaque classe de test sera compilée et les tests seront exécutés. Un résumé de l'exécution des tests est ainsi affiché
durant l'exécution des tests.

Un dossier est également généré est vous y retrouverez le résultat de chacune des classes de test. Ces résultats sont 
disponibles dans le dossier _/surefire-reports/_

##### <ins>Nettoyer le dépôt</ins>

Afin de supprimer tous les fichiers générés par Maven, vous pouvez exécuter la commande :
```
    mvn clean
```


## Autheurs

* **David Lucas** 
* **Naessens Bastien**

## IDE utilisés

Intellij Idea Ultimate ([lien](https://www.jetbrains.com/fr-fr/idea/))
