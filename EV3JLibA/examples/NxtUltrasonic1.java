// NxtUltrasonic1.java

import ch.aplu.ev3.*;

public class NxtUltrasonic1
{
  public NxtUltrasonic1()
  {
    LegoRobot robot = new LegoRobot();
    NxtUltrasonicSensor us = new NxtUltrasonicSensor(SensorPort.S1);
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
    new NxtUltrasonic1();
  }
} 