// Gear1.java

import ch.aplu.ev3.*;

class Gear1
{
  Gear1()
  {
    LegoRobot robot = new LegoRobot();
    Gear gear = new Gear();
    robot.addPart(gear);
    gear.setSpeed(10);
    gear.forward();
    Tools.delay(2000);
    gear.forward();
    Tools.delay(2000);
    gear.stop();
    robot.exit();
  }
  public static void main(String[] args)
  {
    new Gear1();
  }
}