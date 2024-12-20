/**
 * ErstesFahren
 */
package mindstorms;

import ch.aplu.ev3.*;

/**
 * ErstesFahren
 */
public class ErstesFahren
{
  public ErstesFahren()
  {
    // init
    LegoRobot robot = new LegoRobot(); // erstelle Roboter und fuege einen Motor an
    Gear gear = new Gear();
    robot.addPart(gear);
        
    gear.forward(1000); // simples Fahren
    gear.left(500);
    gear.right(500);
    gear.backward(1000);
    gear.stop();
        
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    new ErstesFahren();
  }
} 
