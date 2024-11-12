// ArduinoDemo.java
// I2C communication with Arduino using the EV3JLibA library
// Demo from http://www.aplu.ch/ev3

import ch.aplu.ev3.*;

public class ArduinoDemo
{
  public ArduinoDemo()
  {
    LegoRobot robot = new LegoRobot();
    ArduinoLink arduino = new ArduinoLink(SensorPort.S1);
    robot.addPart(arduino);
    robot.drawString("Arduino Link Test", 0, 0);
//    System.out.println("Arduino Link Test. Press up/down/left/right/enter/escape");
    String msg;
    int v;
    while (!robot.isEscapeHit())
    {
      if (robot.isDownHit())
      {
        msg = "Blinking stopped";
//        System.out.println(msg);
        robot.drawString(msg, 0, 2);
        v = arduino.getReplyInt(0);  // stop blinking
      }
      else if (robot.isUpHit())
      {
        msg = "Blinker started";
//        System.out.println(msg);
        robot.drawString(msg, 0, 2);
        v = arduino.getReplyInt(1);  // start blinking
      }
      else if (robot.isEnterHit())
      {
        msg = arduino.getReplyString(2);  // get version
 //       System.out.println("Version: " + msg);
        robot.drawString(msg, 0, 1);
      }
      else if (robot.isLeftHit())
      {
        msg = arduino.getReplyString(3);  // get switch state
//        System.out.println("Switch:" + msg);
        robot.drawString("State: " + msg, 0, 3);
      }
      else if (robot.isRightHit())
      {
        msg = arduino.getReplyString(4);  // get temperature
 //       System.out.println("Temperature: " + msg);
        robot.drawString("Temp: " + msg, 0, 4);
      }
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new ArduinoDemo();
  }
}
