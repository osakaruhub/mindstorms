package Drucksensor;							//die Klassen "Drucksensor1", "Drucksensor2" liegen alle im Package "Drucksensor"

import ch.aplu.ev3.*;							//importiert die Klassenbibliothek Ev3JLibA

public class Drucksensor1 						//die Klasse "Drucksensor1" führt die erste Aufgabe von den Drucksensoren aus 
{
  public Drucksensor1()
  {
	LegoRobot robot = new LegoRobot();				//deklariert und initialisiert ein neues LegoRobot Objekt mit dem Namen "robot"
	
	Gear gear = new Gear();						//erzeugt ein Fahrwerk namens "gear" mit Motoren an den Anschlüssen A und B 
	robot.addPart(gear);						//fügt dem Roboterobjekt "robot" das Fahtwerk "gear" zu
	
	TouchSensor ts = new TouchSensor(SensorPort.S1);		//am Sensorport 1 ist ein Touch-Sensor angeschlossen namens "ts"
	robot.addPart(ts);						//der Touch-Sensor (ts) wird zum "robot" hinzugefügt

	int strecke = 1000;						//in den Integer "strecke" wird der Wert 1000 gespeichert
        int grad90  = 700;						//in den Integer "grad90"  wird der Wert  700 gespeichert  
	  
	int counter = 0;						//in den Integer "counter" wird der Wert 0 gespeichert

	  
	gear.forward();							//der Roboter bewegt sich für eine unbestimmte Zeit nach vorne. Methode forward() ohne Parameter ist nicht blockierend
	
	//while (!robot.isEscapeHit())					//die while-Schleife ist in diesem Programm zwar nicht erforderlich, kann aber dennoch bei Bedarf eingebaut werden
	//{	
	   while(counter <= 5)						//die while-Schleife läuft solange bis der Wert für counter kleiner oder gleich 5 ist
	   {
		if(ts.isPressed() && counter % 2 == 0)			//ein if-Block, der ausgeführt wird wenn der Drucksensor (ts) ausgelöst wird und der Counter-Wert eine gerade Zahl ist (oder 0)
		{
		 gear.backward(strecke);				//der Lego-Roboter bewegt sich die vorgegebene Anzahl von Milisekunden nach hinten; bedeutet er fährt 3 Sekunden nach hinten            
		 gear.right(grad90);					//der Lego-Roboter dreht sich 0,7 Sekunden nach rechts. somit wird eine 90 grad Drehung erreicht 
		 gear.forward(strecke);					//der Lego-Roboter bewegt sich die vorgegebene Anzahl von Milisekunden nach vorne; bedeutet er fährt 3 Sekunden nach vorne
		 gear.right(grad90);					//der Lego-Roboter dreht sich um 90 grad nach rechts
		 gear.forward();					//der Roboter bewegt sich für eine unbestimmte Zeit nach vorne. Methode forward() ohne Parameter ist nicht blockierend
		 counter++;						//der counter Wert wird um 1 erhöht
		}
		
		if(ts.isPressed() && counter % 2 == 1)			//ein if-Block, der ausgeführt wird wenn der Drucksensor (ts) ausgelöst wird und der Counter-Wert eine ungerade Zahl ist
		{
		 gear.backward(strecke);				//der Lego-Roboter bewegt sich die vorgegebene Anzahl von Milisekunden nach hinten; bedeutet er fährt 3 Sekunden nach hinten
		 gear.left(grad90);					//der Lego-Roboter dreht sich 0,7 Sekunden nach links. somit wird eine 90 grad Drehung erreicht 
		 gear.forward(strecke);					//der Lego-Roboter bewegt sich die vorgegebene Anzahl von Milisekunden nach vorne; bedeutet er fährt 3 Sekunden nach vorne
		 gear.left(grad90);					//der Lego-Roboter dreht sich um 90 grad nach links
		 gear.forward();					//der Roboter bewegt sich für eine unbestimmte Zeit nach vorne. Methode forward() ohne Parameter ist nicht blockierend
		 counter++;						//der counter Wert wird um 1 erhöht
		}
	   }
	//}
	robot.exit();							//beendet das Programm
  }
	
  public static void main(String [] args)
  {
	new Drucksensor1();						//ruft den Konstruktor auf, in dem die ganzen Anweisungen sind
  }
}
