// PathFinder.java

import ch.aplu.ev3.*;

class PathFinder
{
  PathFinder()
  {
    LegoRobot robot = new LegoRobot();
    Gear gear = new Gear();
    LightSensor ls1 = new LightSensor(SensorPort.S1); // left
    LightSensor ls2 = new LightSensor(SensorPort.S2); // right
    robot.addPart(gear);
    robot.addPart(ls1);
    robot.addPart(ls2);
    gear.setSpeed(20);
    gear.forward();

    while (!robot.isEscapeHit())
    {
      int leftValue = ls1.getValue();
      int rightValue = ls2.getValue();
      int d = rightValue - leftValue;
      if (d > 100) // left dark , turn right
        gear.rightArc(0.1);
      if (d < -100) // right dark, turn left
        gear.leftArc(0.1);
      if (d > -100 && d < 100)
      {
        if (leftValue > 450)  // both bright (on path)
          gear.forward();
        else
          gear.backward();  // both dark (off path)
      }
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new PathFinder();
  }
}
