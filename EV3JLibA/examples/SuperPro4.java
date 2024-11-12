// SuperPro4.java
// Test analog out 1

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

public class SuperPro4
{
  public SuperPro4()
  {
    LegoRobot robot = new LegoRobot();
    SuperProSensor sps = new SuperProSensor(SensorPort.S1);
    robot.addPart(sps);
    LCD.drawString("DC", 0, 1);
    sps.setAnalogOut1(0, 1000, 1021);
    while (!Tools.isEscapePressed())
    {}
    LCD.clear();
    LCD.drawString("Sin", 0, 1);
    sps.setAnalogOut1(1, 1000, 1021);
    Tools.delay(2000);
    while (!Tools.isEscapePressed())
    {}
    LCD.clear();
    LCD.drawString("Square", 0, 1);
    sps.setAnalogOut1(2, 1000, 1021);
    Tools.delay(2000);
    while (!Tools.isEscapePressed())
    {}
    LCD.clear();
    LCD.drawString("PosSawtooth", 0, 1);
    sps.setAnalogOut1(3, 1000, 1021);
    Tools.delay(2000);
    while (!Tools.isEscapePressed())
    {}
    LCD.clear();
    LCD.drawString("NegSawtooth", 0, 1);
    sps.setAnalogOut1(4, 1000, 1021);
    Tools.delay(2000);
    while (!Tools.isEscapePressed())
    {}
    LCD.clear();
    LCD.drawString("Triangle", 0, 1);
    sps.setAnalogOut1(5, 1000, 1021);
    Tools.delay(2000);
    while (!Tools.isEscapePressed())
    {}
    LCD.clear();
    LCD.drawString("PWM 10%", 0, 1);
    sps.setAnalogOut1(6, 1000, 100);  // 10% duty cycle
    Tools.delay(2000);
    while (!Tools.isEscapePressed())
    {}
    robot.exit();
  }

  public static void main(String[] args)
  {
    new SuperPro4();
  }
}
