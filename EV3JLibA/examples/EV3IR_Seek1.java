// EV3Touch.java

import ch.aplu.ev3.Tools;
import java.util.ArrayList;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.*;

public class EV3IR_Seek1
{
  class IRValue
  {
    public int channel;
    public int bearing;
    public int distance;
  }

  EV3IRSensor sensor;
  SensorMode sm;

  public EV3IR_Seek1()
  {
    sensor = new EV3IRSensor(LocalEV3.get().getPort("S1"));
    sm = sensor.getSeekMode();

    int channel = 1;

    LCD.drawString("Press Escape", 0, 0);
    while (!Button.ESCAPE.isDown())
    {
      LCD.clear();
      IRValue irValue = getValue(channel);
      LCD.drawString("bearing raw: " + irValue.bearing, 0, 1);
      LCD.drawString("distance raw: " + irValue.distance, 0, 2);
      int value = toIntValue(irValue);
      LCD.drawString("int value: " + value, 0, 3);
      IRValue irValue1 = toIRValue(value);
      LCD.drawString("bearing: " + irValue1.bearing, 0, 4);
      LCD.drawString("distance: " + irValue1.distance, 0, 5);
      LCD.refresh();
      Tools.delay(100);
    }
  }

  public IRValue getValue(int channel)
  {
    IRValue irValue = new IRValue();
    int sampleSize = 8;
    float samples[] = new float[sampleSize];
    sm.fetchSample(samples, 0);

    irValue.channel = channel;
    irValue.bearing = (int)(samples[2 * (channel - 1)]);
    irValue.distance = (int)(samples[2 * (channel - 1) + 1]);
    return irValue;
  }

  public int getIntValue(int channel)
  {
    return toIntValue(getValue(channel));
  }

  public int toIntValue(IRValue irValue)
  {
    int bearing = irValue.bearing + 64;
    bearing = Math.min(bearing, 255);
    int distance = Math.min(irValue.distance, 255);
    int value = bearing + (distance << 8);
    return value;
  }

  public IRValue toIRValue(int value)
  {
    IRValue irValue = new IRValue();
    irValue.bearing = (value & 0xFF) - 64;
    irValue.distance = ((value >> 8) & 0xFF);
    return irValue;
  }

  public static void main(String[] args)
  {
    new EV3IR_Seek1();
  }

}
