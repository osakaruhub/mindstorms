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
	
	 int counter = 0;							//in den Integer "counter" wird der Wert 0 gespeichert
		
	
	 gear.forward();
	
	 //while (!robot.isEscapeHit())
	 //{	
		while(counter <= 5)
		{
			int distance = us.getDistance();
			 
			if(distance <= 5 && counter % 2 == 0)
			{
			 gear.backward(1000);
			 gear.right(700);
			 gear.forward(1000);
			 gear.right(700);
			 gear.forward(1000);
			 gear.forward();
			 counter++;
			}
		
			if(distance <= 5 && counter % 2 == 1)
			{
			 gear.backward(1000);
			 gear.left(700);
			 gear.forward(1000);
			 gear.left(700);
			 gear.forward(1000);
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
