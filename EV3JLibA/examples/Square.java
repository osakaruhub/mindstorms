// Square.java

import ch.aplu.ev3.*;

class Square
{
  Square()
  {
    TurtleRobot robot = new TurtleRobot();

    while (!robot.isEscapeHit())
    {
      robot.forward(50);
      robot.left(90);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Square();
  }
}