// Motor1.java

import ch.aplu.ev3.*;

public class Motor1
{

  Motor1()
  {
    LegoRobot robot = new LegoRobot();
    Motor motA = new Motor(MotorPort.A);
    Motor motB = new Motor(MotorPort.B);
    robot.addPart(motA);
    robot.addPart(motB);
    motA.forward();
    motB.forward();
    Tools.delay(3000);
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Motor1();
  }
}
