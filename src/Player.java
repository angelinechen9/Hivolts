
import java.util.ArrayList;

public class Player {
	private int pointx;
	private int pointy;
	private boolean game = true;
	
	public Player() {
		pointx = (int) ((Math.random() * 10) + 1);
		pointy = (int) ((Math.random() * 10) + 1);
	}
	
	/**
	 * gets the x coordinate of the player
	 * @param none
	 * @return the x coordinate of the player
	 */
	public int getpointx() {
		return pointx;
	}
	
	/**
	 * sets the x coordinate of the player
	 * @param pointx the x coordinate of the player
	 * @return none
	 */
	public void setpointx(int pointx) {
		this.pointx = pointx;
	}
	
	/**
	 * gets the y coordinate of the player
	 * @param none
	 * @return the y coordinate of the player
	 */
	public int getpointy() {
		return pointy;
	}
	
	/**
	 * sets the y coordinate of the player
	 * @param pointy the y coordinate of the player
	 * @return none
	 */
	public void setpointy(int pointy) {
		this.pointy = pointy;
	}
	
	public boolean getgame() {
		return game;
	}
	
	public void setgame(boolean game) {
		this.game = game;
	}
	
	public void move(int pointx, int pointy) {
		setpointx(pointx);
		setpointy(pointy);
		//if the coordinates of the player are the same as the coordinates of the mhos
		for (int i = 0; i < Hivolts.mhos.size(); i++) {
			if ((pointx == Hivolts.mhos.get(i).getpointx()) && (pointy == Hivolts.mhos.get(i).getpointy())) {
				game = false;
			}
		}
		//if the coordinates of the player are the same as the coordinates of the border fences
		for (int i = 0; i < Hivolts.border.size(); i++) {
			if ((pointx == Hivolts.border.get(i).getpointx()) && (pointy == Hivolts.border.get(i).getpointy())) {
				game = false;
			}
		}
		//if the coordinates of the player are the same as the coordinates of the fences
		for (int i = 0; i < Hivolts.fences.size(); i++) {
			if ((pointx == Hivolts.fences.get(i).getpointx()) && (pointy == Hivolts.fences.get(i).getpointy())) {
				game = false;
			}
		}
	}
	
	public void jump() {
		setpointx((int) ((Math.random() * 10) + 1));
		setpointy((int) ((Math.random() * 10) + 1));
		boolean array = true;
		//if the coordinates of the player are the same as the coordinates of the fences
		for (int i = 0; i < Hivolts.fences.size(); i++) {
			if ((pointx == Hivolts.fences.get(i).getpointx()) && (pointy == Hivolts.fences.get(i).getpointy())) {
				array = false;
			}
		}
		while (array == false) {
			setpointx((int) ((Math.random() * 10) + 1));
			setpointy((int) ((Math.random() * 10) + 1));
			array = true;
			//if the coordinates of the player are the same as the coordinates of the fences
			for (int i = 0; i < Hivolts.fences.size(); i++) {
				if ((pointx == Hivolts.fences.get(i).getpointx()) && (pointy == Hivolts.fences.get(i).getpointy())) {
					array = false;
				}
			}
		}
		//if the coordinates of the player are the same as the coordinates of the mhos
		for (int i = 0; i < Hivolts.mhos.size(); i++) {
			if ((pointx == Hivolts.mhos.get(i).getpointx()) && (pointy == Hivolts.mhos.get(i).getpointy())) {
				game = false;
			}
		}
	}
}
