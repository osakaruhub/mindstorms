// Color5.java
// Color detection by sound

import ch.aplu.ev3.*;

public class Color5
{
  public Color5()
  {
    LegoRobot robot = new LegoRobot();
    ColorSensor cs = new ColorSensor(SensorPort.S1);
    robot.addPart(cs);
    ColorLabel oldColor = ColorLabel.UNDEFINED;

    while (!robot.isEscapeHit())
    {
      ColorLabel color = cs.getColorLabel();
      if (color != oldColor)
      {
        oldColor = color;
        switch (color)
        {
          case BLACK:
            robot.playTone(523, 100);
            break;
          case BLUE:
            robot.playTone(784, 100);
            break;
          case GREEN:
            robot.playTone(1046, 100);
            break;
          case YELLOW:
            robot.playTone(1568, 100);
            break;
          case RED:
            robot.playTone(2093, 100);
            break;
          case WHITE:
            robot.playTone(4186, 100);
            break;
        }
      }
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Color5();
  }
}
