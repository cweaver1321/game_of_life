# game_of_life
Conway's game of life implemented in Java

## build
From the root of the project run maven install.

`mvn install`

## run

Run the jar using the following format:

`java -jar game_of_life-1.0-SNAPSHOT.jar path/to/file/seedfile generations(int) millis-between-generations(long)`

Example:

`java -jar target/game_of_life-1.0-SNAPSHOT.jar src/test/resources/seed3.txt 200 100`

## test files of interest under /src/test/resources
```
seed3.txt is a seed for a pseudoperiod gun
seed4.txt is a seed for a glider
```