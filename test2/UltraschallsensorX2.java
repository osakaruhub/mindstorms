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

        int strecke = 1000;                                                 //in den Integer "strecke" wird der Wert 1000 gespeichert
        int grad180 = 1400;                                                 //in den Integer "grad180" wird der Wert 1400 gespeichert
        int grad90  = 700;                                                  //in den Integer "grad90"  wird der Wert  700 gespeichert
        long timer = 5000;                                                  //in den Long "timer" wird der Wert 5000 gespeichert
        long schlafen = 1000;                                               //in den Long "schlafen" wird der Wert 1000 gespeichert

        int counter = 0;                                                    //in den Integer "counter" wird der Wert 0 gespeichert

        
        gear.forward();                                                     //der Roboter bewegt sich für eine unbestimmte Zeit nach vorne. Methode forward() ohne Parameter ist nicht blockierend

        while (!robot.isEscapeHit())                                        //der Code innerhalb der while-Schleife wird solange ausgeführt, bis der Benutzer auf dem "EV3 Brick" die Escape-Taste drückt. wird die Taste nicht gedrückt, wird der Code ganz normal weiterlaufen, bis er sein Ende erreicht hat
        {
        	try                                                             //try-Block den man einbauen musss, um Thread.sleep() verwenden zu können
            {
        	    int distance = us.getDistance();                            //die Methode getDistance() gibt die Entfernung zum nächsten Gegenstand in Zentimeter zurück und speichert sie Integer "distance" ab
        	
                if (counter == 0)                                           //if-Block, der ausgeführt wird, wenn der counter Wert gleich 0 ist
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
