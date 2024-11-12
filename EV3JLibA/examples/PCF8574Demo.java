// PCF8574Demo.java

import ch.aplu.ev3.*;

public class PCF8574Demo
{
  private static final int deviceType = 1; // PCF8574A
  private static final int i2CSlaveAddress = 0x70;  // PCF8574A
//  private static final int i2CSlaveAddress = 0x40; // PCF8574

  public PCF8574Demo()
  {
    LegoRobot robot = new LegoRobot();
    robot.drawString("PCF8574Demo1", 0, 0);
    I2CExpander i2C
      = new I2CExpander(SensorPort.S1, deviceType, i2CSlaveAddress);
    robot.addPart(i2C);
    int count = 0;
    while (!robot.isEscapeHit())
    {
      int out = 0x03;
      out = out + (count << 2);
      int reply = i2C.writeDigital(out);
      System.out.println("got: " + (reply & 0x03));
      count += 1;
      Tools.delay(100);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new PCF8574Demo();
  }
}
