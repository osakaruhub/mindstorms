package test;

import ch.aplu.ev3.*;

public class DrucksensorX1 
{
	public DrucksensorX1()
	{

	LegoRobot robot = new LegoRobot();
	
	Gear gear = new Gear();
	robot.addPart(gear);
	
	TouchSensor ts = new TouchSensor(SensorPort.S1);
	robot.addPart(ts);
	
	int x = 0;
	int counter = 0;
	
	gear.forward();
	
	
	
	 //while (!robot.isEscapeHit())	
	 
		 while(x <= 5)
		 {
		
		
		if(ts.isPressed() && counter % 2 == 0)
		{
		gear.backward(1000);
		gear.right(700);
		gear.forward(1000);
		gear.right(700);
		gear.forward();
		counter++;
		x++;
		}
		
		if(ts.isPressed() && counter % 2 == 1)
		{
		
		gear.backward(1000);
		gear.left(700);
		gear.forward(1000);
		gear.left(700);
		gear.forward();
		counter--;
		x++;
		}
		
		
	}
	
	
	 
	 robot.exit();
	
	
	}
	
	
	
	public static void main(String [] args)
	{
		new DrucksensorX1();
	}

}