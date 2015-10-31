import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends Applet implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;

	private boolean pause = false;
	private boolean gridDraw = true;

	Helloworld helloworld = new Helloworld();

	@Override
	public void init() {
		setSize(800, 600);
		addKeyListener(this);
		helloworld.setArray();
	}

	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void paint(Graphics g) {
		helloworld.paint(g, this);
		if(gridDraw)
			helloworld.drawGrid(g);
		
	}

	@Override
	public void update(Graphics g) {
		new DoubleBuffer(g, this);
	}

	@Override
	public void run() {
		while (true) {
			helloworld.update(this);
			repaint();
			try {
				Thread.sleep(17);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;

	boolean p2_W = false;
	boolean p2_S = false;
	boolean p2_D = false;
	boolean p2_A = false;
	int asdlas = helloworld.getWin();
	
	@Override
	public void keyPressed(KeyEvent e) {
		asdlas = helloworld.getWin();
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			helloworld.setArray();
			helloworld.setTurn((short)1);
			helloworld.setTally(0);
			helloworld.setWin(0);
			break;

		case KeyEvent.VK_F1:
			if(gridDraw)
				gridDraw = false;
			else if(!gridDraw)
				gridDraw = true;

		//if (asdlas == 0 ) {

		//	switch (e.getKeyCode()) {
	
			// Player One Move
			case KeyEvent.VK_LEFT:
				if (!left) {
					helloworld.moveLeft();
					left = true;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (!right) {
					helloworld.moveRight();
					right = true;
				}
				break;
			case KeyEvent.VK_UP:
				if (!up) {
					helloworld.moveUp();
					up = true;
				}
				break;
			case KeyEvent.VK_DOWN:
				if (!down) {
					helloworld.moveDown();
					down = true;
				}
				break;
				
			// Player Two Move
			case KeyEvent.VK_W:
				if (!p2_W) {
					helloworld.p2_moveUp();
					p2_W = true;
				}
				break;
			case KeyEvent.VK_S:
				if (!p2_S) {
					helloworld.p2_moveDown();
					p2_S = true;
				}
				break;
			case KeyEvent.VK_A:
				if (!p2_A) {
					helloworld.p2_moveLeft();
					p2_A = true;
				}
				break;
			case KeyEvent.VK_D:
				if (!p2_D) {
					helloworld.p2_moveRight();
					p2_D = true;
				}
				break;
			//}
		//}

		// Place Blocks
		case KeyEvent.VK_ENTER:
			if (asdlas != 0) {
				helloworld.setArray();
				helloworld.setTurn((short)1);
				helloworld.setTally(0);
				helloworld.setWin(0);
			}
			helloworld.placeBlue();
			break;
		case KeyEvent.VK_SPACE:
			if (asdlas != 0) {
				helloworld.setArray();
				helloworld.setTurn((short)1);
				helloworld.setTally(0);
				helloworld.setWin(0);
			}
			helloworld.placeRed();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		// Player one keys
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;

		// Player two keys
		case KeyEvent.VK_W:
			p2_W = false;
			break;
		case KeyEvent.VK_S:
			p2_S = false;
			break;
		case KeyEvent.VK_A:
			p2_A = false;
			break;
		case KeyEvent.VK_D:
			p2_D = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
