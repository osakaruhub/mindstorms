// Ultrasonic1.java

import ch.aplu.ev3.*;

public class Ultrasonic1
{
  public Ultrasonic1()
  {
    LegoRobot robot = new LegoRobot();
    UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
    robot.addPart(us);

    while (!Tools.isEscapePressed())
    {
      int value = us.getDistance();
      System.out.println("v: " + value);
      Tools.delay(200);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Ultrasonic1();
  }
} 