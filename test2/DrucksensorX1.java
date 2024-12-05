package Drucksensor;						//die Klassen "Drucksensor1", "Drucksensor2" liegen alle im Package "Drucksensor"

import ch.aplu.ev3.*;						//importiert die Klassenbibliothek Ev3JLibA

public class Drucksensor1 					//die Klasse "Drucksensor1" führt die erste Aufgabe von den Drucksensoren aus 
{
  int strecke = 1000;						//in den Integer "strecke" wird der Wert 1000 gespeichert
  int grad90  = 700;						//in den Integer "grad90"  wird der Wert  700 gespeichert
	
  public Drucksensor1()
  {
	LegoRobot robot = new LegoRobot();
	
	Gear gear = new Gear();					//erzeugt ein Fahrwerk namens "gear" mit Motoren an den Anschlüssen A und B 
	robot.addPart(gear);					//fügt dem Roboterobjekt "robot" das Fahtwerk "gear" zu
	
	TouchSensor ts = new TouchSensor(SensorPort.S1);
	robot.addPart(ts);
	
	int x = 0;
	int counter = 0;
	
	gear.forward();
	
	//while (!robot.isEscapeHit())
	//{	
	   while(x <= 5)
	   {
		if(ts.isPressed() && counter % 2 == 0)
		{
		 gear.backward(strecke);
		 gear.right(grad90);
		 gear.forward(strecke);
		 gear.right(grad90);
		 gear.forward();
		 counter++;
		 x++;
		}
		
		if(ts.isPressed() && counter % 2 == 1)
		{
		 gear.backward(strecke);
		 gear.left(grad90);
		 gear.forward(strecke);
		 gear.left(grad90);
		 gear.forward();
		 counter--;
		 x++;
		}
	   }
	//}
		
	robot.exit();
  }
	
  public static void main(String [] args)
  {
	new Drucksensor1();
  }
}
