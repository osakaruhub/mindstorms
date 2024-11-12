// HTAccelerometer1.java

import ch.aplu.ev3.*;
import lejos.hardware.Button;

public class HTAccelerometer1
{
  public HTAccelerometer1()
  {
    LegoRobot robot = new LegoRobot();
    HTAccelerometer acc = new HTAccelerometer(SensorPort.S1);
    robot.addPart(acc);

    while (!Button.ESCAPE.isDown())
    {
      System.out.println(acc.getValue());
      Tools.delay(100);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new HTAccelerometer1();
  }
} 