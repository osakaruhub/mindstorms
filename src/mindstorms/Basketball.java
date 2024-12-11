package mindstorms;

import ch.aplu.ev3.*;

public class Basketball {
	public static final int LEVEL = 25;
    LegoRobot robot;
    Gear gear;
    UltrasonicSensor us0;
    UltrasonicSensor us1;
    static int points = 0;

	
	public Basketball() {
		robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        us0 = new UltrasonicSensor();
        us1 = new UltrasonicSensor(SensorPort.S2);
        robot.addPart(us0);
        robot.addPart(us1);
        run();
        // add method calls here
        robot.exit();
	}
	
	public void run() {
		us0.addUltrasonicListener(new ultrasonicListener());
		us1.addUltrasonicListener(new ultrasonicListener());
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Basketball();
	}
	
	class ultrasonicListener implements UltrasonicListener {

		@Override
		public void far(SensorPort arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void near(SensorPort arg0, int arg1) {
			// TODO Auto-generated method stub
			points++;
		}
		
	}

}
