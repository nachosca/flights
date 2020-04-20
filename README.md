# Flights


To create the docker image

docker build -t flights:1.0 .
#
To run the docker image

docker run -t -p 127.0.0.1:8080:8080 flights:1.0


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