package Motor;                                               //die Klassen "Motor1", "Motor2", "Motor3", "Motor4" liegen alle im Package "Motor"         

import ch.aplu.ev3.*;                                        //importiert die Klassenbibliothek Ev3JLibA     

public class Motor3                                          //die Klasse "Motor3" führt die dritte Aufgabe von den Motoren aus                       
{                    
  double radius = 0.2;                                       //in den Double "radius" wird der Wert 0,2 gespeichert
  double time   = 8000;                                      //in den Double "time" wird der Wert 8000 gespeichert
  
  public Motor3()                           
  {                                 
    LegoRobot robot = new LegoRobot();                
      
    Gear gear = new Gear();                                 //erzeugt ein Fahrwerk namens "gear" mit Motoren an den Anschlüssen A und B 
    robot.addPart(gear);                                    //fügt dem Roboterobjekt "robot" das Fahtwerk "gear" zu             

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
