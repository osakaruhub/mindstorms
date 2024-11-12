// Color2.java

import ch.aplu.ev3.*;
import java.awt.Color;
import lejos.hardware.lcd.LCD;

public class Color2
{
  int[] blackCube = new int[] {0, 10, 0, 10, 0, 10};
  int[] blueCube = new int[] {5, 15, 10, 25, 15, 45};
  int[] greenCube = new int[] {8, 24, 25, 65, 3, 15};
  int[] yellowCube = new int[] {50, 90, 35, 90, 3, 20};
  int[] redCube = new int[] {40, 60, 5, 15, 3, 12};
  int[] whiteCube = new int[] {50, 120, 50, 120, 50, 120};
          
  public Color2()
  {
    LegoRobot robot = new LegoRobot();
    ColorSensor cs = new ColorSensor(SensorPort.S1);
    robot.addPart(cs);

    while (!robot.isEscapeHit())
    {
      Color c = cs.getColor();
      LCD.clear();
      LCD.drawString(c.toString().substring(14), 0, 1);
      if (cs.inColorCube(c, blackCube))
        LCD.drawString("Black", 0, 2);
      else if (cs.inColorCube(c, blueCube))
        LCD.drawString("Blue", 0, 2);
      else if (cs.inColorCube(c, greenCube))
        LCD.drawString("Green", 0, 2);
      else if (cs.inColorCube(c, yellowCube))
        LCD.drawString("Yellow", 0, 2);
      else if (cs.inColorCube(c, redCube))
        LCD.drawString("Red", 0, 2);
      else if (cs.inColorCube(c, whiteCube))
        LCD.drawString("White", 0, 2);
      else
        LCD.drawString("Undefined", 0, 2);
      LCD.refresh();
      Tools.delay(200);
    }
    robot.exit();
  }
 
  public static void main(String[] args)
  {
    new Color2();
  }
}


