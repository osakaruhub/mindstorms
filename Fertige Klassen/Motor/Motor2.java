package Motor;                             

import ch.aplu.ev3.*;                       

public class Motor2                         
{     
  int strecke = 3000;
  int grad90  = 700;
  
  public Motor2()                         
  {                               
    LegoRobot robot = new LegoRobot();              
    
    Gear gear = new Gear();                   
    robot.addPart(gear);                    

    //while (!robot.isEscapeHit())                
    //{                             
      for (int i = 0; i < 3; i++)               
      {                           
        gear.forward(strecke);                  
        gear.right(grad90);                  
        gear.forward(strecke);                   
        gear.right(grad90);                  
        gear.forward(strecke);                  
        gear.left(grad90);                   
        gear.forward(strecke);                  
        gear.left(grad90);                   
      }                           
      gear.forward(strecke);  
      
      robot.exit(); 
    //}                                                   
  }                               
  
    public static void main(String [] args)              
  {                               
      new Motor2();                       
  }                               
}   
