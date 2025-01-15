package Drucksensor;

import ch.aplu.ev3.*;

public class Drucksensor1 {
  public Drucksensor1() {
    LegoRobot robot = new LegoRobot();

    Gear gear = new Gear();
    robot.addPart(gear);

    TouchSensor ts1 = new TouchSensor(SensorPort.S1);
    // TouchSensor ts2 = new TouchSensor(SensorPort.S2);
    robot.addPart(ts1);
    // robot.addPart(ts2);

    int counter = 0;

    gear.forward();

    while (!robot.isEscapeHit()) {
      // if ((ts1.isPressed() || ts2.isPressed()) && counter % 2 == 0)
      if (ts1.isPressed() && counter % 2 == 0) {
        gear.backward(1000);
        gear.right(700);
        gear.forward(1000);
        gear.right(700);
        gear.forward();
        counter++;
      }

      // if ((ts1.isPressed() || ts2.isPressed()) && counter % 2 == 1)
      if (ts1.isPressed() && counter % 2 == 1) {
        gear.backward(1000);
        gear.left(700);
        gear.forward(1000);
        gear.left(700);
        gear.forward();
        counter--;
      }
      robot.exit();
    }
  }

  public static void main(String[] args) {
    new Drucksensor1();
  }
}
