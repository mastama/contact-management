# User Api Spec

## Register User
Endpoint: POST /api/users

RequestBody:
```json
{
  "username": "singgih",
  "password": "teaTech",
  "name": "Singgih Pratama"
}
```
ResponseBody (Success):
```json
{
  "responseCode": "00",
  "responseDesc": "Success",
  "data": {
    "username": "singgih",
    "password": "teaTech",
    "name": "Singgih Pratama"
  }
}
```
ResponseBody (Failed):
````json
{
  "responseCode": "01",
  "responseDesc": "Error, username or password must not be blank!",
  "data": {}
}
````

## Login User
Endpoint: POST /api/auth/login

RequestBody:
```json
{
  "username": "singgih",
  "password": "teaTech" // buat menjadi hash
}
```
ResponseBody (Success):
```json
{
  "responseCode": "00",
  "responseDesc": "Success",
  "data": {
    "token": "TOKEN",
    "expiredAt": "usemillisecond"
  }
}
```
ResponseBody (Failed):
````json
{
  "responseCode": "02",
  "responseDesc": "Error. Wrong username or password!",
  "data": {}
}
````


## Get User
Endpoint: GET /api/users/current

Request Header:
- X-API-TOKEN: Token (Mandatory)

ResponseBody (Success):
```json
{
  "responseCode": "00",
  "responseDesc": "Success",
  "data": {
    "username": "singgih",
    "name": "Singgih Pratama"
  }
}
```
ResponseBody (Failed):
````json
{
  "responseCode": "03",
  "responseDesc": "Unauthorized!",
  "data": {}
}
````


## Update User
Endpoint: PATCH /api/users/current

Request Header:
- X-API-TOKEN: Token (Mandatory)

[//]: # konsep yang digunakan parsial, maksudnya data yang dikirim gak harus keduanya bisa salah satu saja
makanya lebih baik menggunkan method(patch)

RequestBody:
```json
{
  "name": "Singgih Pratama", //put if only want to update name
  "password": "teaTech" //put if only want to update password
}
```
ResponseBody (Success):
```json
{
  "responseCode": "00",
  "responseDesc": "Success",
  "data": {
    "username": "singgih",
    "name": "Singgih Pratama"
  }
}
```
ResponseBody (Failed):
````json
{
  "responseCode": "04",
  "responseDesc": "Error, username or password false!",
  "data": {}
}
````



## Logout User
Endpoint: DELETE /api/auth/logout

Request Header:
- X-API-TOKEN: Token (Mandatory)

ResponseBody (Success):
```json
{
  "responseCode": "00",
  "responseDesc": "Success",
  "data": "Logout Success"
}