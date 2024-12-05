package test;

import ch.aplu.ev3.*;

public class Drucksensor1 
{
  int strecke = 1000;
  int grad90  = 700;
	
  public Drucksensor1()
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
	//{	
	   while(x <= 5)
	   {
		if(ts.isPressed() && counter % 2 == 0)
		{
		 gear.backward(strecke);
		 gear.right(grad90);
		 gear.forward(strecke);
		 gear.right(grad90);
		 gear.forward();
		 counter++;
		 x++;
		}
		
		if(ts.isPressed() && counter % 2 == 1)
		{
		 gear.backward(strecke);
		 gear.left(grad90);
		 gear.forward(strecke);
		 gear.left(grad90);
		 gear.forward();
		 counter--;
		 x++;
		}
	   }
	//}
		
	robot.exit();
  }
	
	public static void main(String [] args)
	{
		new Drucksensor1();
	}
}
