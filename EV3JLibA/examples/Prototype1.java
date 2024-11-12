// Prototype1.java
// Test digital out

import ch.aplu.ev3.*;

public class Prototype1
{
  private final int in = 0;
  private final int out = 1;

  public Prototype1()
  {
    LegoRobot robot = new LegoRobot();
    PrototypeSensor ps = new PrototypeSensor(SensorPort.S1);
    robot.addPart(ps);
    System.out.println("Version: " + ps.getVersion());
    System.out.println("ID: " + ps.getProductID());
    Tools.delay(3000);

//    int[] ioControl = {out, out, out, out, out, out};
//    ps.setDIO(ioControl);
    ps.setDIOMask(0x3F);
    int data = 0;

    while (!Tools.isEscapePressed())
    {
      ps.writeByte(data);
      System.out.println("data: " + data);
      data++;
      if (data == 32)
        data = 0;
      Tools.delay(200);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Prototype1();
  }
}
