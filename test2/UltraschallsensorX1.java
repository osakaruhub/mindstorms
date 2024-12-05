package test;

import ch.aplu.ev3.*;

public class UltraschallsensorX1 
{
	public UltraschallsensorX1()
	{

	LegoRobot robot = new LegoRobot();
	
	Gear gear = new Gear();
	robot.addPart(gear);
	
	UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
    robot.addPart(us);
	
	int x = 0;
	int counter = 0;
	
	gear.forward();
	
	
	
	 //while (!robot.isEscapeHit())	
	 try {
		 while(x <= 5)
		 {
			 
		
			 int distance = us.getDistance();
			 
		if(distance <= 5 && counter % 2 == 0)
		{
		gear.backward(1000);
		gear.right(700);
		gear.forward(1000);
		gear.right(700);
		Thread.sleep(1000);
		gear.forward(1000);
		gear.forward();
		counter++;
		x++;
		}
		
		if(distance <= 5 && counter % 2 == 1)
		{
		
		gear.backward(1000);
		gear.left(700);
		gear.forward(1000);
		gear.left(700);
		Thread.sleep(1000);
		gear.forward(1000);
		gear.forward();
		counter--;
		x++;
		}
		
			 }
			
		
	}
	
	 catch(Exception e)
	 {
		 
	 }
	 
	 robot.exit();
	
	
	}
	
	
	
	public static void main(String [] args)
	{
		new UltraschallsensorX1 ();
	}

}