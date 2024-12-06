package Ultraschallsensor;							                            //die Klassen "Ultraschallsensor1", "Ultraschallsensor2" liegen alle im Package "Ultraschallsensor"

import ch.aplu.ev3.*;                                                           //importiert die Klassenbibliothek Ev3JLibA

public class Ultraschallsensor2                                                 //die Klasse "Ultraschallsensor2" führt die zweite Aufgabe von den Ultraschallsensoren aus
{
    public Ultraschallsensor2()
    {
        LegoRobot robot = new LegoRobot();                                      //deklariert und initialisiert ein neues LegoRobot Objekt mit dem Namen "robot"
        
        Gear gear = new Gear();                                                 //erzeugt ein Fahrwerk namens "gear" mit Motoren an den Anschlüssen A und B 
        robot.addPart(gear);                                                    //fügt dem Roboterobjekt "robot" das Fahtwerk "gear" zu

        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);		        //am Sensorport 1 ist ein Ultrasonic-Sensor angeschlossen namens "us"
    	robot.addPart(us);							                            //der Ultrasonic-Sensor (us) wird zum "robot" hinzugefügt

        int strecke = 1000;                                                     //in den Integer "strecke" wird der Wert 1000 gespeichert
        int grad180 = 1400;                                                     //in den Integer "grad180" wird der Wert 1400 gespeichert
        int grad90  = 700;                                                      //in den Integer "grad90"  wird der Wert  700 gespeichert
        long timer = 5000;                                                      //in den Long "timer" wird der Wert 5000 gespeichert
        long schlafen = 1000;                                                   //in den Long "schlafen" wird der Wert 1000 gespeichert

        int counter = 0;                                                        //in den Integer "counter" wird der Wert 0 gespeichert

        
        gear.forward();                                                         //der Roboter bewegt sich für eine unbestimmte Zeit nach vorne. Methode forward() ohne Parameter ist nicht blockierend

        while (!robot.isEscapeHit())                                            //der Code innerhalb der while-Schleife wird solange ausgeführt, bis der Benutzer auf dem "EV3 Brick" die Escape-Taste drückt. wird die Taste nicht gedrückt, wird der Code ganz normal weiterlaufen, bis er sein Ende erreicht hat
        {
        	try                                                                 //try-Block den man einbauen musss, um Thread.sleep() verwenden zu können
            {
        	    int distance = us.getDistance();                                //die Methode getDistance() gibt die Entfernung zum nächsten Gegenstand in Zentimeter zurück und speichert sie Integer "distance" ab
        	
                if (counter == 0)                                               //if-Block, der ausgeführt wird, wenn der counter Wert gleich 0 ist
                {
                    if (distance <= 5)                                          //ein if-Block, der ausgeführt wird wenn, die gemessene Distanz des Ultraschallsensor (us) zum nächsten Objakt kleiner oder gleich 5 Zentimeter beträgt
                    {
                        gear.backward(strecke);                                 //der Lego-Roboter bewegt sich die vorgegebene Anzahl von Milisekunden nach hinten; bedeutet er fährt 1 Sekunde nach hinten    
                        gear.right(grad90);                                     //der Lego-Roboter dreht sich 0,7 Sekunden nach rechts. somit wird eine 90 grad Drehung erreicht 
                        Thread.sleep(schlafen);                                 //der Lego-Roboter stoppt für für den Wert von schlafen in Milisekunden; bedeutet er stoppt hier für 1 Sekunde
            		    gear.forward();                                         //der Roboter bewegt sich für eine unbestimmte Zeit nach vorne. Methode forward() ohne Parameter ist nicht blockierend
                        counter++;                                              //der counter Wert wird um 1 erhöht
                    }
                }    
            
                if (counter == 1)                                               //if-Block, der ausgeführt wird, wenn der counter Wert gleich 1 ist
                {
                    Tools.startTimer();                                         //startet einen Timer
                    long startTime = Tools.getTime();                           //im Long "startTime" wird der Wert von Tools.getTime() (dem eben genannten Timer) gespeichert

                    while (Tools.getTime() - startTime < timer)                 //der Code innerhalb der while-Schleife wird solange ausgeführt, wie die Differenz von Tools.getTime () und startTime kleiner als der Wert von timer (5000) ist. heißt er wird ausgeführt solange noch keine 5 Sekunden vergangen sind
                    {
                        if (distance <= 5)                                      //ein if-Block, der ausgeführt wird wenn, die gemessene Distanz des Ultraschallsensor (us) zum nächsten Objakt kleiner oder gleich 5 Zentimeter beträgt
                        {
                         gear.backward(strecke);                             //der Lego-Roboter bewegt sich die vorgegebene Anzahl von Milisekunden nach hinten; bedeutet er fährt 1 Sekunde nach hinten    
                         gear.right(grad180);                                    //der Lego-Roboter dreht sich 1,4 Sekunden nach rechts. somit wird eine 180 grad Drehung erreicht 
                         Thread.sleep(schlafen);                                 //der Lego-Roboter stoppt für für den Wert von schlafen in Milisekunden; bedeutet er stoppt hier für 1 Sekunde
            		     gear.forward();                                         //der Roboter bewegt sich für eine unbestimmte Zeit nach vorne. Methode forward() ohne Parameter ist nicht blockierend
                        }
                    }

                    counter = 0;                                                //der counter wird (nach Ablauf von 5 Sekunden) wieder auf 0 gesetzt
                }
        	}
        	catch(Exception e)                                                  //catch-Block zum dazugehörigen try-Block; wird im try-Block eine Exception gefunden, springt das Programm automatisch in den catch-Block
        	{
        		throw new RunTimeException();                                   //wirft eine RunTimeException, die das Programm unterbricht/beendet
        	}
        }              
    robot.exit();                                                               //beendet das Programm (regulär)
 }

 public static void main(String[] args)
 {
    new Ultraschallsensor2();                                                   //ruft den Konstruktor auf, in dem die ganzen Anweisungen sind
 }
}
