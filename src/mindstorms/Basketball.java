package mindstorms;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import ch.aplu.ev3.*;

public class Basketball {
	public static final int LEVEL = 25;
    LegoRobot robot;
    Gear gear;
    UltrasonicSensor us0, us1, us2;
    static int points = 0;

	
	public Basketball() {
		robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        us0 = new UltrasonicSensor(SensorPort.S1);
        us1 = new UltrasonicSensor(SensorPort.S2);
        us2 = new UltrasonicSensor(SensorPort.S3);
		us0.addUltrasonicListener(new ultrasonicListener(),LEVEL);
		us1.addUltrasonicListener(new ultrasonicListener(),LEVEL);
		us2.addUltrasonicListener(new ultrasonicListener(),LEVEL);
        robot.addPart(us0);
        robot.addPart(us1);
        robot.addPart(us2);
        JFrame frame = new JFrame("Move");
        frame.add(new JTextArea("Move with wasd or arrow keys"));
        frame.addKeyListener(new MoveListener(gear));
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        while (true) {
        	robot.drawString("points: " + points + "", 1, 1);
        	robot.drawString("points: " + us1.getDistance() + "", 1, 2);
        	if (robot.isEscapeHit()) {
        		robot.exit();
        		System.exit(0);
        	}
         }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Basketball B = new Basketball();
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
			robot.playTone(400, 1);
		}
	}
	class MoveListener implements KeyListener {
		final int[][] notes = {{1,2,3},{1,2,3}}; // choose your own music
		private Gear gear;
		public MoveListener(Gear gear) {
			this.gear = gear;
		}
		@Override
		public void keyPressed(KeyEvent arg0) {
			switch(arg0.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:
				gear.forward();
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				gear.backward();
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				gear.left();
				break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				gear.right();
				break;
			case KeyEvent.VK_ENTER:
				funny();
			default:
				break;
			}
		}
		
		public void funny() {
			try {
				for (int[] note : notes) {
					robot.playTone(note[0], note[1]);
					robot.wait(note[2] * 1000);
				}
			} catch (InterruptedException e) {};
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			gear.stop();
		}

		@Override
		public void keyTyped(KeyEvent arg0) {}
	}
}
