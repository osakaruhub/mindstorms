// Color3.java

import ch.aplu.ev3.*;
import java.awt.Color;
import lejos.hardware.lcd.LCD;

public class Color3
{
  public Color3()
  {
    LegoRobot robot = new LegoRobot();
    ColorSensor cs = new ColorSensor(SensorPort.S1);
    robot.addPart(cs);

    while (!robot.isEscapeHit())
    {
      Color c = cs.getColor();
      LCD.clear();
      LCD.drawString(c.toString().substring(14), 0, 1);
      switch (cs.getColorLabel())
      {
        case BLACK:
          LCD.drawString("Black", 0, 2);
          break;
        case BLUE:
          LCD.drawString("Blue", 0, 2);
          break;
        case GREEN:
          LCD.drawString("Green", 0, 2);
          break;
        case YELLOW:
          LCD.drawString("Yellow", 0, 2);
          break;
        case RED:
          LCD.drawString("Red", 0, 2);
          break;
        case WHITE:
          LCD.drawString("White", 0, 2);
          break;
        case UNDEFINED:
          LCD.drawString("Undefined", 0, 2);
          break;
      }
      LCD.refresh();
      Tools.delay(200);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Color3();
  }
}
