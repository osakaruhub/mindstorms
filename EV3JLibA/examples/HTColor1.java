// HTColor1.java

import ch.aplu.ev3.*;
import java.awt.Color;
import lejos.hardware.lcd.LCD;

public class HTColor1
{
  public HTColor1()
  {
    LegoRobot robot = new LegoRobot();
    HTColorSensor hcs = new HTColorSensor();
    robot.addPart(hcs);

    while (!Tools.isEscapePressed())
    {
      Color c = hcs.getColor();
      LCD.clear();
      LCD.drawString("red: " + c.getRed(), 0, 1);
      LCD.drawString("green: " + c.getGreen(), 0, 2);
      LCD.drawString("blue: " + c.getBlue(), 0, 3);
      LCD.drawString("ID: " + hcs.getColorID(), 0, 4);
      LCD.refresh();
      Tools.delay(300);
    }
    robot.exit();
  }  

  public static void main (String[] args)
  {
    new HTColor1();
  }
} 