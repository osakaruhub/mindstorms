package mindstorms;
import ch.aplu.ev3.*;

public class Lichtsensoren {
	private final int drehen = 1500;
	static Boolean stop = false;
	int level = 20;
	LegoRobot robot;
	Gear gear;

  public Lichtsensoren() {
    robot = new LegoRobot();
    gear = new Gear();
    robot.addPart(gear);
    LightSensor ls = new LightSensor();
    robot.addPart(ls);
    bw();
    countStripes();
    followLine();
    robot.exit();
  }

  public void bw() {
	  gear.forward();
    for (int i = 0;!robot.isEscapeHit() || stop ; i++) {
      if (ls.getValue() > trigger) {
      }
    }
    gear.stop();
  }

  public class bwLightListener implements LightListener {
        int count;

        public void bright() {}
        public void dark() {
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
    static Boolean stop = false; 
    static int i = 0;
    ls.addLightListener.(new CountStripesLightListener(), level);
    gear.forward();
    while (!robot.isEscapeHit()) {}
    gear.stop();
  }

  class CountStripesLightListener implements LightListener {
    public void bright(SensorPort port, int level) {}
    public void dark(SensorPort port, int level) {
      Lichtsensoren.i++;
      System.out.println(i);
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
}
