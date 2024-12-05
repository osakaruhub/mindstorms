package Motor;                              

import ch.aplu.ev3.*;                         

public class Motor3                           
{                                   
  public Motor3()                           
  {                                 
    LegoRobot robot = new LegoRobot();                
      
    Gear gear = new Gear();                     
    robot.addPart(gear);                      

    //while (!robot.isEscapeHit())                  
    //{                               
      for (int i = 0; i < 3; i++)                 
      {                             
        gear.rightArc(0.2, 8000);               
        gear.leftArc(0.2, 8000);                
      } 
    //} 
    robot.exit();
  }                                 
  
  public static void main(String [] args)             
  {                                 
    new Motor3();                         
  }                                 
}     
