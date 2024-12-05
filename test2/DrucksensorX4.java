package Drucksensor;                                                    //die Klassen "Drucksensor1", "Drucksensor2" liegen alle im Package "Drucksensor"

import ch.aplu.ev3.*;                                                   //importiert die Klassenbibliothek Ev3JLibA

public class Drucksensor2                                               //die Klasse "Drucksensor2" führt die zweite Aufgabe von den Drucksensoren aus
{
    public Drucksensor2()
    {
        LegoRobot robot = new LegoRobot();                              //deklariert und initialisiert ein neues LegoRobot Objekt mit dem Namen "robot"
        
        Gear gear = new Gear();                                         //erzeugt ein Fahrwerk namens "gear" mit Motoren an den Anschlüssen A und B 
        robot.addPart(gear);                                            //fügt dem Roboterobjekt "robot" das Fahtwerk "gear" zu

        TouchSensor ts1 = new TouchSensor(SensorPort.S1);               //am Sensorport 1 ist ein Touch-Sensor angeschlossen (ts1)
        TouchSensor ts2 = new TouchSensor(SensorPort.S2);               //am Sensorport 2 ist ein anderer Touch-Sensor angeschlossen (ts2)
        robot.addPart(ts1);                                             //der Touch-Sensor 1 (ts1) wird zum "robot" hinzugefügt
        robot.addPart(ts2);                                             //der Touch-Sensor 2 (ts2) wird zum "robot" hinzugefügt

        int strecke = 1000;                                             //in den Integer "strecke" wird der Wert 1000 gespeichert
        int grad180 = 1400;                                             //in den Integer "grad180" wird der Wert 1400 gespeichert
        int grad90  =  700;                                             //in den Integer "grad90"  wird der Wert  700 gespeichert
        long timer  = 5000;                                             //in den Long "timer" wird der Wert 5000 gespeichert

        int counter = 0;                                                //in den Integer "counter" wird der Wert 0 gespeichert
        
        
        gear.forward();

        while (!robot.isEscapeHit())
        {
            if (counter == 0)
            {
                if (ts1.isPressed() || ts2.isPressed())
                {
                    gear.backward(strecke);
                    gear.right(grad90);
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
                    if (ts1.isPressed() || ts2.isPressed()) 
                    {
                        gear.backward(strecke);
                        gear.right(grad180); // This could also be a constant
                        gear.forward();
                    }
                }

                counter = 0; // Reset the counter after the time has elapsed
            }
        }       
                
        robot.exit();
    }

    public static void main(String[] args)
    {
        new Drucksensor2();
    }
}
