import java.awt.*;

public class Helloworld {

	int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
	int hx = 0, hy = 10, dhx = 2, dhy = 2, c = 0, counter = 0;
	String xString;
	String yString;
	String pressSpace = "press space to...";
	TextField txtField;
	int k;
	int[] x = new int[(800 / 20)];
	int[] y = new int[(600 / 20)];

	short[][] pos = new short[(800 / 20)][(600 / 20)];

	int xP1 = (800 / 20) - 1;
	int yP1 = (600 / 20) - 1;
	int xP2 = 0;
	int yP2 = 1;

	public void setArray() {
		for (int y = 0; y < (600 / 20); y++) {
			for (int x = 0; x < (800 / 20); x++) {
				pos[x][y] = 0;
			}
		}
	}

	public void moveRight() {
		if (xP1 < (800 / 20) - 1)
			xP1++;
	}

	public void moveLeft() {
		if (xP1 > 0)
			xP1--;
	}

	public void moveUp() {
		if (yP1 > 1)
			yP1--;
	}

	public void moveDown() {
		if (yP1 < (600 / 20) - 1)
			yP1++;
	}

	public void p2_moveUp() {
		if (yP2 > 1)
			yP2--;
	}

	public void p2_moveDown() {
		if (yP2 < (600 / 20) - 1)
			yP2++;
	}

	public void p2_moveLeft() {
		if (xP2 > 0)
			xP2--;
	}

	public void p2_moveRight() {
		if (xP2 < (800 / 20) - 1)
			xP2++;
	}

	short turn = 1;
	String ti = "Red";
	
	int lx = 1;
	int ly = 1;
	int tally = 1;
	int row = 4;
	int win = 0;
	
	public void placeRed() {
		if (pos[xP2][yP2] == 0 && turn == 1) {
			pos[xP2][yP2] = 1;
			
			if (pos[(xP2 - 1)][(yP2 - 1)] == turn
					|| pos[(xP2 + 1)][(yP2 + 1)] == turn) {
				
				while (pos[xP2 - lx][yP2 - ly] == turn) {
					tally++;
					lx++; ly++;
				}
				lx = 1; ly = 1;
				while (pos[xP2 + lx][yP2 + ly] == turn) {
					tally++;
					lx++; ly++;
				}
				lx = 1; ly = 1;
				if(tally >= row){
					System.out.println("win red diagonal");
					win = 2;
				}
				else{
					tally = 0;
				}
			}

			if (pos[(xP2 - 1)][(yP2 + 1)] == turn
					|| pos[(xP2 + 1)][(yP2 - 1)] == turn) {
				
				while (pos[xP2 - lx][yP2 + ly] == turn) {
					tally++;
					lx++; ly++;
				}
				lx = 1; ly = 1;
				while (pos[xP2 + lx][yP2 - ly] == turn) {
					tally++;
					lx++; ly++;
				}
				lx = 1; ly = 1;
				if(tally >= row){
					System.out.println("win red diagonal");
					win = 2;
				}
				else{
					tally = 0;
				}
			}
			
			if (pos[(xP2 - 1)][(yP2)] == turn
					|| pos[(xP2 + 1)][(yP2)] == turn) {
				
				while (pos[xP2 - lx][yP2] == turn) {
					tally++;
					lx++;
				}
				lx = 1;
				while (pos[xP2 + lx][yP2] == turn) {
					tally++;
					lx++;
				}
				lx = 1;
				if(tally >= row){
					System.out.println("win red horisontal");
					win = 2;
				}
				else{
					tally = 0;
				}
			}
			
			if (pos[(xP2)][(yP2 - 1)] == turn
					|| pos[(xP2)][(yP2 + 1)] == turn) {
				
				while (pos[xP2][yP2 - ly] == turn) {
					tally++;
					ly++;
				}
				ly = 1;
				while (pos[xP2][yP2 + ly] == turn) {
					tally++;
					ly++;
				}
				ly = 1;
				if(tally >= row){
					System.out.println("win red vertical");
					win = 2;
				}
				else{
					tally = 0;
				}
			}
			
			turn = 2;
		}
	}

	

	public void placeBlue() {
		if (pos[xP1][yP1] == 0 && turn == 2) {
			pos[xP1][yP1] = 2;

			if (pos[(xP1 - 1)][(yP1 - 1)] == turn
					|| pos[(xP1 + 1)][(yP1 + 1)] == turn) {
				
				while (pos[xP1 - lx][yP1 - ly] == turn) {
					tally++;
					lx++; ly++;
				}
				lx = 1; ly = 1;
				while (pos[xP1 + lx][yP1 + ly] == turn) {
					tally++;
					lx++; ly++;
				}
				lx = 1; ly = 1;
				if(tally >= row){
					System.out.println("win blue diagonal");
					win = 1;
				}
				else{
					tally = 0;
				}
			}

			if (pos[(xP1 - 1)][(yP1 + 1)] == turn
					|| pos[(xP1 + 1)][(yP1 - 1)] == turn) {
				
				while (pos[xP1 - lx][yP1 + ly] == turn) {
					tally++;
					lx++; ly++;
				}
				lx = 1; ly = 1;
				while (pos[xP1 + lx][yP1 - ly] == turn) {
					tally++;
					lx++; ly++;
				}
				lx = 1; ly = 1;
				if(tally >= row){
					System.out.println("win blue diagonal");
					win = 1;
				}
				else{
					tally = 0;
				}
			}
			
			if (pos[(xP1 - 1)][(yP1)] == turn
					|| pos[(xP1 + 1)][(yP1)] == turn) {
				
				while (pos[xP1 - lx][yP1] == turn) {
					tally++;
					lx++;
				}
				lx = 1;
				while (pos[xP1 + lx][yP1] == turn) {
					tally++;
					lx++;
				}
				lx = 1;
				if(tally >= row){
					System.out.println("win blue horisontal");
					win = 1;
				}
				else{
					tally = 0;
				}
			}
			
			if (pos[(xP1)][(yP1 - 1)] == turn
					|| pos[(xP1)][(yP1 + 1)] == turn) {
				
				while (pos[xP1][yP1 - ly] == turn) {
					tally++;
					ly++;
				}
				ly = 1;
				while (pos[xP1][yP1 + ly] == turn) {
					tally++;
					ly++;
				}
				ly = 1;
				if(tally >= row){
					System.out.println("win blue vertical");
					win = 1;
				}
				else{
					tally = 0;
				}
			}
			lx = 1; ly = 1;
			turn = 1;
		}
	}


	boolean drawGrid = true;

	public void drawGrid(Graphics g) {
		for (int y = 1; y < (600 / 20); y++) {
			for (int x = 0; x < (800 / 20); x++) {
				if (pos[x][y] == 0) {
					g.setColor(Color.WHITE);
					g.drawRect(x * 20, y * 20, 20, 20);
				}
			}
		}
		drawGrid = true;
	}

	public void paint(Graphics g, Main awesome) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
		g.setColor(Color.WHITE);
		g.drawString("Ultimate Tic-Tac-Toe!", 350, 15);
		g.drawString("turn: ", 750, 15);
		if (win == 1) {
			g.drawString("Blue Wins!", 15, 15);
		}
		if (win == 2) {
			g.drawString("Red Wins!", 15, 15);
		}
		if (turn == 1)
			g.setColor(Color.RED);
		else if (turn == 2)
			g.setColor(Color.BLUE);

		g.fillRect(780, 5, 10, 10);

		for (int y = 1; y < (600 / 20); y++) {
			for (int x = 0; x < (800 / 20); x++) {
				if (pos[x][y] == 1) {
					g.setColor(Color.RED);
					g.fillRect(x * 20, y * 20, 20, 20);
					if (drawGrid) {
						g.setColor(Color.WHITE);
						g.drawRect(x * 20, y * 20, 20, 20);
					}
				} else if (pos[x][y] == 2) {
					g.setColor(Color.BLUE);
					g.fillRect(x * 20, y * 20, 20, 20);
					if (drawGrid) {
						g.setColor(Color.WHITE);
						g.drawRect(x * 20, y * 20, 20, 20);
					}

				}
			}
		}

		g.setColor(Color.CYAN);
		g.drawRect(xP1 * 20, yP1 * 20, 20, 20);
		g.drawRect(xP1 * 20 + 1, yP1 * 20 + 1, 18, 18);
		g.drawRect(xP1 * 20 + 2, yP1 * 20 + 2, 16, 16);

		if (xP1 == xP2 && yP1 == yP2)
			g.setColor(Color.GREEN);
		else
			g.setColor(Color.ORANGE);
		g.drawRect(xP2 * 20, yP2 * 20, 20, 20);
		g.drawRect(xP2 * 20 + 1, yP2 * 20 + 1, 18, 18);
		g.drawRect(xP2 * 20 + 2, yP2 * 20 + 2, 16, 16);

		drawGrid = false;
	}

	public void update(Main awesome) {

		xString = Integer.toString(hx);
		yString = Integer.toString(hy);

	}
	
	public void setTurn(short turn) {
		this.turn = turn;
	}
	public void setTally(int tally) {
		this.tally = tally;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
}
