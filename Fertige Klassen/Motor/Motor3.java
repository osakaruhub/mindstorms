package Motor;                              

import ch.aplu.ev3.*;                         

public class Motor3                           
{                    
  double radius = 0.2;
  double time   = 8000;
  
  public Motor3()                           
  {                                 
    LegoRobot robot = new LegoRobot();                
      
    Gear gear = new Gear();                     
    robot.addPart(gear);                      

    //while (!robot.isEscapeHit())                  
    //{                               
      for (int i = 0; i < 3; i++)                 
      {                             
        gear.rightArc(radius, time);                     //Der Roboter fährt 4000 Milisekunden (= 4 Sekunden) eine Kurve nach rechts, mit einem Radius von 0,1 Metern (= 10 Zentimeter). Dieser Befehl ist ebenfalls blockierend.
        gear.leftArc(radius, time);                
      } 
    //} 
    robot.exit();
  }                                 
  
  public static void main(String [] args)             
  {                                 
    new Motor3();                         
  }                                 
}     
