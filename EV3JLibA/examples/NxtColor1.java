// NxtColor1.java

import ch.aplu.ev3.*;
import lejos.hardware.Button;

public class NxtColor1
{
  public NxtColor1()
  {
    LegoRobot robot = new LegoRobot();
    NxtColorSensor cs = new NxtColorSensor(SensorPort.S1);
    robot.addPart(cs);

    while (!Button.ESCAPE.isDown())
    {
      System.out.println(cs.getColor());
      Tools.delay(100);
    }
  }

  public static void main(String[] args)
  {
    new NxtColor1();
  }
} 