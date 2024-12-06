package test;

import ch.aplu.ev3.*;

public class Ultraschallsensor1 
{
	

	
	Ultraschallsensor1()
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
		 
			 while(x <= 5)
			 {
			
				 int distance = us.getDistance();
				 
			if(distance < 5 && counter % 2 == 0)
			{
			gear.backward(1000);
			gear.right(700);
			gear.forward(1000);
			gear.right(700);
			gear.forward();
			counter++;
			x++;
			}
			
			if(distance < 5 && counter % 2 == 1)
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

	  public static void main(String[] args)
	  {
	    new Ultraschallsensor1 ();
	  }
	}


