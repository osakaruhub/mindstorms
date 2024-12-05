package test;

import ch.aplu.ev3.*;

public class UltraschallsensorX2
{
    private static final int BACKWARD_DISTANCE = 1000;
    private static final int RIGHT_TURN_DISTANCE = 700;
    private static final int FORWARD_DISTANCE = 1000;
    private static final long TIMER_DURATION = 5000; // 5 seconds

    public UltraschallsensorX2()
    {
        int counter = 0;
        
        LegoRobot robot = new LegoRobot();
        Gear gear = new Gear();
        robot.addPart(gear);

        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
        robot.addPart(us);
        
        gear.forward();

        while (!robot.isEscapeHit())
        {
        	try {
        	int distance = us.getDistance();
        	
            if (counter == 0)
            {
                if (distance <= 5)
                {
                    gear.backward(BACKWARD_DISTANCE);
                    gear.right(RIGHT_TURN_DISTANCE);
                    Thread.sleep(1000);
            		gear.forward(500);
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
                		gear.forward(500);
                		gear.forward();
                    }
                }

                counter = 0; // Reset the counter after the time has elapsed
            }
        	}
        	catch(Exception e)
        	{
        		
        	}
        }       
                
        robot.exit();
    }

    public static void main(String[] args)
    {
        new UltraschallsensorX2();
    }
}

