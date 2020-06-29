# rest-example

Api Rest in Java - Base example to use in new exercises

## Run with docker
docker-compose up --build

No se pudo hacer que corra docker. Al tirar el comando mencionado arriba, no podía obtener la imagen del gradle. Esto se habló con Diego.

### Run in localhost

http://localhost:9090/greeting

http://localhost:9090/greeting?name=Diego


## Run locally with gradle

gradle build

java -jar build/libs/rest-service-0.0.1-SNAPSHOT.jar

### Run in localhost


**POST** http://localhost:8080/user -> Agrega un usuario definido en el body.

**POST** http://localhost:8080/login -> Endpoint para acceder al sistema. Requiere en el body credenciales y además el header para basic auth.

**GET** http://localhost:8080/users/{id} -> Devuelve un usuario

**PUT** http://localhost:8080/users/{id} -> Actualiza el usuario definido en la url, y se le pasa un nuevo user en el body.

**DELETE** http://localhost:8080/users/{id} -> Elimina el usuario especificado


No se pudieron realizar tests de la API debido a errores de configuración de Spring.



