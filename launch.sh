
find . -name "*.class" -exec rm {} \;
rm -f simulation.txt
rm -f simulation.png

javac avaj/simulation/Simulation.java


java avaj.simulation.Simulation scenario.txt