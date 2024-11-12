// Arduino1.java
// I2C communication with Arduino using the leJOS library only

import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.I2CSensor;

public class Arduino1
{
  // Corresponds to Ardunio addres 0x04 because it uses 7 bit addressing 
  // and not 8 bit like leJOS
  static int I2CSlaveAddress = 8;
  static byte[] buffReadResponse = new byte[8];

  public static void main(String[] args)
  {
    System.out.println("Arduino Connection Test");
    I2CSensor arduino = new I2CSensor(SensorPort.S1, I2CSlaveAddress);

    while (Button.ESCAPE.isUp())
    {
      int id = Button.waitForAnyPress();
      if (id == Button.ID_ENTER)
      {
        arduino.getData('A', buffReadResponse, buffReadResponse.length);
        System.out.println(new String(buffReadResponse));
      }
    }
    arduino.close();
  }
}
