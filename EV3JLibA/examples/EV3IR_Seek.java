// EV3Touch.java

import ch.aplu.ev3.Tools;
import java.util.ArrayList;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.*;

public class EV3IR_Seek
{
   public EV3IR_Seek()
   {
      EV3IRSensor sensor = new EV3IRSensor(LocalEV3.get().getPort("S1"));
      SensorMode sm = sensor.getSeekMode();
   
      LCD.drawString("Press Escape", 0, 0);
      while (!Button.ESCAPE.isDown())
      {
        LCD.clear();
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
 
  
  public static void main(String[] args)
  {
    new EV3IR_Seek();
  }
   
}
