# Flyway Starting Command
```bash
./mvnw flyway:repair -Dflyway.url=jdbc:mysql://127.0.0.1/prepa_concours -Dflyway.user=root -Dflyway.password=root
```
Or  
```bash
mvn flyway:repair -Dflyway.url=jdbc:mysql://127.0.0.1/prepa_concours -Dflyway.user=root -Dflyway.password=root
```

# Utils Flyway cmd

## 1. Running Migration
```bash
./mvnw flyway:migrate -Dflyway.url=jdbc:mysql://127.0.0.1/prepa_concours -Dflyway.user=root -Dflyway.password=root
```
## validate migrations 

```bash
./mvnw flyway:validate -Dflyway.url=jdbc:mysql://127.0.0.1/prepa_concours -Dflyway.user=root -Dflyway.password=root
```

## Get informations 

```bash 
./mvnw flyway:inf
```

## Repaire if necessary

``` bash
./mvnw flyway:repair
```


## clean if necesaary 
 
 
```bash 
./mvnw flyway:clean
```
dans le cas particulier de clean il faut ajouter le falg qui autorise l'activation du clean la commande final e devient donc 
 
 ```bash 
./mvnw flyway:clean -Dflyway.cleanDisabled=false    
```

## Initialise Flyway in existing database 

```bash 
./mvnw flyway:baseline
```

## Starting project

You can easilly start project by running commande 

```bash 
./mvnw spring-boot:run or
```
OR 

```bash 
mvn spring-boot:run or
```

## For reload dependencies 

```bash
mvn dependency:tree
```
