// IRSensor1.java

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

class IRSensor2
{
  int channel = 1;

  IRSensor2()
  {
    LegoRobot robot = new LegoRobot();
    IRRemoteSensor irs = new IRRemoteSensor(SensorPort.S1);
    robot.addPart(irs);
    while (!Tools.isEscapePressed())
    {
      LCD.clear();
      int cmd = irs.getCommand(channel);
      LCD.drawString("channel: " + channel, 0, 1);
      LCD.drawString("command: " + cmd, 0, 2);
      LCD.refresh();
      Tools.delay(100);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new IRSensor2();
  }
}
