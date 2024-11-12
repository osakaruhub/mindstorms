// Arduino2.java
// I2C communication with Arduino using the EV3JLibA library

import ch.aplu.ev3.*;

public class Arduino2
{
  public Arduino2()
  {
    LegoRobot robot = new LegoRobot();
    ArduinoLink arduino = new ArduinoLink(SensorPort.S1);
    robot.addPart(arduino);

    System.out.println("Arduino Conn Test");

    while (!robot.isEscapeHit())
    {
      if (robot.isEnterHit())
      {
        String reply = arduino.getReplyString(65);
        System.out.println(reply);
      }
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Arduino2();
  }
}
