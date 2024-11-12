// Button1.java

import ch.aplu.ev3.*;

class Button1
{
  Button1()
  {
    LegoRobot robot = new LegoRobot();
    System.out.println("go");
    while (!Tools.isEscapePressed())
    {
      System.out.println("waiting...");
      Tools.delay(5000);
    }
    System.out.println("Done");
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    new Button1();
  }
}