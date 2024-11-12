// NxtTurtle1.java

import ch.aplu.ev3.*;

class NxtTurtle1
{
  NxtTurtle1()
  {
    NxtTurtleRobot robot = new NxtTurtleRobot();
    robot.forward(100);
    robot.exit();
  }
  public static void main(String[] args)
  {
    new NxtTurtle1();
  }
}