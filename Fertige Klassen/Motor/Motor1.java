package Motor;                                        //die Klassen "Motor1",  "Motor2", "Motor3", "Motor4" liegen alle im Package "Motor"

import ch.aplu.ev3.*;                     

public class Motor1                       
{         
  int strecke = 3000;
  int grad180 = 1400;
  int grad90  = 700;
  
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
        gear.right(grad180);             
        gear.forward(strecke);                 
        gear.left(grad90);               
      } 
      robot.exit();   
    //}                                             
    }                             
  
  public static void main(String [] args)         
  {                             
      new Motor1();                     
  }                             
}         
