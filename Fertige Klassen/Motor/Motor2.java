package Motor;                                             //die Klassen "Motor1", "Motor2", "Motor3", "Motor4" liegen alle im Package "Motor"        

import ch.aplu.ev3.*;                                      //importiert die Klassenbibliothek Ev3JLibA            

public class Motor2                                        //die Klasse "Motor2" führt die zweite Aufgabe von den Motoren aus          
{     
  int strecke = 3000;                                      //in den Integer "strecke" wird der Wert 3000 gespeichert
  int grad90  = 700;                                       //in den Integer "grad90"  wird der Wert  700 gespeichert
  
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
