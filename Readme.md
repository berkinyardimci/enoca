# Getting Started

### Requirements
- JDK(17)
- PostgreSQL
- IDE (IntelliJ IDEA)

### Technologies
- Java
- Spring Boot(3.1.3)
- PostgresSQL

### Stages
##### 1-Clone the project
` git clone https://github.com/berkinyardimci/enoca.git `

##### 2-Go inside the project file
`cd enoca`

##### 3- Run PROJECT
`docker-compose up -d`

##### 4-Ready for Using the project
- http://localhost:8000/company/create
- http://localhost:8000/company/getAll
- http://localhost:8000/company/deleteById/{companyId}
- http://localhost:8000/company/updateById/{companyId}
- http://localhost:8000/personnel/create
- http://localhost:8000/personnel/updateById/{personnelId}
- http://localhost:8000/personnel/getAll/{companyId}

### Entity Classlari
#### Company
id -> Long

companyName -> String

taxId -> String

webSite -> String

type -> EType

personnelList -> List[PersonnelEntity]

#### Personnel

id -> Long

firstName -> String

lastName -> String

company -> Company

identityNumber -> String

### REQUESTS PAYLOADS AND RESULT EXAMPLES

```
Endpoint: localhost:8000/company/create
Request Method: Post
Payload:
{
    "companyName": "Apple",
    "taxId": "22244",
    "webSite" : "www.apple.com",
    "type": "CORPORATİON"
}
```

* RESULT
```
{
    {
    "httpStatus": "CREATED",
    "statusCode": 201,
    "message": "Şirket Oluşturuldu.",
    "localTime": "2023-09-17T23:23:00.190292",
    "data": {
        "id": 5,
        "companyName": "Apple",
        "taxId": "22244",
        "webSite": "www.apple.com",
        "type": "CORPORATİON"
    }
}
```

* Eğer aynı company'den bir tane daha oluşturulmaya çalışılırsa Duplice Veriler bulundu hatası alınır.<br>

```
{
    "httpStatus": "BAD_REQUEST",
    "statusCode": 400,
    "message": " Duplice Veriler bulundu",
    "localTime": "2023-09-17T23:23:56.225077",
    "errorInfoMap": {
        "Endpoint": "/",
        "HTTP Method": "POST",
        "HTTP URL": "http://localhost:8000/company/create",
        "HTTP URI": "/company/create"
    }
}
```
* Şirkete Personel eklenmelidir.

```
Endpoint: localhost:8080/personnel/create
Request Method: Post
Payload:
{
    "firstName": "berkin",
    "lastName": "yardımcı",
    "company_id" : 1,
    "identityNumber": "115679"
}
```
* RESULT
```
{
    "httpStatus": "CREATED",
    "statusCode": 201,
    "message": "Personel Oluşturuldu",
    "localTime": "2023-09-17T23:28:02.132533",
    "data": {
        "firstName": "berkin",
        "lastName": "yardımcı",
        "creationDate": "2023-09-17T20:28:02.120+00:00",
        "identityNumber": "112229",
        "companyName": "apple"
    }
}
```

* Şirkete Göre Personelleri listele.

```
Endpoint: http://localhost:8000/personnel/getAll/2
Request Method: Get
Result:
{
    "httpStatus": "OK",
    "statusCode": 200,
    "message": "Kullanıcı Listesi",
    "localTime": "2023-09-17T21:00:05.168151174",
    "data": [
        {
            "firstName": "berkin",
            "lastName": "yardımcı",
            "identityNumber": "112229"
        },
        {
            "firstName": "mehmet",
            "lastName": "kaya",
            "identityNumber": "11119"
        }
    ]
}
```

<b>Global Exception Handling için TAMAMEN GENERIC olarak bir yapı kurgulanmıştır.</b><br>
<b>INTERCEPTORLAR ile requestler alınmıştır ve bu requestin içerisinden gelen bilgiler ile hata mesajları dönülmüştür.</b>

