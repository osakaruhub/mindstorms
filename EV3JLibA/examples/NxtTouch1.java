// NxtTouch1.java

import ch.aplu.ev3.*;

public class NxtTouch1
{
  public NxtTouch1()
  {
    LegoRobot robot = new LegoRobot();
    NxtGear gear = new NxtGear();
    robot.addPart(gear);
    NxtTouchSensor ts = new NxtTouchSensor(SensorPort.S1);
    robot.addPart(ts);
    gear.setSpeed(30);
    gear.forward();

    while (!Tools.isEscapePressed())
    {
      if (ts.isPressed())
      {
        gear.backward(800);
        gear.left(500);
        gear.forward();
      }
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new NxtTouch1();
  }
} 