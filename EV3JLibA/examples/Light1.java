// Light1.java

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

public class Light1
{
  public Light1()
  {
    LegoRobot robot = new LegoRobot();
    LightSensor ls = new LightSensor(SensorPort.S1);
    robot.addPart(ls);

    while (!Tools.isEscapePressed())
    {  
      int v = ls.getValue();
      LCD.drawString("value: " + v, 0, 1);
      LCD.refresh();
      Tools.delay(300);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Light1();
  }
} 