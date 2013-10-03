persona-java
============

Persona is yet another challenge app

config
---
src/main/resources/config.properties

    mongodb = mongodb://127.0.0.1:27017/persona

install
---

    mvn clean install

run
---
  
    java -jar -Dapple.awt.UIElement="true" target/persona-1.0-SNAPSHOT.jar -h
  
    Persona is yet another challenge app
    usage: persona
     -h,--help           help description
     -i,--import <arg>   input person csv or xml file
     -s,--search <arg>   search a person by name
   
   
import a file
---

    java -jar -Dapple.awt.UIElement="true" target/persona-1.0-SNAPSHOT.jar -i contacts.xml
    
    Persona is yet another challenge app

    3 record(s) wrong
    49997 record(s) imported 
    
search by name
---
    java -jar -Dapple.awt.UIElement="true" target/persona-1.0-SNAPSHOT.jar -s bill
    
    Persona is yet another challenge app

                  Billie	            Cheatham	[310-531-6790, 310-531-4437]
                   Billy	               Wight	[609-645-4469, 609-645-4018]
                    Bill	                Salk	[415-543-1140, 415-543-4688]
                   Billy	               Staal	[215-741-8013, 215-741-1688]
                  Billie	           Ethington	[913-642-2851, 913-642-3216]
                    Bill	               Likar	[541-389-3269, 541-389-8017]
                   Billy	               Wynne	[303-794-8094, 303-794-2257]
                    Bill	             Knutzen	[702-384-6490, 702-384-8114]
                  Billie	           Petrouits	[201-440-8188, 201-440-0577]
                  ...
      330 record(s) found
