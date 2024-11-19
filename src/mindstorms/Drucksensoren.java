package mindstorms;
import ch.aplu.ev3.*;

public class Drucksensoren {
    public DruckSensoren() {
        final int drehen = 1500;

        LegoRobot robot = new LegoRobot();
        Gear gear = new Gear();
        robot.addPart(gear);
        DruckSensor ds = new DruckSensor();
        robot.addPart(ds);

        robot.exit();
    }

    public void lawnmower() {
        while (!robot.isEscapeHit) {
            gear.forward();
            while (!ds.isPresses()) {}
            gear.stop();
            //TODO: rough estimations, test pls
            gear.backward(200);
            gear.rightArc(0.2, 500);
        }
    }

    public void parcours() {
        gear.forward();
        while (!ds.isPressed()) {}
        gear.stop();
        gear.backward(200);
        right(drehen);
        while (!ds.isPressed()) {
            //TODO: not finished, AI too dumb
        }
    }

  
  public static void main(String[] args)
  {
    new DruckSensoren();
  }
} 
