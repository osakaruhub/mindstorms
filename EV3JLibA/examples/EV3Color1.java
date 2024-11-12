// EV3Color1.java

import ch.aplu.ev3.Tools;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.*;

public class EV3Color1
{
   public EV3Color1()
   {
      EV3ColorSensor sensor = new EV3ColorSensor(LocalEV3.get().getPort("S1"));
      SensorMode sm = sensor.getRGBMode();
   
      while (!Button.ESCAPE.isDown())
      {
        LCD.drawString("Mode: " + sm.getName(), 0, 0);
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

  private SensorModes getSensor()
  {
    EV3ColorSensor sensor = new EV3ColorSensor(LocalEV3.get().getPort("S1"));
    return (SensorModes)sensor;
  }

  public static void main(String[] args)
  {
    new EV3Color1();
  }
   
}
