Calculadora Spring-Boot
Calculadora micro-servicio utilizando Spring-boot y Maven con funcionalidades básicas de sumar y restar pero escalable.

Contiene la integración de las librerías locales tracer en maven mediante el maven-install-plugin por lo que es necesario ejecutar mvn clean install antes de poder utilizar el proyecto.

Para crear el jar debemos crear una instalación limpia de maven. Para ello abrir una consola y ejecutar:

cd test-calculadora
mvn validate
mvn verify
mvn clean install

Con los pasos anteriores debemos tener creada una carpeta /target con el JAR del programa springboot_calculadora-0.0.1-SNAPSHOT.jar.

Para levantar el microservicio: 
java -jar target/calculadora-spring-boot.jar

Con el comando anterior deberiamos tener una API REST escuchando en http://localhost:8080/api/calculator/operations

Ejecutar tests:
Ejecutar el siguiente comando: mvn clean test.


Como llamar al endpoit
1. Swagger: http://localhost:8080/swagger-ui/index.html
2. Request URL: http://localhost:8080/api/calculator/operations?operator=%2B&numb1=5&numb2=4.

