// IRSensor1.java

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

class IRSensor3
{
  int channel = 1;

  IRSensor3()
  {
    LegoRobot robot = new LegoRobot();
    Motor mot1 = new Motor(MotorPort.A);
    Motor mot2 = new Motor(MotorPort.B);
    robot.addPart(mot1);
    robot.addPart(mot2);
    IRRemoteSensor irs = new IRRemoteSensor(SensorPort.S1);
    robot.addPart(irs);
    while (!Tools.isEscapePressed())
    {
      LCD.clear();
      int cmd = irs.getCommand(channel);
      switch (cmd)
      {
        case 0: 
          mot1.stop();
          mot2.stop();
          break;
        case 1: 
          mot1.forward();
          break;
        case 2: 
          mot1.backward();
          break;
        case 3: 
          mot2.forward();
          break;
        case 4: 
          mot2.backward();
          break;
      }
      Tools.delay(100);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new IRSensor3();
  }
}
