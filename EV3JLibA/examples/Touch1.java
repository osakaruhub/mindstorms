// Touch1.java

import ch.aplu.ev3.*;

public class Touch1
{
  public Touch1()
  {
    LegoRobot robot = new LegoRobot();
    TouchSensor ts = new TouchSensor(SensorPort.S1);
    robot.addPart(ts);

    while (!Tools.isEscapePressed())
    {
      if (ts.isPressed())
        System.out.println("pressed");
      Tools.delay(100);
    }
    robot.exit();
  }
  

  public static void main(String[] args)
  {
    new Touch1();
  }
} 