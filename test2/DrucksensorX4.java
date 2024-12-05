package Drucksensor;                                                //die Klassen "Drucksensor1", "Drucksensor2" liegen alle im Package "Drucksensor"

import ch.aplu.ev3.*;                                               //importiert die Klassenbibliothek Ev3JLibA

public class Drucksensor2                                           //die Klasse "Drucksensor2" führt die zweite Aufgabe von den Drucksensoren aus
{
    public Drucksensor2()
    {
        LegoRobot robot = new LegoRobot();
        
        Gear gear = new Gear();
        robot.addPart(gear);

        TouchSensor ts1 = new TouchSensor(SensorPort.S1);
        TouchSensor ts2 = new TouchSensor(SensorPort.S2);
        robot.addPart(ts1);
        robot.addPart(ts2);

        int strecke = 1000;
        int grad180 = 1400;
        int grad90  =  700;
        long timer  = 5000; // 5 seconds

        int counter = 0;
        
        
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

                while (Tools.getTime() - startTime < TIMER_DURATION) // Check the elapsed time
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
