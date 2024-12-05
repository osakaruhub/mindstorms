package test;

import ch.aplu.ev3.*;

public class DrucksensorX2
{
  public DrucksensorX2()
  {
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
   	 try 
     {
     
        	if(ts1.isPressed() || ts2.isPressed())//==0
        	{
        	
        		Tools.startTimer();
        		
        		gear.backward(1000);
                gear.right(700);
                gear.forward();
                Thread.sleep(500);
                
                /*counter++;
                
                if(counter == 1)
                {
                Tools.startTimer();
                
                if(ts1.isPressed() || ts2.isPressed())
                {
        	
        		Tools.startTimer();
        		
        		gear.backward(1000);
                gear.right(1400);
                gear.forward();
                }
                
                timer > 7000
          
                
                if((ts1.isPressed() || ts2.isPressed()) && Tools.getTime() < 7000)
                {
                	gear.backward(1000);
                    gear.right(1400);
                    gear.forward();
                }
                else
                {
                	
                }
        		*/
        	
    
    	
    	
        }
     }
        	catch(Exception e)
        	{
        		
        	}
    
    
      
      
    /*if ((ts1.isPressed() || ts2.isPressed()) && counter % 2 == 0)
      {
      Tools.startTimer();
      gear.backward(1000);
        gear.left(800);
        gear.forward();
        counter++;
        if ((ts1.isPressed() || ts2.isPressed()) && Tools.getTime() > 3000)
        {
          gear.backward(1000);
          gear.left(1600);
          gear.forward();
        }
      }
      
      if ((ts1.isPressed() || ts2.isPressed()) && counter % 2 == 1)
      { 
        Tools.startTimer();
        gear.backward(1000);
        gear.right(800);
        gear.forward();
        counter--;
        if ((ts1.isPressed() || ts2.isPressed()) && Tools.getTime() > 3000)
        {
          gear.backward(1000);
          gear.left(1600);
          gear.forward();
        }
      }
      

      if (ts1.isPressed() || ts2.isPressed())
      { 
        Tools.startTimer();
        
        if(counter == 0)
        {
          gear.backward(1000);
          gear.left(800);
          gear.forward();
        }
        else
        {
          gear.backward(1000);
          gear.right(800);
          gear.forward();
        }
        
        if (Tools.getTime() < 3000)
        {
          gear.backward(1000);
          gear.left(1600);
          gear.forward();
        }
      }
      
      counter = 1 - counter;
    }*/
        }
  robot.exit();
  
  }

  public static void main(String[] args)
  {
    new DrucksensorX2();
  }
}