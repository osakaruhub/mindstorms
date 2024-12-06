/**
 * Ultraschallsensoren
 */
package mindstorms;

import ch.aplu.ev3.*;

public class Ultraschallsensoren {
	private static final int LEVEL = 5;     // 5 cm
	private static final int DREHEN = 700;  // 90 Grad
	private static Boolean stop; // fuehr maze
	LegoRobot robot;
	Gear gear;
	UltrasonicSensor us;

    // init
    public Ultraschallsensoren() {
        robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        us = new UltrasonicSensor();
        robot.addPart(us);
        // add method calls here
        robot.exit();
    }

    // 1.
    public void lawnmower() {
        us.addUltrasonicListener(new UltrasonicLawnmowerListener(), LEVEL);
        gear.forward();
        while (!robot.isEscapeHit()||stop);
        gear.stop();
    }

    // 2.
    public void maze() {
        us.addUltrasonicListener(new UltrasonicMazeListener(), LEVEL);
        Tools.startTimer(); // starte den Timer, obwohl die variable time mit Tools.getTime() synchroniesiert wird, wodurch delta time das gesuchte ist (delta zeit = Tools.getTime() - time > 5000)
        while (!gear.isEscapeHit());
        Tools.stopTimer();
        gear.stop();
    }

    class UltrasonicLawnmowerListener implements UltrasonicListener {
    	int turns = 0;
        public void far(SensorPort port, int level) {}
        public void near(SensorPort port, int level) { // stoppt, geht ein bisschen nach hinten, um ein Halbkreis zu machen
            gear.backward(BACK);
            if (turns % 2 == 1) { // stoppt, dreht sich und faehrt weiter. Die Richtung aendert sich jede Iteration
				gear.right(DREHEN);
				gear.forward(1000);
				gear.right(DREHEN);
            } else {
				gear.left(DREHEN);
				gear.forward(1000);
				gear.left(DREHEN);
            }
            stop = turns >= 5; // faehrt solange, bis es 5 mal gedreht hat
            gear.forward();

            //if (turns++ % 2 == 1) { // dont mind this. havent worked out if these are the right numbers
            //    gear.rightArc(0.2, 2000);
            //} else {
            //    gear.leftArc(0.2, 2000);
            //}
            // wont work supposedly
            //turns % 2 == 1 ? gear.rightArc(0.2, 2000) : gear.leftArc(0.2, 2000); // Die Anzahl der Umdrehungen beeinflusst die Richtung des Halbkreises, startend mit leftArc()
        }
    }

    class UltrasonicMazeListener implements UltrasonicListener {
        private Boolean opt = false;
        private int time = 0;

        public void far(SensorPort port, int level) {
            if (opt && Tools.getTime() - time > 5000) { // geht in die Normaloperation zurueck, wenn 5 Sekunden vergangen sind ohne Anknallen
                opt = false;
            }
        }
        public void near(SensorPort port, int level) {  
                gear.backward(1000);
            if (opt) { // beim naechsten male dreht sich der um 180 Grad, und setzt den Timer zurueck
                gear.right(DRHEN * 2); // 180 Grad
            } else { // dreht sich beim ersten mal um 90 Grad nach rechts
                gear.right(DREHEN);
                opt = true;
            }
                gear.forward();
            time = Tools.getTime(); // nach jedem Anknall setzt man den Timer zurueck
        }
    }
}
