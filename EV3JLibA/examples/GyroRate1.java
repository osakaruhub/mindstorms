// GyroRate1.java

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

public class GyroRate1
{
  public GyroRate1()
  {
    LegoRobot robot = new LegoRobot();
    GyroRateSensor grs = new GyroRateSensor(SensorPort.S1);
    robot.addPart(grs);
    int v;
    
    while (!Tools.isEscapePressed())
    {
      v = grs.getValue();
      LCD.clear();
      LCD.drawString("v = " + v, 0, 1);
      Tools.delay(100);
    }
    robot.exit();
   }

  public static void main(String[] args)
  {
    new GyroRate1();
  }
} 