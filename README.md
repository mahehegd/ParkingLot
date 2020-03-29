# ParkingLot
##To install the dependency and run unit tests
### Go to "parking_lot/bin" directory
```$xslt
./setup 
```
###Or
```
sh setup.sh
```
##To run the code in interactive mode
###Go to "parking_lot/bin" directory
```
./parking_lot
```
###Or
```$xslt
sh parking_lot.sh
```
##To run the code with a file input
###Go to "parking_lot/bin" directory
```$xslt
./parking_lot <absolute_path_to_input_file>
```
##To run the automated tests
```$xslt
./run_functional_tests
```

###Alternatively you can also install the dependencies and run the unit tests by 
####go to "parking_lot" dir and execute
```$xslt
mvn clean instal
```
###And run the code by 
for interactive console
```$xslt
java -jar target/ParkingLot-1.0.jar 
``` 
for file input
```
java -jar target/ParkingLot-1.0.jar src/main/resources/unitTestInput.txt
```