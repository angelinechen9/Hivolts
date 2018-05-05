
import java.applet.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.KeyStroke;

public class Hivolts extends Applet implements KeyListener {
	public static Player player = new Player();
	public static ArrayList<Mho> mhos = new ArrayList<Mho>();
	public static ArrayList<Integer> indexes = new ArrayList<Integer>();
	public static ArrayList<Fence> border = new ArrayList<Fence>();
	public static ArrayList<Fence> fences = new ArrayList<Fence>();
	private int count = 0;
	private boolean upandleft = false;
	private boolean up = false;
	private boolean upandright = false;
	private boolean left = false;
	private boolean sit = false;
	private boolean right = false;
	private boolean downandleft = false;
	private boolean down = false;
	private boolean downandright = false;
	private boolean jump = false;
	private BufferedImage playerimage = null;
	private BufferedImage mhoimage = null;
	private BufferedImage fenceimage = null;
	
	/**
	 * initializes the graphics window
	 * @param none
	 * @return none
	 */
	public void init() {
		setSize(600, 600);
		setBackground(Color.WHITE);
		try {
			playerimage = ImageIO.read(new File("Player.jpg"));
			mhoimage = ImageIO.read(new File("Mho.jpg"));
			fenceimage = ImageIO.read(new File("Fence.jpg"));
		} catch (IOException e) {
		}
		addKeyListener(this);
	}
	
	/**
	 * draws the game
	 * @param g the graphics window
	 * @return none
	 */
	public void paint(Graphics g) {
		if (count == 0) {
			grid(g);
			player(point(player.getpointx()), point(player.getpointy()), g);
			mhos(g);
			border(g);
			fences(g);
			count = count + 1;
		}
		if (player.getgame() == true) {
			//if the player moves up and left
			if (upandleft == true) {
				upandleft = false;
				player.move(player.getpointx() - 1, player.getpointy() - 1);
				player(point(player.getpointx()), point(player.getpointy()), g);
				move(g);
				count = count + 1;
			}
			//if the player moves up
			if (up == true) {
				up = false;
				player.move(player.getpointx(), player.getpointy() - 1);
				player(point(player.getpointx()), point(player.getpointy()), g);
				move(g);
				count = count + 1;
			}
			//if the player moves up and right
			if (upandright == true) {
				upandright = false;
				player.move(player.getpointx() + 1, player.getpointy() - 1);
				player(point(player.getpointx()), point(player.getpointy()), g);
				move(g);
				count = count + 1;
			}
			//if the player moves left
			if (left == true) {
				left = false;
				player.move(player.getpointx() - 1, player.getpointy());
				player(point(player.getpointx()), point(player.getpointy()), g);
				move(g);
				count = count + 1;
			}
			//if the player stays on the same square
			if (sit == true) {
				sit = false;
				player.move(player.getpointx(), player.getpointy());
				player(point(player.getpointx()), point(player.getpointy()), g);
				move(g);
				count = count + 1;
			}
			//if the player moves right
			if (right == true) {
				right = false;
				player.move(player.getpointx() + 1, player.getpointy());
				player(point(player.getpointx()), point(player.getpointy()), g);
				move(g);
				count = count + 1;
			}
			//if the player moves down and left
			if (downandleft == true) {
				downandleft = false;
				player.move(player.getpointx() - 1, player.getpointy() + 1);
				player(point(player.getpointx()), point(player.getpointy()), g);
				move(g);
				count = count + 1;
			}
			//if the player moves down
			if (down == true) {
				down = false;
				player.move(player.getpointx(), player.getpointy() + 1);
				player(point(player.getpointx()), point(player.getpointy()), g);
				move(g);
				count = count + 1;
			}
			//if the player moves down and right
			if (downandright == true) {
				downandright = false;
				player.move(player.getpointx() + 1, player.getpointy() + 1);
				player(point(player.getpointx()), point(player.getpointy()), g);
				move(g);
				count = count + 1;
			}
			//if the player jumps
			if (jump == true) {
				jump = false;
				player.jump();
				player(point(player.getpointx()), point(player.getpointy()), g);
				move(g);
				count = count + 1;
			}
		}
		if (player.getgame() == false) {
			g.setColor(Color.BLACK);
			g.drawString("You Lost", 275, 300);
		}
		if (mhos.size() == 0) {
			g.setColor(Color.BLACK);
			g.drawString("You Won", 275, 300);
		}
	}
	
	/**
	 * draws the grid
	 * @param g the graphics window
	 * @return none
	 */
	public void grid(Graphics g) {
		for (int i = 50; i < 600; i = i + 50) {
			g.setColor(Color.BLACK);
			g.drawLine(0, i, 600, i);
			g.setColor(Color.BLACK);
			g.drawLine(i, 0, i, 600);
		}
	}
	
	/**
	 * draws the player
	 * @param pointx the x coordinate of the player
	 * @param pointy the y coordinate of the player
	 * @param g the graphics window
	 * @return none
	 */
	public void player(int pointx, int pointy, Graphics g) {
		g.drawImage(playerimage, pointx + 5, pointy + 5, 40, 40, null);
	}
	
	/**
	 * draws one mho
	 * @param g the graphics window
	 * @return none
	 */
	public void mho(Graphics g) {
		mhos.add(new Mho());
		g.drawImage(mhoimage, point(mhos.get(mhos.size() - 1).getpointx()) + 5, point(mhos.get(mhos.size() - 1).getpointy()) + 5, 40, 40, null);
	}
	
	/**
	 * draws one mho
	 * @param pointx the x coordinate of the mho
	 * @param pointy the y coordinate of the mho
	 * @param g the graphics window
	 */
	public void mho(int pointx, int pointy, Graphics g) {
		g.drawImage(mhoimage, pointx + 5, pointy + 5, 40, 40, null);
	}
	
	/**
	 * draws twelve mhos
	 * @param g the graphics window
	 * @return none
	 */
	public void mhos(Graphics g) {
		for (int i = 0; i < 12; i++) {
			mho(g);
		}
	}
	
	/**
	 * draws the border fences
	 * @param g the graphics window
	 * @return none
	 */
	public void border(Graphics g) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				if (((i == 0) || (j == 0)) || ((i == 11) || (j == 11))) {
					border.add(new Fence(i, j));
					g.drawImage(fenceimage, point(i) + 5, point(j) + 5, 40, 40, null);
				}
			}
		}
	}
	
	/**
	 * draws one fence
	 * @param g the graphics window
	 * @return none
	 */
	public void fence(Graphics g) {
		fences.add(new Fence());
		g.drawImage(fenceimage, point(fences.get(fences.size() - 1).getpointx()) + 5, point(fences.get(fences.size() - 1).getpointy()) + 5, 40, 40, null);
	}
	
	/**
	 * draws one fence
	 * @param pointx the x coordinate of the fence
	 * @param pointy the y coordinate of the fence
	 * @param g the graphics window
	 */
	public void fence(int pointx, int pointy, Graphics g) {
		g.drawImage(fenceimage, pointx + 5, pointy + 5, 40, 40, null);
	}
	
	/**
	 * draws twenty fences
	 * @param g the graphics window
	 * @return none
	 */
	public void fences(Graphics g) {
		for (int i = 0; i < 20; i++) {
			fence(g);
		}
	}
	
	/**
	 * calculates the coordinates of the player, the mhos, and the fences
	 * @param index the index of the player, the mhos, and the fences in the array "grid"
	 * @return the coordinate of the player, the mhos, and the fences on the graphics window
	 */
	public int point(int index) {
		int point = index * 50;
		return point;
	}
	
	/**
	 * moves the player and the mhos
	 * @param g the graphics window
	 * @return none
	 */
	public void move(Graphics g) {
		grid(g);
		Mho.move();
		for (int i = 0; i < mhos.size(); i++) {
			g.drawImage(mhoimage, point(mhos.get(i).getpointx()) + 5, point(mhos.get(i).getpointy()) + 5, 40, 40, null);
		}
		border(g);
		for (int i = 0; i < fences.size(); i++) {
			g.drawImage(fenceimage, point(fences.get(i).getpointx()) + 5, point(fences.get(i).getpointy()) + 5, 40, 40, null);
		}
		player(point(player.getpointx()), point(player.getpointy()), g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String key = KeyStroke.getKeyStrokeForEvent(e).toString();
		key = key.replace("pressed ", "");
		switch (key) {
			//up and left
			case "Q": upandleft = true;
			break;
			//up
			case "W": up = true;
			break;
			//up and right
			case "E": upandright = true;
			break;
			//left
			case "A": left = true;
			break;
			//sit
			case "S": sit = true;
			break;
			//right
			case "D": right = true;
			break;
			//down and left
			case "Z": downandleft = true;
			break;
			//down
			case "X": down = true;
			break;
			//down and right
			case "C": downandright = true;
			break;
			//jump
			case "J": jump = true;
			break;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
