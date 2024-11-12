// GyroRate1.java

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

public class GyroAngle1
{
  public GyroAngle1()
  {
    LegoRobot robot = new LegoRobot();
    GyroAngleSensor gas = new GyroAngleSensor(SensorPort.S1);
    robot.addPart(gas);
    int v;
    int k = 0;
    while (!Tools.isEscapePressed())
    {
      k++;
      v = gas.getValue();
      LCD.clear();
      LCD.drawString("v = " + v, 0, 1);
      Tools.delay(100);
      if (k == 100)
      {
        k = 0;
        gas.reset();
        LCD.drawString("reset", 0, 3);
        Tools.delay(100);
      }
    }
    robot.exit();
   }

  public static void main(String[] args)
  {
    new GyroAngle1();
  }
} 