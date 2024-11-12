// IRSensor1.java

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

class IRSensor1
{
  int channel = 1;

  IRSensor1()
  {
    LegoRobot robot = new LegoRobot();
    IRSeekSensor irs = new IRSeekSensor(SensorPort.S1);
    robot.addPart(irs);
    while (!Tools.isEscapePressed())
    {
      LCD.clear();
      GenericIRSensor.IRValue v = irs.getValue(channel);
      LCD.drawString("channel: " + channel, 0, 1);
      LCD.drawString("bearing: " + v.bearing, 0, 2);
      LCD.drawString("distance: " + v.distance, 0, 3);
      LCD.refresh();
      Tools.delay(300);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new IRSensor1();
  }
}
