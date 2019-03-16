# avaj_launcher
Basic Java project about making flight simulation

h2 Usage
```javac Main.java```
```java Main [scenario file]```

h2 Rules for scenario file
The first line of the file contains a *positive integer number*. This number represents the
number of times the simulation is run. In our case, this will be the number of times a
weather change is triggered.
Each following line describes an aircraft that will be part of the simulation, with this
format: ```TYPE NAME LONGITUDE LATITUDE HEIGHT```.
```LONGITUDE LATITUDE``` also must be *positive integer numbers* and ```HEIGHT``` must be in range from 1 to 100.
Each 3 dimensional point has its own weather such as **RAIN** **FOG** **SUN** or **SNOW**

h2 Aircraft Types
**JetPlane**
**Helicopter**
**Baloon**

<hr>

Executing the program will generate a file ```simulation.txt``` that describes the outcome
of the simulation. In every simulation loop aircrafts will output funny messages, wich define their current weather. Due to it they also will move corresponding weather conditions. If aircraft go below 0 height it lends, outputs last coordinates and unregister from weather tower.