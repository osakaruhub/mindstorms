
import ch.aplu.ev3.*;

public class TouchDemoEvent implements TouchListener
{
  private Gear gear;

  public TouchDemoEvent()
  {
    LegoRobot robot = new LegoRobot();
    gear = new Gear();
    robot.addPart(gear);
    TouchSensor ts = new TouchSensor(SensorPort.S1);
    robot.addPart(ts);
    ts.addTouchListener(this);
    gear.forward();
    Tools.waitEscape();
    robot.exit();
  }

  public void pressed(SensorPort port)
  {
    gear.backward(1000);
    gear.left(500);
    gear.forward();
  }

  public void released(SensorPort port)
  {
  }

  public static void main(String[] args)
  {
    new TouchDemoEvent();
  }
}
