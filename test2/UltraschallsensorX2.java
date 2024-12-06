package Ultraschallsensor;							//die Klassen "Ultraschallsensor1", "Ultraschallsensor2" liegen alle im Package "Ultraschallsensor"

import ch.aplu.ev3.*;                               //importiert die Klassenbibliothek Ev3JLibA

public class Ultraschallsensor2
{
    public Ultraschallsensor2()
    {
        LegoRobot robot = new LegoRobot();
        
        Gear gear = new Gear();
        robot.addPart(gear);

        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
        robot.addPart(us);

        int BACKWARD_DISTANCE = 1000;
        int RIGHT_TURN_DISTANCE = 700;
        int FORWARD_DISTANCE = 1000;
        long TIMER_DURATION = 5000; // 5 seconds

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
                        gear.backward(BACKWARD_DISTANCE);
                        gear.right(RIGHT_TURN_DISTANCE);
                        Thread.sleep(1000);
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
                        if (distance <= 5) 
                        {
                            gear.backward(BACKWARD_DISTANCE);
                            gear.right(1400); // This could also be a constant
                            Thread.sleep(1000);
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
