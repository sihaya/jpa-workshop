jpa-workshop
============

De JPA workshop bevat een Java EE applicatie waarmee het mogelijk is om JPQL queries uit te voeren. De 
applicatie is volledig via Maven te draaien er zijn dus geen externe dependencies. De applicatie bestaat
uit een voorbeeld datamodel, bij het starten wordt de database gevuld met vooraf geconfigureerde gegevens.

Instructies voor installatie
============================

1. Download de zip (https://github.com/sihaya/jpa-workshop/archive/master.zip) en pak het uit  
of doe een checkout van het project via git
2. Zorg ervoor dat Maven 3 (http://maven.apache.org/download.cgi) of hoger geïnstalleerd is en te starten is vanaf de command line
3. Open een command line en ga naar de root van het project
4. Voer het onderstaande command uit

        mvn package tomee:run

5. Maven zal nu alle dependencies downloaden, het project bouwen en een embedded container genaamd     TomEE starten. Als je onderstaande melding ziet dan is het starten gelukt.

        INFO: Server startup in 3980 ms

5. De frontend is nu via de browser benaderbaar via http://localhost:8080/
6. Probeer de volgende query uit te voeren "select e from Employee e", hier moeten 4 resultaten voor terug komen

Instructies voor verdere ontwikkeling
=====================================
Je kan het project verder ontwikkelen met iedere IDE. Binnen Eclipse kan het project via de m2e plugin of "mvn eclipse:eclipse" 
geopend worden

Als je de standaardgegevens wilt aanpassen dan moet je het bestand "src/main/java/jpaworkshop/application/CompanyService.java"
aanpassen. Nadat het is aangepast moet wel de database geleegd worden, dit kan met het volgende commando: "mvn clean".
