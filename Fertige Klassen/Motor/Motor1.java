package Motor;                          

import ch.aplu.ev3.*;                     

public class Motor1                       
{         
  int strecke = 3000;
  
  public Motor1()                       
  {                             
      LegoRobot robot = new LegoRobot();            
      
      Gear gear = new Gear();                 
      robot.addPart(gear);                  
      
    //while (!robot.isEscapeHit())              
    //{                           
      for (int i = 0; i < 4; i++)             
      {                         
        gear.forward(strecke);                 
        gear.right(1400);             
        gear.forward(strecke);                 
        gear.left(700);               
      } 
      robot.exit();   
    //}                                             
    }                             
  
    public static void main(String [] args)         
    {                             
      new Motor1();                     
    }                             
}         