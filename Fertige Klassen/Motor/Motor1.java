package Motor;                                        //die Klassen "Motor1", "Motor2", "Motor3", "Motor4" liegen alle im Package "Motor"

import ch.aplu.ev3.*;                     

public class Motor1                                   //die Klasse "Motor1" führt die erste Aufgabe von den Motoren aus   
{         
  int strecke = 3000;                                 //in den Integer "strecke" wird der Wert 3000 gespeichert
  int grad180 = 1400;                                 //in den Integer "grad180" wird der Wert 1400 gespeichert
  int grad90  = 700;                                  //in den Integer "grad90"  wird der Wert  700 gespeichert
  
  public Motor1()                       
  {                             
    LegoRobot robot = new LegoRobot();                //deklariert und initialisiert ein neues LegoRobot Objekt mit dem Namen "robot"
      
    Gear gear = new Gear();                           //deklariert und initialisiert ein neues Gear Objekt mit dem Namen "gear"
    robot.addPart(gear);                              //fügt dem LegoRobot Objekt "robot" das Gear Objekt "gear" zu
      
    //while (!robot.isEscapeHit())                    //die while-Schleife ist in diesem Programm zwar nicht erforderlich, kann aber dennoch bei Bedarf eingebaut werden
    //{                           
      for (int i = 0; i < 4; i++)                     //die for-Schleife wird viermal wiederholt            
      {                         
        gear.forward(strecke);                        //der Lego-Roboter bewegt sich die vorgegebene Anzahl von Milisekunden nach vorne; bedeutet er fährt 3 Sekenden nach vorne            
        gear.right(grad180);                          //           
        gear.forward(strecke);                        //der  Lego-Roboter fährt 3 Sekenden nach vorne
        gear.left(grad90);                            //
      } 
      robot.exit();                                   //
    //}                                             
    }                             
  
  public static void main(String [] args)         
  {                             
    new Motor1();                                          //ruft den Konstruktor auf, in dem die ganzen Anweisungen sind                 
  }                             
}         
