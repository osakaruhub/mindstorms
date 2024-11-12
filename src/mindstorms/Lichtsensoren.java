package mindstorms;
import ch.aplu.ev3.*;

public class Lichtsensoren {
  private final int drehen = 1500;
  static Boolean stop = false;

  public Lichtsensoren() {
    LegoRobot robot = new LegoRobot();
    Gear gear = new Gear();
    robot.addPart(gear);
    LightSensor ls = new LightSensor();
    robot.addPart(ls);
    bw();
    countStripes();
    followLine();
    robot.close();
  }

  public void bw() {
    gear.forward();
    for (int i = 0;!robot.isEscapeHit() || stop ; i++) {
      if (ls.getValue() > trigger) {
      }
    }
    gear.stop();
  }

  public bwLightListener implements LightListener {
        int count;

        public void bright() {}
        public void dark() {
            if (count >= 5) {
                Lichtsensor.stop = true
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
    ls.addLightListener.(new CountStripesLichtListener());
    gear.forward();
    while (!robot.isEscapeHit()) {}
    gear.stop();
  }

  class CountStripesLichtListener implements LightListener {
    public void bright() {}
    public void dark() {
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
  //public void followLine() {
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
  //}
}
