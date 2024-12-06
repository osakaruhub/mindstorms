package Ultraschallsensor;							//die Klassen "Ultraschallsensor1", "Ultraschallsensor2" liegen alle im Package "Ultraschallsensor"

import ch.aplu.ev3.*;								//importiert die Klassenbibliothek Ev3JLibA

public class Ultraschallsensor1 						//die Klasse "Ultraschallsensor1" führt die erste Aufgabe von den Ultraschallsensoren aus 
{
	public Ultraschallsensor1()
	{
	 LegoRobot robot = new LegoRobot();					//deklariert und initialisiert ein neues LegoRobot Objekt mit dem Namen "robot"		
	
	 Gear gear = new Gear();
	 robot.addPart(gear);
	
	 UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
    	 robot.addPart(us);
	
	 int counter = 0;
		
	
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
