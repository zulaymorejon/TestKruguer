Kruger-Test
Tecnología utilizada
Java 11
IDE Eclipse Versión: 2019 -Spring Boot Version 2.5.12 -Datos de la api
Nombre: service-empleadoKruguer
Puerto: 8080
Url documentación OpenApi: http://localhost:8080/swagger-ui.html (Se podra visualizar al ejecutar el microservicio)
Metodos: Get, Post, Put, Delete
Se utiliza el servidor tomcat embebido
Base de DatosPostgreSql 14
User: postgres
Password: admin123
Nombre de la base de datos: postgres (Se debe crear la base de datos antes de levantar el microservicio)
Consideraciones para la ejecución
Descargar el fuente de la rama master (git pull)
Crear la base de datos postgres
Importar el proyecto en el IDE
Click derecho sobre el proyecto y seleccionar Run ass -> Spring Boot App
Se podra encontrar los endpoints y ejemplos del request en la url http://localhost:8080/swagger-ui.html
Se deberan crear los empleados, ya que no contiene registros inicialmente.
Si detiene el microservicio, se eliminara toda la informacion en la base de datos postgres
