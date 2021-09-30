M223 Punchclock
Folgende Schritte sind notwendig um die Applikation zu erstellen und zu starten:

Stellen Sie sicher, dass OpenJDK 11 oder höher installiert und JAVA_HOME korrekt gesetzt ist.
Installieren Sie (falls noch nicht vorhanden) Apache Maven 3.8.1 oder höher
Wechseln Sie auf der Kommandozeile in den Ordner dieser Appliation. cd m223-helloworld-quarkus/
Starten Sie die Applikation mit

./mvnw compile quarkus:dev

Folgende Dienste stehen während der Ausführung im Profil dev zur Verfügung:

Swagger API: http://localhost:8080/q/swagger-ui/

H2 Console: http://localhost:8080/h2/ Datenquelle: jdbc:h2:mem:punchclock Benutzername: zli Passwort: zli

Es hat schon einige Beispieldateien drin, zum testen. 