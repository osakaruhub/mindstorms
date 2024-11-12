// Prototype2.java
// Test digital inputs

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

public class Prototype2
{
  private final int in = 0;

  public Prototype2()
  {
    LegoRobot robot = new LegoRobot();
    PrototypeSensor ps = new PrototypeSensor(SensorPort.S1);
    robot.addPart(ps);
    int[] ioControl =
    {
      in, in, in, in, in, in
    };
    ps.setDIO(ioControl);  // Default, not necessary
    while (!Tools.isEscapePressed())
    {
      int[] ain = new int[5];
      int[] din = new int[6];
      ps.read(ain, din);
      LCD.clear();
      for (int i = 0; i < 6; i++)
         LCD.drawString("d[" + i + "]=" + din[i], 0, i);
      Tools.delay(200);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Prototype2();
  }
}
