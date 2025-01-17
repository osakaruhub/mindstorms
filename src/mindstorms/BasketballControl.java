public class BasketballControl {

    Socket s;
    public static final PORT = 1234;
    public static final HOST = "192.168.1.X" //replace with current ip

    public BasketballControl() throws IOException {

        do {
            s = new Socket(HOST, PORT);
            while (!s.connect()) {
                System.out.println("couldnt bind to "+ HOST +":" + PORT);
            }
        } while (s == null);
        JFrame frame = new JFrame("Move");
        frame.add(new JTextArea("Move with wasd or arrow keys"));
        frame.addKeyListener(new MoveListener(s.getInputStream()));
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

	class MoveListener implements KeyListener {
        
		public MoveListener(Gear gear) {
			this.gear = gear;
		}
		@Override
		public void keyPressed(KeyEvent arg0) {
			switch(arg0.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:
                sendChar('w');
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				gear.backward();
                sendChar('s');
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				gear.left();
                sendChar('a');
				break;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
                sendChar('d');
				break;
			case KeyEvent.VK_ENTER:
                sendChar('e')
			default:
				break;
			}
		}

        public Boolean sendChar(char c) {
            try (Socket socket = new Socket(serverAddress, port);
            OutputStream out = socket.getOutputStream()) {
                out.write(character);
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		

		@Override
		public void keyReleased(KeyEvent arg0) {
            sendChar('x');
		}

		@Override
		public void keyTyped(KeyEvent arg0) {}
    }
}
