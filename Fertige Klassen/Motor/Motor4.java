package Motor;                              

import ch.aplu.ev3.*;                         
public class Motor4                           
{       
  int strecke = 3000;
  
  public Motor4()                           
  {                                 
    LegoRobot robot = new LegoRobot();                
      
    Gear gear = new Gear();                     
    robot.addPart(gear);                      

    //while (!robot.isEscapeHit())                  
    //{                               
      for (int i = 0; i < 4; i++)                 
      {                             
        gear.forward(strecke);                    
        gear.right(700);                    
        gear.forward(strecke);                    
        gear.right(700);                     
        gear.forward(strecke);                    
        gear.right(700);                    
        gear.forward(strecke);                    
        gear.left(1400);                    
      } 
      robot.exit(); 
    //}                                                       
  }                                 
  
  public static void main(String [] args)             
  {                                 
    new Motor4();                         
  }                                 
}  
