package mindstorms;
import ch.aplu.ev3.*;

public class Lichtsensoren {
	private final int drehen = 1250;
	static Boolean stop = false;
	int level = 100;
	LegoRobot robot;
	Gear gear;
	LightSensor ls;

  public Lichtsensoren() {
    robot = new LegoRobot();
    gear = new Gear();
    robot.addPart(gear);
    ls = new LightSensor();
    robot.addPart(ls);
    ls.activate(true);
    bw();
    robot.playTone(500, 1000);
    robot.exit();
  }

  public void bw() {
	  ls.addLightListener(new bwLightListener(), level);
	  gear.forward();
    while (!robot.isEscapeHit() || stop) {
    	robot.drawString(ls.getValue() + "", 1, 1);
    }
    gear.stop();
  }

  class bwLightListener implements LightListener {
        int count;

        public void dark(SensorPort port, int level) {}
        public void bright(SensorPort port, int level) {
            if (count >= 5) {
                stop = true;
            } else {
                gear.stop();
                gear.left(drehen);
                gear.forward();
                count++;
            }
        }
    }

  public void countStripes() {
    ls.addLightListener(new CountStripesLightListener(), level);
    gear.forward();
    while (!robot.isEscapeHit()) {}
    gear.stop();
  }

  class CountStripesLightListener implements LightListener {
	int count = 0;
    public void dark(SensorPort port, int level) {}
    public void bright(SensorPort port, int level) {
    	robot.playTone(600, 300);
    	count++;
    	System.out.println(count);
        try {
            Thread.sleep(100); // Sleep to prevent busy waiting
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
  }

  //STUB
  public void followLine() {
  //  while (!robot.isEscapeHit()) {
  //  }
  //}
  //
  //Enum Direction {
  //  left,
  //  middle,
  //  right,
  //}
  //
  //class RightLightListener implements LightListener{
  //  public RightLightListener(){
  //
  //  }
  //  public void bright() {
  //  }
  //  public void dark() {
  //  }
  //}
  //class LeftLightListener implements LightListener{
  //  public LeftLightListener(){
  //
  //  }
  }
  public static void main(String[] args) {
	  new Lichtsensoren();
  }
}
