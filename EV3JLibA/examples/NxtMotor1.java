// NxtMotor1.java

import ch.aplu.ev3.*;

public class NxtMotor1
{

  NxtMotor1()
  {
    LegoRobot robot = new LegoRobot();
    NxtMotor motA = new NxtMotor(MotorPort.A);
    NxtMotor motB = new NxtMotor(MotorPort.B);
    robot.addPart(motA);
    robot.addPart(motB);
    motA.forward();
    motB.forward();
    Tools.delay(3000);
    robot.exit();
  }

  public static void main(String[] args)
  {
    new NxtMotor1();
  }
}
