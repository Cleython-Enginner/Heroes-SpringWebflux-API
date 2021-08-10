# Projeto realizado no Boootcamp Java Developer 

##  Criando seu gerenciador de super heróis da Marvel e da DC em uma API reativa com Spring Boot 

![Screenshot](https://github.com/Cleython-Enginner/Heroes-SpringWebflux-API/blob/main/img/heroes.jpg)

#### Vamos desenvolver uma API de gerenciamento de heróis utilizando Spring WebFlux, utilizada por empresas como Netflix e Pivotal, junto com a library reativa Reactor que atualmente é mantida pela VmWare. Além disso, usaremos o banco DynamoDb localmente para armazenar nossos dados e demonstrarei como realizar testes unitários da sua API com Junit e como gerar documentações simples por meio do Postman e também do Swagger.



### Configurações

 java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
 
 aws dynamodb list-tables --endpoint-url http://localhost:8000


swagger: http://localhost:8080/swagger-ui-heroes-reactive-api.html
