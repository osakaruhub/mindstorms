// RemoteIRControl.java
// EV3 Infrared Sensor at port S4!

import ch.aplu.ev3.*;
import lejos.hardware.lcd.LCD;

class RemoteIRControl
{
  public enum Command
  {
    Nothing, TopL, BottomL, TopR, 
    BottomR, TopL_TopR, TopL_BottomR,
    BottomL_TopR, BottomL_BottomR, 
    Center, BottomL_TopL, TopR_BottomR
  }
  
  private int channel = 1;

  RemoteIRControl()
  {
    LegoRobot robot = new LegoRobot();
    Gear gear = new Gear();
    robot.addPart(gear);
    IRRemoteSensor irs = new IRRemoteSensor(SensorPort.S4);
    robot.addPart(irs);
    LCD.drawString("IR Control Ready", 0, 1);
    robot.playTone(600, 100);
    while (!Tools.isEscapePressed())
    {
      int cmd = irs.getCommand(channel);
      Command command = Command.values()[cmd];
      switch (command)
      {
        case Center: 
          gear.stop();
          break;
        case TopL: 
          gear.leftArc(0.2);
          break;
        case TopR: 
          gear.rightArc(0.2);
          break;
        case TopL_TopR: 
          gear.forward();
          break;
        case BottomL: 
          gear.leftArc(-0.2);
          break;
        case BottomR: 
          gear.rightArc(-0.2);
          break;
        case BottomL_BottomR: 
          gear.backward();
          break;
      }
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new RemoteIRControl();
  }
}
