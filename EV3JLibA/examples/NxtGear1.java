// NxtGear1.java

import ch.aplu.ev3.*;

class NxtGear1
{
  NxtGear1()
  {
    LegoRobot robot = new LegoRobot();
    NxtGear gear = new NxtGear();
    robot.addPart(gear);
    gear.setSpeed(30);
    gear.forward(2000);
    gear.left(480);
    gear.forward(2000);
    robot.exit();
  }
  public static void main(String[] args)
  {
    new NxtGear1();
  }
}