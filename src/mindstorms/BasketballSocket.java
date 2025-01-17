package mindstorms;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import ch.aplu.ev3.*;

public class Basketball {
    public final int PORT = 1234;
    public static final int LEVEL = 25;
    static LegoRobot robot;
    static Gear gear;
    UltrasonicSensor us0, us1, us2;
    static int points = 0;


    public Basketball() {
        robot = new LegoRobot();
        gear = new Gear();
        robot.addPart(gear);
        addSensors();
        startServer();
        while (!robot.isEscapeHit()) {
            robot.drawString("points: " + points + "", 1, 1);
            robot.drawString("points: " + us1.getDistance() + "", 1, 2);
        }
        robot.exit();
    }

    public void startServer() {
        Thread t = new Thread(new AcceptClients$(PORT));
        t.setDaemon(true);
        t.start();
    }

    public void addSensors() {
        us0 = new UltrasonicSensor(SensorPort.S1);
        us1 = new UltrasonicSensor(SensorPort.S2);
        us2 = new UltrasonicSensor(SensorPort.S3);
        us0.addUltrasonicListener(new ultrasonicListener(), LEVEL);
        us1.addUltrasonicListener(new ultrasonicListener(), LEVEL);
        us2.addUltrasonicListener(new ultrasonicListener(), LEVEL);
        robot.addPart(us0);
        robot.addPart(us1);
        robot.addPart(us2);
    }

    class ClientListener$ implements Runnable {
        ServerSocket sSocket;

        public void run() {
            while (true) {
                try {
                    System.out.println("starting ControlServer at " + this.host + ":" + this.port);
                    while (!close) {
                        Socket socket = sSocket.accept();
                        System.out.println("New client connected!");
                        new ClientHandle$(socket).start();
                    }
                    
                } catch (IOException e) {
                }
            }
        }
    }

    class ClientHandle implements Runnable {
		final int[][] notes = {{1,2,3},{1,2,3}}; // choose your own music
        private Socket socket;

        public ClientHandle(Socket s) {
            this.socket = s;
        } 

        public void run() throws IOException {
            switch ((char) s.read()) {
                case 'w':
                    gear.forward();
                    break;
                case 'a':
                    gear.left();
                    break;
                case 's':
                    gear.backwards();
                    break;
                case 'd':
                    gear.right();
                    break;
                case 'e':
                    funny();
                    break;
                case 'x':
                    gear.stop();
                    break;
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
    }

    class ultrasonicListener implements UltrasonicListener {

        @Override
        public void far(SensorPort arg0, int arg1) {}

        @Override
        public void near(SensorPort arg0, int arg1) {
            points++;
            robot.playTone(400, 1);
        }
    }

    public static void main(String[] args) {
        Basketball B = new Basketball();
    }
}
