# Flights


To create the docker image

docker build -t flights:1.0 .
#
To run the docker image

docker run -t -p 127.0.0.1:8080:8080 flights:1.0


#Swagger Api Documentation
Once the project is running, you can go to

http://localhost:8080/swagger-ui.html#/

where you'll be able to see all the exposed endpoints with examples of data structure expected and returned.


#Cities loaded
id | name

MAD	Madrid

BCN	Barcelona

BUE	Buenos Aires

MIA	Miami

NYC	New York City

#Example Post

```Post - http://localhost:8080/ticket```

```
{
    "departureDate": "2020-10-04",
    "arrivalDate": "2020-10-05",
    "origin": {
        "id": "BUE"
    },
    "destination": {
        "id": "BCN"
    },
    "name": "Roberto Splinter",
    "age": 31,
    "hasLuggage": true,
    "price": "123.32",
    "departureTime": "22:33",
    "arrivalTime": "22:32"
}
```


#Example Get
```Get http://localhost:8080/ticket/3```