# Application for Employee Information

## Build application with maven

```Bash
mvn clean install
```

## Run Application with maven

```Bash
mvn spring-boot:run
```

## Verify End Point Controller



### Create Pateint

```Bash
curl --location 'http://localhost:8080/pateint/save' \
--header 'Content-Type: application/json' \
--data {
    "name":"patient1",
    "id": "p1",
    "hospitalName": "hospital1",
    "age":55,
    "gender": "M"
}
```

### Read All Pateint Data

```Bash
curl --location 'http://localhost:8080/pateint/age/all'
```

### Update Pateint Data

```Bash
curl --location --request PUT 'http://localhost:8080/pateint/update?id=p1&hospitalName=Medica'
```

### Delete Pateint Data

```Bash
curl --location --request DELETE 'http://localhost:8080/pateint/delete?id=p1'
```
