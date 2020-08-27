find . -name *.java > sources.txt
javac -sourcepath @sources.txt

java avaj.simulation.Simulation scenario.txt