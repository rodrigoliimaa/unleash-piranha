# Unleah-Prianha 

### ¤ Start application

```sh
mvn spring-boot:run
```

Navigate to: http://localhost:9090 to see a basic feature flag. 

Navigate to: http://localhost:9090/variants to see a variant flag.

Both flags (`Demo` and `DemoVariant`) are controlled here:
http://unleash.herokuapp.com/


### ¤ Run Piranha magic

```sh
mvn clean compile -Ppiranha
```