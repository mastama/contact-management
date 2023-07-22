# Address API Spec

## Create Address
Endpoint: POST /api/contacts/{idContact}/addresses

Request Header:
- X-API-TOKEN: Token (Mandatory)

RequestBody:
````json
{
  "street": "Jalanin aja dulu",
  "city": "Kota",
  "province": "provinsi",
  "country": "negara",
  "postalCode": "kodepos"
}
````

ResponseBody (Success):
````json
{
  "responseCode": "00",
  "responseDesc": "Success",
  "data": {
    "id": "random string",
    "street": "Jalanin aja dulu",
    "city": "Kota",
    "province": "provinsi",
    "country": "negara",
    "postalCode": "kodepos"
  }
}
````

ResponseBody (Failed):
````json
{
  "responseCode": "07",
  "responseMessage": "Address is not found!",
  "data": {}
}
````



## Update Address
Endpoint: PUT /api/contacts/{idContact}/addresses/{idAddress}

Request Header:
- X-API-TOKEN: Token (Mandatory)

RequestBody:
````json
{
  "street": "Jalanin aja dulu",
  "city": "Kota",
  "province": "provinsi",
  "country": "negara",
  "postalCode": "kodepos"
}
````

ResponseBody (Success):
````json
{
  "responseCode": "00",
  "responseDesc": "Success",
  "data": {
    "id": "random string",
    "street": "Jalanin aja dulu",
    "city": "Kota",
    "province": "provinsi",
    "country": "negara",
    "postalCode": "kodepos"
  }
}
````

ResponseBody (Failed):
````json
{
  "responseCode": "07",
  "responseMessage": "Address is not found!",
  "data": {}
}
````



## Get Address
Endpoint: GET /api/contacts/{idContact}/addresses/{idAddress}

Request Header:
- X-API-TOKEN: Token (Mandatory)

ResponseBody (Success):
````json
{
  "responseCode": "00",
  "responseDesc": "Success",
  "data": {
    "id": "random string",
    "street": "Jalanin aja dulu",
    "city": "Kota",
    "province": "provinsi",
    "country": "negara",
    "postalCode": "kodepos"
  }
}
````

ResponseBody (Failed):
````json
{
  "responseCode": "07",
  "responseMessage": "Address is not found!",
  "data": {}
}
````



## Remove Address
Endpoint: DELETE /api/contacts/{idContatc}/addresses/{idAddress}

Request Header:
- X-API-TOKEN: Token (Mandatory)


ResponseBody (Success):
````json
{
  "responseCode": "00",
  "responseMessage": "Success",
  "data": "Your address is deleted!"
}
````

ResponseBody (Failed):
````json
{
  "responseCode": "07",
  "responseMessage": "Address is not found!",
  "data": {}
}
````



## List Address
Endpoint: GET /api/contacts/{idContact}/addresses

Request Header:
- X-API-TOKEN: Token (Mandatory)


ResponseBody (Success):
````json
{
  "responseCode": "00",
  "responseDesc": "Success",
  "data": [
    {
      "id": "random string",
      "street": "Jalanin aja dulu",
      "city": "Kota",
      "province": "provinsi",
      "country": "negara",
      "postalCode": "kodepos"
    }
  ]
}
````

ResponseBody (Failed):
````json
{
  "responseCode": "07",
  "responseMessage": "Address is not found!",
  "data": {}
}
````