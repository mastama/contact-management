# Contact API Spec

## Create Contact
Endpoint: POST /api/contacts/create

Request Header:
- X-API-TOKEN: Token (Mandatory)

RequestBody:
````json
{
  "firstName": "Singgih",
  "lastName": "Pratama",
  "email": "mastama@teatech.com",
  "phone": "08123456789"
}
````

ResponseBody (Success):
````json
{
  "responseCode": "00",
  "responseMessage": "Success",
  "data": {
    "id": "random string",
    "firstName": "Singgih",
    "lastName": "Pratama",
    "email": "mastama@teatech.com",
    "phone": "08123456789"
  }
}
````

ResponseBody (Failed):
````json
{
  "responseCode": "05",
  "responseMessage": "Email format invalid, phone format invalid, ...",
  "data": {}
}
````


## Update Contact
Endpoint: PUT /api/contacts/{idContact}

Request Header:
- X-API-TOKEN: Token (Mandatory)

RequestBody:
````json
{
    "firstName": "Singgih",
    "lastName": "Pratama",
    "email": "mastama@teatech.com",
    "phone": "08123456789"
}
````
ResponseBody (Success):
````json
{
  "responseCode": "00",
  "responseMessage": "Success",
  "data": {
    "id": "random string",
    "firstName": "Singgih",
    "lastName": "Pratama",
    "email": "mastama@teatech.com",
    "phone": "08123456789"
  }
}
````
ResponseBody (Failed):
````json
{
  "responseCode": "05",
  "responseMessage": "Email format invalid, phone format invalid, ...",
  "data": {}
}
````


## Get Contact
Endpoint: GET /api/contacts/{idContact}

Request Header:
- X-API-TOKEN: Token (Mandatory)

ResponseBody (Success):
````json
{
  "responseCode": "00",
  "responseMessage": "Success",
  "data": {
    "id": "random string",
    "firstName": "Singgih",
    "lastName": "Pratama",
    "email": "mastama@teatech.com",
    "phone": "08123456789"
  }
}
````

ResponseBody (Failed):
````json
{
  "responseCode": "06",
  "responseMessage": "Contact is not found!",
  "data": {}
}
````


## Search Contact
Endpoint: GET /api/contacts

Query Param:
- name: String, contact firstName or lastName, using like query. Optional
- phone: String, contact phone, using like query. Optional
- email: String contact email, using like query. Optional
- page : Integer, start from 0, default 0
- size : Integer, default 10

Request Header:
- X-API-TOKEN: Token (Mandatory)

ResponseBody (Success):
````json
{
  "responseCode": "00",
  "responseMessage": "Success",
  "data": [
    {
      "id": "random string",
      "firstName": "Singgih",
      "lastName": "Pratama",
      "email": "mastama@teatech.com",
      "phone": "08123456789"
    }
  ],
  "paging": {
    "currentPage": 0,
    "totalPage": 10,
    "size": 10
  }
}
````

ResponseBody (Failed):
````json
{
  "responseCode": "03",
  "responseMessage": "Unauthorized!",
  "data": {}
}
````


# Remove Contact
Endpoint: DELETE /api/contacts/{idContact}

Request Header:
- X-API-TOKEN: Token (Mandatory)

ResponseBody (Success):
````json
{
  "responseCode": "00",
  "responseMessage": "Success",
  "data": "Your contact is deleted!"
}
````

ResponseBody (Failed):
````json
{
  "responseCode": "06",
  "responseMessage": "Contact is not found!",
  "data": {}
}
````