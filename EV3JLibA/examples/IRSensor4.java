// IRSensor1.java

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

class IRSensor4
{
  IRSensor4()
  {
    LegoRobot robot = new LegoRobot();
    IRDistanceSensor irs = new IRDistanceSensor(SensorPort.S1);
    robot.addPart(irs);
    while (!Tools.isEscapePressed())
    {
      LCD.clear();
      int d = irs.getDistance();
      LCD.drawString("dist: " + d, 0, 1);
      LCD.refresh();
      Tools.delay(100);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new IRSensor4();
  }
}
