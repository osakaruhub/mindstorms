// SuperPro2.java
// Test digital inputs

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

public class SuperPro2
{
  private final int in = 0;

  public SuperPro2()
  {
    LegoRobot robot = new LegoRobot();
    SuperProSensor sps = new SuperProSensor(SensorPort.S1);
    robot.addPart(sps);
    int[] ioControl =
    {
      in, in, in, in, in, in, in, in
    };
    sps.setDIO(ioControl);  // Default, not necessary
    while (!Tools.isEscapePressed())
    {
      int[] ain = new int[4];
      int[] din = new int[8];
      sps.read(ain, din);
      LCD.clear();
      for (int i = 0; i < 8; i++)
         LCD.drawString("d[" + i + "]=" + din[i], 0, i);
      Tools.delay(200);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new SuperPro2();
  }
}
