# Travel info
This is an application to get travel information taking into account the passport passed to the api. For now it reads the info from a .csv file directly. The file itself is from this open-source project: https://github.com/ilyankou/passport-index-dataset

## Technologies used

- Spring Boot
- Spring Web
- OpenCSV

For more info check the pom.xml file

## How to run

- Clone git repository
- Build project in your IDE of choice, the one used in this application was IntelliJ.
- Run application on [:8080] using
```
$ java -jar target/travel-info-0.0.1-SNAPSHOT.jar
```
- You can call a GET to the api passing the passport as a path parameter, like:
```
  /travel-info/passport/BRL
```
- It will respond with a body containing the origin, destination and travel requirement like this:

```
    {
        "passport": "BLR",
        "destination": "ZMB",
        "requirement": "visa on arrival"
    }
```
