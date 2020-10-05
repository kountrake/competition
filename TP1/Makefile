 JAVAC := javac
 CLASSES := -d classes
 SOURCES := -sourcepath src
 CLASSPATH := -cp test-1.7.jar
 SOURCEFILES := #Ajouter les fichiers à compiler dans les sources Main
 TESTFILES := #Ajouter les fichiers test à compiler
 SUFFIXES := .java .class

clear:
	rm -rf classes
	rm -rf doc
	rm -f test/*.class
	rm -f Rental.jar

%.class : %.java
	$(JAVAC) $(CLASSPATH) $(CLASSES) src/rental/$@.java

classes:
	mkdir classes

$(SOURCEFILES): classes
	$(JAVAC) $(CLASSPATH) $(CLASSES) src/rental/$@.java

compile.class: classes $(SOURCEFILES)

dir.doc:
	mkdir doc

javadoc: dir.doc
	javadoc -sourcepath src -subpackages rental -d doc

doc: javadoc

$(TESTFILES): compile.class
	$(JAVAC) $(CLASSPATH) test/$@.java

compile.test:$(TESTFILES)

Competition.jar: compile.class
	jar cvf Rental.jar classes/rental

all: Competition.jar compile.test doc
