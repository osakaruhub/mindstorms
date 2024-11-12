// HTCompass1.java

import ch.aplu.ev3.*;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class HTCompass1
{
  public HTCompass1()
  {
    LegoRobot robot = new LegoRobot();
    HTCompassSensor cp = new HTCompassSensor(SensorPort.S1);
    robot.addPart(cp);
    int v;
    
    while (!Tools.isEscapePressed())
    {
      v = cp.getValue();
      LCD.clear();
      LCD.drawString("d = " + v, 0, 1);
      Tools.delay(1000);
    }
    robot.exit();
   }

  public static void main(String[] args)
  {
    new HTCompass1();
  }
} 