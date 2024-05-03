# Rohemõõdik

## Juhend rakenduse käivitamiseks:

    1. Kloonida käesolev repo ning avada see lemmik IDEs (Microsoft Visual Studio/IntelliJ nt.)

    2. Laadida alla PostgreSQL andmebaas - server on vajalik rakenduse jooksutamiseks. Rakendus on ehitatud PostgreSQL 16-ga.

    3. src/main/resources/application.properties - lisada oma ühenduse URL ja postgres kasutaja ning parooli andmed - 
       vaikimisi on kasutaja postgres, URL jdbc:postgresql://localhost:5432/postgres ning parooli peab esmalt ise valima

    4. jooksutada terminalis käsk ./gradlew build 

    5. jooksutada rakendus (Run RohemoodikApplication)

    6. Liikuda front-end reposse (bakalaureus-ui)