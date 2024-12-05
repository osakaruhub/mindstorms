package Motor;                                                //die Klassen "Motor1", "Motor2", "Motor3", "Motor4" liegen alle im Package "Motor"              

import ch.aplu.ev3.*;                                         //importiert die Klassenbibliothek Ev3JLibA  

public class Motor4                                           //die Klasse "Motor4" führt die vierte Aufgabe von den Motoren aus            
{       
  int strecke = 3000;                                         //in den Integer "strecke" wird der Wert 3000 gespeichert
  int grad180 = 1400;                                         //in den Integer "grad180" wird der Wert 1400 gespeichert
  int grad90  = 700;                                          //in den Integer "grad90"  wird der Wert  700 gespeichert
  
  public Motor4()                           
  {                                 
    LegoRobot robot = new LegoRobot();                        //deklariert und initialisiert ein neues LegoRobot Objekt mit dem Namen "robot"
      
    Gear gear = new Gear();                                   //erzeugt ein Fahrwerk namens "gear" mit Motoren an den Anschlüssen A und B         
    robot.addPart(gear);                                      //fügt dem Roboterobjekt "robot" das Fahtwerk "gear" zu

    //while (!robot.isEscapeHit())                            //die while-Schleife ist in diesem Programm zwar nicht erforderlich, kann aber dennoch bei Bedarf eingebaut werden          
    //{                               
      for (int i = 0; i < 4; i++)                             //die for-Schleife wird viermal wiederholt       
      {                             
        gear.forward(strecke);                                //der Lego-Roboter bewegt sich die vorgegebene Anzahl von Milisekunden nach vorne; bedeutet er fährt 3 Sekenden nach vorne      
        gear.right(grad90);                                   //der Lego-Roboter dreht sich 0,7 Sekunden nach rechts. somit wird eine 90 grad Drehung erreicht            
        gear.forward(strecke);                    
        gear.right(grad90);                     
        gear.forward(strecke);                    
        gear.right(grad90);                    
        gear.forward(strecke);                    
        gear.left(grad180);                                   //der Lego-Roboter dreht sich 1,4 Sekunden nach links. somit wird eine 180 grad Drehung erreicht             
      } 
      robot.exit(); 
    //}                                                       
  }                                 
  
  public static void main(String [] args)             
  {                                 
    new Motor4();                         
  }                                 
}  
