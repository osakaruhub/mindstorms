// Optical1.java

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

public class Optical1
{
  public static void main(String[] args)
  {

    LegoRobot robot = new LegoRobot();
    OpticalDistanceSensor optical = new OpticalDistanceSensor(SensorPort.S1);
    robot.addPart(optical);
    while (!Tools.isEscapePressed())
    {
      LCD.clear();
      LCD.drawString("d = " + optical.getValue() + " mm", 0, 0);
      Tools.delay(100);
    }
    robot.exit();
  }
}
