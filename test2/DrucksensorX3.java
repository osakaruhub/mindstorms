package test;

import ch.aplu.ev3.*;

public class DrucksensorX3
{
  public DrucksensorX3()
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
   		
   			if(counter == 0)
   			{
   			
   				if(ts1.isPressed() || ts2.isPressed())
   				{
   					gear.backward(1000);
   					gear.right(700);
   					gear.forward();
                
   					counter++;
   				}
   			}    
   		
   		
   			if (counter == 1) 
   			{
   				Tools.startTimer();
   				long startTime = Tools.getTime(); // Speichere die Startzeit

   				while (Tools.getTime() - startTime < 5000) { // Überprüfe die Zeit seit dem Start
   					
   		        if (ts1.isPressed() || ts2.isPressed()) 
   		        {
   		        	gear.backward(1000);
                	gear.right(1400);
                	gear.forward();
   		        }
   		    }

   		    counter = 0; // Setze den Counter zurück, nachdem die Zeit abgelaufen ist
   		}
          
    }       
                
  robot.exit();
  
  }

  public static void main(String[] args)
  {
    new DrucksensorX3();
  }
}