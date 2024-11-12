// NxtSound1.java

import ch.aplu.ev3.*;

public class NxtSound1
{
  public NxtSound1()
  {
    LegoRobot robot = new LegoRobot();
    NxtGear gear = new NxtGear();
    robot.addPart(gear);
    gear.setSpeed(30);
    NxtSoundSensor ss = new NxtSoundSensor(SensorPort.S1);
    robot.addPart(ss);

    Tools.delay(1000);

    while (!Tools.isEscapePressed())
    {
      int sound = ss.getValue();
      if (sound > 30)
        gear.forward();
    }
    robot.exit();
  }  

  public static void main (String[] args)
  {
    new NxtSound1();
  }
} 