// ShowModes.java

import ch.aplu.ev3.Tools;
import java.util.ArrayList;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.*;

public class ShowModes
{
  static final String[] classes =
  {
    "lejos.hardware.sensor.EV3ColorSensor",
    "lejos.hardware.sensor.EV3IRSensor",
    "lejos.hardware.sensor.EV3GyroSensor",
    "lejos.hardware.sensor.EV3TouchSensor",
    "lejos.hardware.sensor.NXTLightSensor",
    "lejos.hardware.sensor.NXTColorSensor",
    "lejos.hardware.sensor.NXTTouchSensor",
    "lejos.hardware.sensor.NXTSoundSensor",
    "lejos.hardware.sensor.NXTUltrasonicSensor",
    "lejos.hardware.sensor.CruizcoreGyro",
    "lejos.hardware.sensor.DexterCompassSensor",
    "lejos.hardware.sensor.DexterIMUSensor",
    "lejos.hardware.sensor.DexterLaserSensor",
    "lejos.hardware.sensor.DexterPressureSensor250",
    "lejos.hardware.sensor.DexterPressureSensor500",
    "lejos.hardware.sensor.DexterThermalIRSensor",
    "lejos.hardware.sensor.HiTechnicAccelerometer",
    "lejos.hardware.sensor.HiTechnicColorSensor",
    "lejos.hardware.sensor.HiTechnicGyro",
    "lejos.hardware.sensor.HiTechnicAngleSensor",
    "lejos.hardware.sensor.HiTechnicBarometer",
    "lejos.hardware.sensor.HiTechnicCompass",
    "lejos.hardware.sensor.HiTechnicEOPD",
    "lejos.hardware.sensor.HiTechnicIRSeekerV2",
    "lejos.hardware.sensor.HiTechnicMagneticSensor",
    "lejos.hardware.sensor.MindsensorsAbsoluteIMU",
    "lejos.hardware.sensor.MindsensorsAccelerometer",
    "lejos.hardware.sensor.MindsensorsCompass",
    "lejos.hardware.sensor.MindsensorsDistanceSensor",
    "lejos.hardware.sensor.MindsensorsLightSensorArray",
    "lejos.hardware.sensor.MindsensorsLineLeader",
    "lejos.hardware.sensor.MindsensorsPressureSensor"
  };
  
  
    
   public ShowModes()
   {
      SensorModes sensor = getSensor();
      ArrayList<String> modes = sensor.getAvailableModes();
      int n = 0;
      for (String mode : modes)
      {
        LCD.drawString("Mode: " + mode, 0, n);
        n += 1;
      }
      while (!Button.ENTER.isDown())
      {
        Tools.delay(10);
      }
      LCD.clear();
      LCD.refresh();
      int mode = 1;
      SensorMode sm = sensor.getMode(mode);
   
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
    I2CSensor sensor = new I2CSensor(LocalEV3.get().getPort("S1"));
    return (SensorModes)sensor;
  }

  public static void main(String[] args)
  {
    new ShowModes();
  }
   
}
