package test;

import ch.aplu.ev3.*;

public class DrucksensorX4
{
    private static final int BACKWARD_DISTANCE = 1000;
    private static final int RIGHT_TURN_DISTANCE = 700;
    private static final int FORWARD_DISTANCE = 1000;
    private static final long TIMER_DURATION = 5000; // 5 seconds

    public DrucksensorX4()
    {
        int counter = 0;
        
        LegoRobot robot = new LegoRobot();
        Gear gear = new Gear();
        robot.addPart(gear);

        TouchSensor ts1 = new TouchSensor(SensorPort.S1);
        TouchSensor ts2 = new TouchSensor(SensorPort.S2);
        robot.addPart(ts1);
        robot.addPart(ts2);
        
        gear.forward();

        while (!robot.isEscapeHit())
        {
            if (counter == 0)
            {
                if (ts1.isPressed() || ts2.isPressed())
                {
                    gear.backward(BACKWARD_DISTANCE);
                    gear.right(RIGHT_TURN_DISTANCE);
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
                        gear.backward(BACKWARD_DISTANCE);
                        gear.right(1400); // This could also be a constant
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
        new DrucksensorX4();
    }
}