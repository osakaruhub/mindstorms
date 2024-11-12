// TrappedRobot.java

import ch.aplu.ev3.*;
//import ch.aplu.nxt.*;
//import lejos.nxt.Button;

public class TrappedRobot implements LightListener
{
  private final int triggerLevel = 525;
  private Gear gear;

  public TrappedRobot()
  {
//    NxtRobot robot = new NxtRobot();
    LegoRobot robot = new LegoRobot();
    LightSensor ls = new LightSensor();
    robot.addPart(ls);
    ls.addLightListener(this, triggerLevel);
//    ls.activate(true);  
// No more necessary
    gear = new Gear();
    gear.setSpeed(30);
    robot.addPart(gear);
    gear.forward();

//    while (!Button.ESCAPE.isPressed()) {}
    Tools.waitEscape();
    robot.exit();
  }

  public void bright(SensorPort port, int level)
  {
    gear.backward(500);
    gear.left(500);
    gear.forward();
  }

  public void dark(SensorPort port, int level)
  {
  }

  public static void main(String[] args)
  {
    new TrappedRobot();
  }
}