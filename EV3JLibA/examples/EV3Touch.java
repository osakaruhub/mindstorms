// EV3Touch.java

import ch.aplu.ev3.Tools;
import java.util.ArrayList;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.*;

public class EV3Touch
{
   public EV3Touch()
   {
      EV3TouchSensor sensor = new EV3TouchSensor(LocalEV3.get().getPort("S1"));
      ArrayList<String>modes = sensor.getAvailableModes();
      /*
      System.out.println("Modes");
      for (String s : modes)
           System.out.println(s);
      */
      SensorMode sm = sensor.getMode(0);
   
      LCD.drawString("Press Escape", 0, 0);
      while (!Button.ESCAPE.isDown())
      {
        int sampleSize = sm.sampleSize();
        LCD.drawString("Samples:" + sampleSize, 0, 1);
        float samples[] = new float[sampleSize];
        sm.fetchSample(samples, 0);
        for (int i = 0; i < sampleSize; i++)
        {
          LCD.drawString("Val[" + i + "]: " + samples[i], 2, i + 2);
        }
        LCD.refresh();
        Tools.delay(100);
      }
    }
  
  private void displayValue(String name, int raw, int calibrated, int line)
  {
    LCD.drawString(name, 0, line);
    LCD.drawInt(raw, 5, 6, line);
    LCD.drawInt(calibrated, 5, 11, line);
  }
  
  public static void main(String[] args)
  {
    new EV3Touch();
  }
   
}
