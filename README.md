# Travel info
This is an application to get travel information taking into account the passport passed to the api. 
For now it reads the info from a .csv file directly. The file itself is from this open-source project: https://github.com/ilyankou/passport-index-dataset

## Technologies used

#Backend#
- Spring Boot
- Spring Web
- OpenCSV
- Webflux
- Spring cache

For more info check the pom.xml file

#Frontend#

- Vite
- Vue 3
- Vuex
- Vue Router

## How to run

- Clone git repository
- Build project in your IDE of choice, the one used in this application was IntelliJ.
- Run api on [:8080] using
```
$ java -jar target/travel-info-0.0.1-SNAPSHOT.jar
```
- You can call a GET to the api passing the passport as a path parameter, like:
```
  /travel-info/passport/BRL
```
- It will respond with a body containing a list of items with the origin, destination and travel requirement like this:

```
   "items": [
        {
            "passport": "Brazil",
            "destination": "Albania",
            "requirement": "90"
        },
        {
            "passport": "Brazil",
            "destination": "Algeria",
            "requirement": "visa required"
        },
        {
            "passport": "Brazil",
            "destination": "Andorra",
            "requirement": "90"
        },
        {
            "passport": "Brazil",
            "destination": "Angola",
            "requirement": "30"
        },
        {
            "passport": "Brazil",
            "destination": "Antigua and Barbuda",
            "requirement": "180"
        },
        {
            "passport": "Brazil",
            "destination": "Argentina",
            "requirement": "90"
        },
        {
            "passport": "Brazil",
            "destination": "Armenia",
            "requirement": "180"
        },
        {
            "passport": "Brazil",
            "destination": "Australia",
            "requirement": "e-visa"
        },
        {
            "passport": "Brazil",
            "destination": "Austria",
            "requirement": "90"
        },
        {
            "passport": "Brazil",
            "destination": "Azerbaijan",
            "requirement": "e-visa"
        }
    ],
    "totalItems": 199,
    "currentPage": 0,
    "totalPages": 20,
    "pageSize": 10 
```
