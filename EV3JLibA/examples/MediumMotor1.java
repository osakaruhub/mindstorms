// MediumMotor1.java

import ch.aplu.ev3.*;

public class MediumMotor1
{

  MediumMotor1()
  {
    LegoRobot robot = new LegoRobot();
    MediumMotor mot = new MediumMotor(MotorPort.A);
    robot.addPart(mot);
    mot.forward();
    Tools.delay(3000);
    mot.backward();
    Tools.delay(3000);
    robot.exit();
  }

  public static void main(String[] args)
  {
    new MediumMotor1();
  }
}
