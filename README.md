## **API REST Examen Service**

# Desarrollado con:
Java 8
Maven 3.6.3
Spring-Boot 2.5.0
H2 1.4.194

# compilar y generar el jar en el target y repositorio
```
mvn clean install 
```

# Levantar el servicio local
```
mvn spring-boot:run
```

# ACCEDER A LA INTERFAZ Swagger-UI
http://localhost:8092/swagger-ui.html#/

# SE ADJUNTA COLLECCION DE POSTMAN CON LAS PETICIONES SOLICITADOAS
{examen.postman_collection.json}

## CONSUMIR SERVICIO
# LISTADO DE CUENTAS
METODDO: GET
URI: http://localhost:8092/demo/accounts
RESPONSE CODE: 200
POSTMAN: getAccounnts

# EL SERVICIO YA TIENE CUENTAS EN LA BASE DE DATOS PERO SI SE REQUIERE CREAR MAS
# CREAR CUENTA
METODO: POST
URI: http://localhost:8092/demo/createAccount
RESPONSE CODE: 201
POSTMAN: createAccount
JSON
``` 
{
    "account" : 543219878,
	"balance" : 67512.00,
	"owner" : 765123888,
	"createdAt" : "2022-08-10 11:21:21.19222"
}
```
>NOTA1: createdAt la fecha debe ser enviada como cadena con el formato yyyy-MM-dd HH:mm:ss.ms y sera enviada a la base de datos como Timestamp
>NOTA2: utilizando el principio de idempotencia si se envia una cuenta con un account existe, esta no se crea y tampoco se actualiza, debido a que ya existe una en la base de datos.

# TRANSFERIR DINERO
METODO: POST
URI: http://localhost:8092/demo/createTransfer
RESPONSE CODE: 201
POSTMAN: createTransfer
JSON
``` 
{
	"fromAccount" : 123456789,
	"toAccount" : 13456658,
	"amount" : 201.00
}
```
>NOTA1: las cuentas deben existir en la base de datos de lo contrario recibira un error

# HISTORICO DE TRANSACCIONES
METODO: GET
URI: http://localhost:8092/demo/transactions
RESPONSE CODE: 200
POSTMAN: getTrasactions
>NOTA1: lista todas las transacciones

# HISTORICO DE TRANSACCIONES
METODO: GET
URI: http://localhost:8092/demo/send-transactions/{fromAccount}
RESPONSE CODE: 200
POSTMAN: listAllSendTransactions
>NOTA1: lista todas las transacciones que fueron enviadas por una cuenta especifica
>NOTA2: el pathparam es una cuenta existente que haya enviado una transaccion

# HISTORICO DE TRANSACCIONES
METODO: GET
URI: http://localhost:8092/demo/recibe-transactions/{toAccount}
RESPONSE CODE: 200
POSTMAN: listAllRecibeTransactions
>NOTA1: lista todas las transacciones que fueron recibidas por una cuenta especifica
>NOTA2: el pathparam es una cuenta existente que haya recibido una transaccion

# BALANCE DE LA CUENTA
METODO: GET
URI: http://localhost:8092/demo/balance/{account}
RESPONSE CODE: 200
POSTMAN: getBalance
>NOTA1: el pathparam es una cuenta existente en la base de datos