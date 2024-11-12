// SuperPro1.java
// Test digital out

import ch.aplu.ev3.*;

public class SuperPro1
{
  private final int in = 0;
  private final int out = 1;

  public SuperPro1()
  {
    LegoRobot robot = new LegoRobot();
    SuperProSensor sps = new SuperProSensor(SensorPort.S1);
    robot.addPart(sps);
    System.out.println("Version: " + sps.getVersion());
    System.out.println("ID: " + sps.getProductID());
    Tools.delay(3000);

//    int[] ioControl = {out, out, out, out, out, out};
//    ps.setDIO(ioControl);
    sps.setDIOMask(0xFF);
    int data = 0;

    while (!Tools.isEscapePressed())
    {
      sps.writeByte(data);
      System.out.println("data: " + data);
      data++;
      if (data == 256)
        data = 0;
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new SuperPro1();
  }
}
