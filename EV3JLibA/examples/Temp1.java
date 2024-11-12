// Temp1.java

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

public class Temp1
{
  public Temp1()
  {
    LegoRobot robot = new LegoRobot();
    TemperatureSensor temp = new TemperatureSensor(SensorPort.S1);
    robot.addPart(temp);
    

    while (!robot.isEscapeHit())
    {
      double T = temp.getTemperature();
      LCD.clear(1);
      LCD.drawString("T = " + T + " deg", 0, 1);
      Tools.delay(1000);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Temp1();
  }
}
