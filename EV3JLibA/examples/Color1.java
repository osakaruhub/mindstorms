// Color1.java

import ch.aplu.ev3.*;
import java.awt.Color;
import lejos.hardware.lcd.LCD;

public class Color1
{
  public Color1()
  {
    LegoRobot robot = new LegoRobot();
    ColorSensor cs = new ColorSensor();
    robot.addPart(cs);

    while (!robot.isEscapeHit())
    {
      Color c = cs.getColor();
      LCD.clear();
      LCD.drawString("red: " + c.getRed(), 0, 1);
      LCD.drawString("green: " + c.getGreen(), 0, 2);
      LCD.drawString("blue: " + c.getBlue(), 0, 3);
      LCD.refresh();
      Tools.delay(300);
    }
    robot.exit();
  }  

  public static void main (String[] args)
  {
    new Color1();
  }
} 