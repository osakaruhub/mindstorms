// SuperPro5.java
// PWM test

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

public class SuperPro5
{
  public SuperPro5()
  {
    LegoRobot robot = new LegoRobot();
    SuperProSensor sps = new SuperProSensor(SensorPort.S1);
    robot.addPart(sps);
    int n = 100;
    while (n <= 1000)
    {
      LCD.clear();
      LCD.drawString("" + n, 0, 1);
      sps.setAnalogOut0(6, 1000, n);
      Tools.delay(2000);
      while (!Tools.isEscapePressed())
      {
      }
      n += 100;
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new SuperPro5();
  }
}
