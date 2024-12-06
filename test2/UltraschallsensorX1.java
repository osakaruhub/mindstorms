package Ultraschallsensor;							//die Klassen "Ultraschallsensor1", "Ultraschallsensor2" liegen alle im Package "Ultraschallsensor"

import ch.aplu.ev3.*;								//importiert die Klassenbibliothek Ev3JLibA

public class Ultraschallsensor1 						//die Klasse "Ultraschallsensor1" führt die erste Aufgabe von den Ultraschallsensoren aus 
{
	public Ultraschallsensor1()
	{
	 LegoRobot robot = new LegoRobot();					//deklariert und initialisiert ein neues LegoRobot Objekt mit dem Namen "robot"		
	
	 Gear gear = new Gear();						//erzeugt ein Fahrwerk namens "gear" mit Motoren an den Anschlüssen A und B 
	 robot.addPart(gear);							//fügt dem Roboterobjekt "robot" das Fahtwerk "gear" zu
	
	 UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);		//am Sensorport 1 ist ein Ultrasonic-Sensor angeschlossen namens "us"
    	 robot.addPart(us);							//der Ultrasonic-Sensor (us) wird zum "robot" hinzugefügt

	 int strecke = 1000;							//in den Integer "strecke" wird der Wert 1000 gespeichert
         int grad90  = 700;							//in den Integer "grad90"  wird der Wert  700 gespeichert  
		
	 int counter = 0;							//in den Integer "counter" wird der Wert 0 gespeichert
		
	
	 gear.forward();							//der Roboter bewegt sich für eine unbestimmte Zeit nach vorne. Methode forward() ohne Parameter ist nicht blockierend
	
	 //while (!robot.isEscapeHit())						//die while-Schleife ist in diesem Programm zwar nicht erforderlich, kann aber dennoch bei Bedarf eingebaut werden
	 //{	
		while(counter <= 5)						//die while-Schleife läuft solange bis der Wert für counter kleiner oder gleich 5 ist
		{
			int distance = us.getDistance();			//die Methode getDistance() gibt die Entfernung zum nächsten Gegenstand in Zentimeter zurück und speichert sie Integer "distance" ab 
			 
			if(distance <= 5 && counter % 2 == 0)			//ein if-Block, der ausgeführt wird wenn, die gemessene Distanz des Ultraschallsensor (us) zum nächsten Objakt kleiner oder gleich 5 Zentimeter beträgt und der Counter-Wert eine gerade Zahl ist (oder 0)
			{
			 gear.backward(strecke);				//der Lego-Roboter bewegt sich die vorgegebene Anzahl von Milisekunden nach hinten; bedeutet er fährt 1 Sekunde nach hinten
			 gear.right(grad90);
			 gear.forward(strecke);					//der Lego-Roboter bewegt sich die vorgegebene Anzahl von Milisekunden nach vorne; bedeutet er fährt 1 Sekunde nach vorne
			 gear.right(grad90);
			 gear.forward(strecke);
			 gear.forward();
			 counter++;
			}
		
			if(distance <= 5 && counter % 2 == 1)
			{
			 gear.backward(strecke);
			 gear.left(grad90);
			 gear.forward(strecke);
			 gear.left(grad90);
			 gear.forward(strecke);
			 gear.forward();
			 counter++;
			}
		}	
	robot.exit();
	    //}	
	}
	
	public static void main(String [] args)
	{
		new Ultraschallsensor1();
	}

}
