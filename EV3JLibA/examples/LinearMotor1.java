// LinaerMotor1.java
// www.firgelli.com
// Type L12-NXT-50

import ch.aplu.ev3.*;

public class LinearMotor1
{

  LinearMotor1()
  {
    LegoRobot robot = new LegoRobot();
    MediumMotor mot = new MediumMotor(MotorPort.A);
    robot.addPart(mot);
    for (int i = 0; i < 10; i++)
    {
      mot.forward();
      Tools.delay(3000);
      mot.backward();
      Tools.delay(3000);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new LinearMotor1();
  }
}
