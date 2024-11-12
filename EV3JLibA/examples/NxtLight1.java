// LightSensorTest.java

import ch.aplu.ev3.*;

public class NxtLight1
{
  public NxtLight1()
  {
    LegoRobot robot = new LegoRobot();
    NxtLightSensor ls = new NxtLightSensor(SensorPort.S1);
    robot.addPart(ls);

    int nb = 0;
    while (!Tools.isEscapePressed())
    {
      System.out.println("# " + nb + ": " + ls.getValue());
      nb++;
      Tools.delay(1000);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new NxtLight1();
  }
} 