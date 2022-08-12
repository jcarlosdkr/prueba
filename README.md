## **API REST Examen Service**

Desarrollado con: <br />
Java 8  <br />
Maven 3.6.3  <br />
Spring-Boot 2.5.0  <br />
H2 1.4.194  <br />

# compilar y generar el jar en el target y repositorio
```
mvn clean install 
```

# Levantar el servicio local
```
mvn spring-boot:run
```

# Interfaz Swagger-UI
http://localhost:8092/swagger-ui.html#/

# SE ADJUNTA COLLECCION DE POSTMAN CON LAS PETICIONES SOLICITADOAS
examen.postman_collection.json

# CONSUMIR SERVICIO
## LISTADO DE CUENTAS
METODDO: GET  <br />
URI: http://localhost:8092/demo/accounts  <br />
RESPONSE CODE: 200  <br />
POSTMAN: getAccounnts  <br />

# EL SERVICIO YA TIENE CUENTAS EN LA BASE DE DATOS PERO SI SE REQUIERE CREAR MAS
## CREAR CUENTA
METODO: POST  <br />
URI: http://localhost:8092/demo/createAccount  <br />
RESPONSE CODE: 201  <br />
POSTMAN: createAccount  <br />
JSON  <br />
``` 
{
    "account" : 543219878,
	"balance" : 67512.00,
	"owner" : 765123888,
	"createdAt" : "2022-08-10 11:21:21.19222"
}
```
>NOTA1: createdAt la fecha debe ser enviada como cadena con el formato yyyy-MM-dd HH:mm:ss.ms y sera enviada a la base de datos como Timestamp  <br />
>NOTA2: utilizando el principio de idempotencia si se envia una cuenta con un account existe, esta no se crea y tampoco se actualiza, debido a que ya existe una en la base de datos.

## TRANSFERIR DINERO
METODO: POST  <br />
URI: http://localhost:8092/demo/createTransfer  <br />
RESPONSE CODE: 201  <br />
POSTMAN: createTransfer  <br />
JSON  <br />
``` 
{
	"fromAccount" : 123456789,
	"toAccount" : 13456658,
	"amount" : 201.00
}
```
>NOTA1: las cuentas deben existir en la base de datos de lo contrario recibira un error

## HISTORICO DE TRANSACCIONES
METODO: GET  <br />
URI: http://localhost:8092/demo/transactions  <br />
RESPONSE CODE: 200  <br />
POSTMAN: getTrasactions  <br />
>NOTA1: lista todas las transacciones

## HISTORICO DE TRANSACCIONES
METODO: GET  <br />
URI: http://localhost:8092/demo/send-transactions/{fromAccount}  <br />
RESPONSE CODE: 200  <br />
POSTMAN: listAllSendTransactions  <br />
>NOTA1: lista todas las transacciones que fueron enviadas por una cuenta especifica  <br />
>NOTA2: el pathparam es una cuenta existente que haya enviado una transaccion  <br />

## HISTORICO DE TRANSACCIONES
METODO: GET  <br />
URI: http://localhost:8092/demo/recibe-transactions/{toAccount}  <br />
RESPONSE CODE: 200  <br />
POSTMAN: listAllRecibeTransactions  <br />
>NOTA1: lista todas las transacciones que fueron recibidas por una cuenta especifica  <br />
>NOTA2: el pathparam es una cuenta existente que haya recibido una transaccion  <br />

## BALANCE DE LA CUENTA
METODO: GET  <br />
URI: http://localhost:8092/demo/balance/{account}  <br />
RESPONSE CODE: 200  <br />
POSTMAN: getBalance  <br />
>NOTA1: el pathparam es una cuenta existente en la base de datos  <br />