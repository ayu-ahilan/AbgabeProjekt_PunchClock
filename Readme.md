M223 Punchclock

Dieses Projekt ist eine PunchClock. (Auf Deutsch: Zeitstempflungsmaschine). 
Man kann sich Anmelden oder Registrieren und seinne Zeiten buchen. Man kann dazu auch noch
eingeben, an welchem Projekt man gearbeitet hat. Und dann noch eine Kategorie eingeben. 
Beim Projekt ist gedacht, dass man zum Beispiel die Firma erwähnt. Bei Kategorie wer gearbeitet hat.
Kann zum Beispiel für den Stundensatz verwendet werden.

Dieses Projekt ist die Aschlussarbeit des Modules 223. Im ÜK haben wir ein Basis-Projekt erhalten. Dieses Projekt baut darauf auf. 

Folgende Schritte sind notwendig um die Applikation zu erstellen und zu starten:

Stellen Sie sicher, dass OpenJDK 11 oder höher installiert und JAVA_HOME korrekt gesetzt ist.
Installieren Sie (falls noch nicht vorhanden) Apache Maven 3.8.1 oder höher
Wechseln Sie auf der Kommandozeile in den Ordner dieser Appliation. cd m223-helloworld-quarkus/
Starten Sie die Applikation mit

(Dieses Projekt wure mit IntelliJ und mithilfe vom Chrome Browser entwickelt)

./mvnw compile quarkus:dev

Die Anmelde Daten sind: Benutzername: test, Passwort: 1234

Folgende Dienste stehen während der Ausführung im Profil dev zur Verfügung:

Swagger API: http://localhost:8080/q/swagger-ui/

H2 Console: http://localhost:8080/h2/ Datenquelle: jdbc:h2:mem:punchclock Benutzername: zli Passwort: zli

Es hat schon einige Beispieldateien drin, zum testen. (import.sql)

    
Abweichungen zur Planung
    
Ich habe realisiert das CheckIn und CheckOut in Project überflüssig ist und weg gelassen.
Die UserID ist eigentlich auch überflüssig, da es im Entry drin ist.
Da jetzt keine UserID vorhanden ist, ist getUserID auch überflüssig.
Bei Project habe ich das update, da man es lieber ganz löschen sollte.
Ein paar methoden wurden namentlich geändert, wie zum Beispiel bei allen Klassen (getSingle...)





