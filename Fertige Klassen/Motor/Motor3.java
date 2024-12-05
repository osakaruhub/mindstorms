package Motor;                                               //die Klassen "Motor1", "Motor2", "Motor3", "Motor4" liegen alle im Package "Motor"         

import ch.aplu.ev3.*;                                        //importiert die Klassenbibliothek Ev3JLibA     

public class Motor3                                          //die Klasse "Motor3" führt die dritte Aufgabe von den Motoren aus                       
{                    
  public Motor3()                           
  {                                 
    LegoRobot robot = new LegoRobot();                      //deklariert und initialisiert ein neues LegoRobot Objekt mit dem Namen "robot"        
      
    Gear gear = new Gear();                                 //erzeugt ein Fahrwerk namens "gear" mit Motoren an den Anschlüssen A und B 
    robot.addPart(gear);                                    //fügt dem Roboterobjekt "robot" das Fahtwerk "gear" zu       

    double radius = 0.2;                                    //in den Double "radius" wird der Wert 0,2 gespeichert
    double time   = 8000;                                   //in den Double "time" wird der Wert 8000 gespeichert
    

    //while (!robot.isEscapeHit())                          //die while-Schleife ist in diesem Programm zwar nicht erforderlich, kann aber dennoch bei Bedarf eingebaut werden          
    //{                               
      for (int i = 0; i < 3; i++)                           //die for-Schleife wird dreimal wiederholt
      {                             
        gear.rightArc(radius, time);                        //der Roboter fährt 8000 Milisekunden (= 8 Sekunden) (time) eine Kurve nach rechts, mit einem Radius von 0,2 Metern (= 20 Zentimeter) (radius)
        gear.leftArc(radius, time);                         //der Roboter fährt 8000 Milisekunden (= 8 Sekunden) (time) eine Kurve nach links, mit einem Radius von 0,2 Metern (= 20 Zentimeter) (radius)
      } 
    //} 
    robot.exit();                                           //beendet das Programm
  }                                 
  
  public static void main(String [] args)             
  {                                 
    new Motor3();                                           //ruft den Konstruktor auf, in dem die ganzen Anweisungen sind        
  }                                 
}     
