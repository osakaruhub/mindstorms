// SuperPro6.java
// Analog 0 in test

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

public class SuperPro6
{
  public SuperPro6()
  {
    LegoRobot robot = new LegoRobot();
    SuperProSensor sps = new SuperProSensor(SensorPort.S1);
    robot.addPart(sps);
    int[] ain = new int[4];
    while (!Tools.isEscapePressed())
    {
      sps.readAnalog(ain);
      LCD.clear();
      LCD.drawString("a[0] = " + ain[0], 0, 1);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new SuperPro6();
  }
}
