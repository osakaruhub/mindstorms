package Ultraschallsensor;							                        //die Klassen "Ultraschallsensor1", "Ultraschallsensor2" liegen alle im Package "Ultraschallsensor"

import ch.aplu.ev3.*;                                                       //importiert die Klassenbibliothek Ev3JLibA

public class Ultraschallsensor2                                             //die Klasse "Ultraschallsensor2" führt die zweite Aufgabe von den Ultraschallsensoren aus
{
    public Ultraschallsensor2()
    {
        LegoRobot robot = new LegoRobot();                                  //deklariert und initialisiert ein neues LegoRobot Objekt mit dem Namen "robot"
        
        Gear gear = new Gear();                                             //erzeugt ein Fahrwerk namens "gear" mit Motoren an den Anschlüssen A und B 
        robot.addPart(gear);                                                //fügt dem Roboterobjekt "robot" das Fahtwerk "gear" zu

        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);		    //am Sensorport 1 ist ein Ultrasonic-Sensor angeschlossen namens "us"
    	robot.addPart(us);							                        //der Ultrasonic-Sensor (us) wird zum "robot" hinzugefügt

        int strecke = 1000;
        int grad180 = 1400;
        int grad90  = 700;
        long timer = 5000; // 5 seconds
        long schlafen = 1000;

        int counter = 0;

        
        gear.forward();

        while (!robot.isEscapeHit())
        {
        	try 
            {
        	    int distance = us.getDistance();
        	
                if (counter == 0)
                {
                    if (distance <= 5)
                    {
                        gear.backward(strecke);
                        gear.right(grad90);
                        Thread.sleep(schlafen);
            		    gear.forward();
                        counter++;
                    }
                }    
            
                if (counter == 1) 
                {
                    Tools.startTimer();
                    long startTime = Tools.getTime(); // Store the start time

                    while (Tools.getTime() - startTime < timer) // Check the elapsed time
                    {
                        if (distance <= 5) 
                        {
                            gear.backward(strecke);
                            gear.right(grad180); // This could also be a constant
                            Thread.sleep(schlafen);
                		    gear.forward();
                        }
                    }

                    counter = 0; // Reset the counter after the time has elapsed
                }
        	}
        	catch(Exception e)
        	{
        		throw new RunTimeException();
        	}
        }              
    robot.exit();
 }

 public static void main(String[] args)
 {
    new Ultraschallsensor2();
 }
}
