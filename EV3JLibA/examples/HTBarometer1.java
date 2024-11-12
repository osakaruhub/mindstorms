// HTBarometer1.java

import ch.aplu.ev3.*;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class HTBarometer1
{
  public HTBarometer1()
  {
    LegoRobot robot = new LegoRobot();
    HTBarometer bm = new HTBarometer(SensorPort.S1);
    robot.addPart(bm);
    int v;
    
    while (!Tools.isEscapePressed())
    {
      v = bm.getValue();
      LCD.clear();
      LCD.drawString("p = " + v + "pa", 0, 1);
      Tools.delay(1000);
    }
    robot.exit();
   }

  public static void main(String[] args)
  {
    new HTBarometer1();
  }
} 