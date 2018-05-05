
import java.util.ArrayList;

public class Mho {
	private int pointx;
	private int pointy;
	
	public Mho() {
		pointx = (int) ((Math.random() * 10) + 1);
		pointy = (int) ((Math.random() * 10) + 1);
		boolean array = true;
		//if the coordinates of the mho are the same as the coordinates of the player
		if ((pointx == Hivolts.player.getpointx()) && (pointy == Hivolts.player.getpointy())) {
			array = false;
		}
		//if the coordinates of the mho are the same as the coordinates of other mhos
		for (int i = 0; i < Hivolts.mhos.size(); i++) {
			if ((pointx == Hivolts.mhos.get(i).getpointx()) && (pointy == Hivolts.mhos.get(i).getpointy())) {
				array = false;
			}
		}
		while (array == false) {
			pointx = (int) ((Math.random() * 10) + 1);
			pointy = (int) ((Math.random() * 10) + 1);
			array = true;
			//if the coordinates of the mho are the same as the coordinates of the player
			if ((pointx == Hivolts.player.getpointx()) && (pointy == Hivolts.player.getpointy())) {
				array = false;
			}
			//if the coordinates of the mho are the same as the coordinates of other mhos
			for (int i = 0; i < Hivolts.mhos.size(); i++) {
				if ((pointx == Hivolts.mhos.get(i).getpointx()) && (pointy == Hivolts.mhos.get(i).getpointy())) {
					array = false;
				}
			}
		}
	}
	
	/**
	 * gets the x coordinate of the mho
	 * @param none
	 * @return the x coordinate of the mho
	 */
	public int getpointx() {
		return pointx;
	}
	
	/**
	 * sets the x coordinate of the mho
	 * @param pointx the x coordinate of the mho
	 * @return none
	 */
	public void setpointx(int pointx) {
		this.pointx = pointx;
	}
	
	/**
	 * gets the y coordinate of the mho
	 * @param none
	 * @return the y coordinate of the mho
	 */
	public int getpointy() {
		return pointy;
	}
	
	/**
	 * sets the y coordinate of the mho
	 * @param pointy the y coordinate of the mho
	 * @return none
	 */
	public void setpointy(int pointy) {
		this.pointy = pointy;
	}
	
	public static void move() {
		for (int i = 0; i < Hivolts.mhos.size(); i++) {
			//if the mho is directly horizontal or directly vertical to the player
			if ((Hivolts.mhos.get(i).getpointx() == Hivolts.player.getpointx()) || (Hivolts.mhos.get(i).getpointy() == Hivolts.player.getpointy())) {
				//if the mho is directly horizontal to the player
				if (Hivolts.mhos.get(i).getpointx() == Hivolts.player.getpointx()) {
					//if the y coordinate of the mho is less than the y coordinate of the player
					if (Hivolts.mhos.get(i).getpointy() < Hivolts.player.getpointy()) {
						Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() + 1);
					}
					//if the y coordinate of the mho is greater than the y coordinate of the player
					else if (Hivolts.mhos.get(i).getpointy() > Hivolts.player.getpointy()) {
						Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() - 1);
					}
				}
				//if the mho is directly vertical to the player
				else if (Hivolts.mhos.get(i).getpointy() == Hivolts.player.getpointy()) {
					//if the x coordinate of the mho is less than the x coordinate of the player
					if (Hivolts.mhos.get(i).getpointx() < Hivolts.player.getpointx()) {
						Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() + 1);
					}
					//if the x coordinate of the mho is greater than the x coordinate of the player
					else if (Hivolts.mhos.get(i).getpointx() > Hivolts.player.getpointx()) {
						Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() - 1);
					}
				}
				mhohitfence(i);
			}
			//if the mho is not directly horizontal or directly vertical to the player
			else if ((Hivolts.mhos.get(i).getpointx() != Hivolts.player.getpointx()) && (Hivolts.mhos.get(i).getpointy() != Hivolts.player.getpointy())) {
				//if there are no fences diagonal to the mho
				//if the x coordinate of the mho is less than the x coordinate of the player
				if (Hivolts.mhos.get(i).getpointx() < Hivolts.player.getpointx()) {
					//if the y coordinate of the mho is less than the y coordinate of the player
					if (Hivolts.mhos.get(i).getpointy() < Hivolts.player.getpointy()) {
						if (emptysquare1(Hivolts.mhos.get(i).getpointx() + 1, Hivolts.mhos.get(i).getpointy() + 1) == true) {
							Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() + 1);
							Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() + 1);
							continue;
						}
					}
					//if the y coordinate of the mho is greater than the y coordinate of the player
					else if (Hivolts.mhos.get(i).getpointy() > Hivolts.player.getpointy()) {
						if (emptysquare1(Hivolts.mhos.get(i).getpointx() + 1, Hivolts.mhos.get(i).getpointy() - 1) == true) {
							Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() + 1);
							Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() - 1);
							continue;
						}
					}
				}
				//if the x coordinate of the mho is greater than the x coordinate of the player
				else if (Hivolts.mhos.get(i).getpointx() > Hivolts.player.getpointx()) {
					//if the y coordinate of the mho is less than the y coordinate of the player
					if (Hivolts.mhos.get(i).getpointy() < Hivolts.player.getpointy()) {
						if (emptysquare1(Hivolts.mhos.get(i).getpointx() - 1, Hivolts.mhos.get(i).getpointy() + 1) == true) {
							Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() - 1);
							Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() + 1);
							continue;
						}
					}
					//if the y coordinate of the mho is greater than the y coordinate of the player
					else if (Hivolts.mhos.get(i).getpointy() > Hivolts.player.getpointy()) {
						if (emptysquare1(Hivolts.mhos.get(i).getpointx() - 1, Hivolts.mhos.get(i).getpointy() - 1) == true) {
							Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() - 1);
							Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() - 1);
							continue;
						}
					}
				}
				//if there are no fences horizontal or vertical to the mho
				//if the horizontal distance between the mho and the player is less than or equal to the horizontal distance between the mho and the player
				if (Math.abs(Hivolts.player.getpointx() - Hivolts.mhos.get(i).getpointx()) <= Math.abs(Hivolts.player.getpointy() - Hivolts.mhos.get(i).getpointy())) {
					//if the y coordinate of the mho is less than the y coordinate of the player
					if (Hivolts.mhos.get(i).getpointy() < Hivolts.player.getpointy()) {
						if (emptysquare1(Hivolts.mhos.get(i).getpointx(), Hivolts.mhos.get(i).getpointy() + 1)) {
							Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() + 1);
							continue;
						}
					}
					//if the y coordinate of the mho is greater than the y coordinate of the player
					else if (Hivolts.mhos.get(i).getpointy() > Hivolts.player.getpointy()) {
						if (emptysquare1(Hivolts.mhos.get(i).getpointx(), Hivolts.mhos.get(i).getpointy() - 1)) {
							Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() - 1);
							continue;
						}
					}
				}
				//if the horizontal distance between the mho and the player is greater than or equal to the vertical distance between the mho and the player
				else if (Math.abs(Hivolts.player.getpointx() - Hivolts.mhos.get(i).getpointx()) >= Math.abs(Hivolts.player.getpointy() - Hivolts.mhos.get(i).getpointy())) {
					//if the x coordinate of the mho is less than the x coordinate of the player
					if (Hivolts.mhos.get(i).getpointx() < Hivolts.player.getpointx()) {
						if (emptysquare1(Hivolts.mhos.get(i).getpointx() + 1, Hivolts.mhos.get(i).getpointy())) {
							Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() + 1);
							continue;
						}
					}
					//if the x coordinate of the mho is greater than the x coordinate of the player
					else if (Hivolts.mhos.get(i).getpointx() > Hivolts.player.getpointx()) {
						if (emptysquare1(Hivolts.mhos.get(i).getpointx() - 1, Hivolts.mhos.get(i).getpointy())) {
							Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() - 1);
							continue;
						}
					}
				}
				//if there are fences diagonal, horizontal, or vertical to the mho
				else {
					//if there are no fences diagonal to the mho
					//if the x coordinate of the mho is less than the x coordinate of the player
					if (Hivolts.mhos.get(i).getpointx() < Hivolts.player.getpointx()) {
						//if the y coordinate of the mho is less than the y coordinate of the player
						if (Hivolts.mhos.get(i).getpointy() < Hivolts.player.getpointy()) {
							if (emptysquare2(Hivolts.mhos.get(i).getpointx() + 1, Hivolts.mhos.get(i).getpointy() + 1) == true) {
								Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() + 1);
								Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() + 1);
							}
						}
						//if the y coordinate of the mho is greater than the y coordinate of the player
						else if (Hivolts.mhos.get(i).getpointy() > Hivolts.player.getpointy()) {
							if (emptysquare2(Hivolts.mhos.get(i).getpointx() + 1, Hivolts.mhos.get(i).getpointy() - 1) == true) {
								Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() + 1);
								Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() - 1);
							}
						}
					}
					//if the x coordinate of the mho is greater than the x coordinate of the player
					else if (Hivolts.mhos.get(i).getpointx() > Hivolts.player.getpointx()) {
						//if the y coordinate of the mho is less than the y coordinate of the player
						if (Hivolts.mhos.get(i).getpointy() < Hivolts.player.getpointy()) {
							if (emptysquare2(Hivolts.mhos.get(i).getpointx() - 1, Hivolts.mhos.get(i).getpointy() + 1) == true) {
								Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() - 1);
								Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() + 1);
							}
						}
						//if the y coordinate of the mho is greater than the y coordinate of the player
						else if (Hivolts.mhos.get(i).getpointy() > Hivolts.player.getpointy()) {
							if (emptysquare2(Hivolts.mhos.get(i).getpointx() - 1, Hivolts.mhos.get(i).getpointy() - 1) == true) {
								Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() - 1);
								Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() - 1);
							}
						}
					}
					mhohitfence(i);
					//if there are no fences horizontal or vertical to the mho
					//if the horizontal distance between the mho and the player is less than or equal to the horizontal distance between the mho and the player
					if (Math.abs(Hivolts.player.getpointx() - Hivolts.mhos.get(i).getpointx()) <= Math.abs(Hivolts.player.getpointy() - Hivolts.mhos.get(i).getpointy())) {
						//if the y coordinate of the mho is less than the y coordinate of the player
						if (Hivolts.mhos.get(i).getpointy() < Hivolts.player.getpointy()) {
							if (emptysquare2(Hivolts.mhos.get(i).getpointx(), Hivolts.mhos.get(i).getpointy() + 1)) {
								Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() + 1);
							}
						}
						//if the y coordinate of the mho is greater than the y coordinate of the player
						else if (Hivolts.mhos.get(i).getpointy() > Hivolts.player.getpointy()) {
							if (emptysquare2(Hivolts.mhos.get(i).getpointx(), Hivolts.mhos.get(i).getpointy() - 1)) {
								Hivolts.mhos.get(i).setpointy(Hivolts.mhos.get(i).getpointy() - 1);
							}
						}
						mhohitfence(i);
					}
					//if the horizontal distance between the mho and the player is greater than or equal to the vertical distance between the mho and the player
					else if (Math.abs(Hivolts.player.getpointx() - Hivolts.mhos.get(i).getpointx()) >= Math.abs(Hivolts.player.getpointy() - Hivolts.mhos.get(i).getpointy())) {
						//if the x coordinate of the mho is less than the x coordinate of the player
						if (Hivolts.mhos.get(i).getpointx() < Hivolts.player.getpointx()) {
							if (emptysquare2(Hivolts.mhos.get(i).getpointx() + 1, Hivolts.mhos.get(i).getpointy())) {
								Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() + 1);
							}
						}
						//if the x coordinate of the mho is greater than the x coordinate of the player
						else if (Hivolts.mhos.get(i).getpointx() > Hivolts.player.getpointx()) {
							if (emptysquare2(Hivolts.mhos.get(i).getpointx() - 1, Hivolts.mhos.get(i).getpointy())) {
								Hivolts.mhos.get(i).setpointx(Hivolts.mhos.get(i).getpointx() - 1);
							}
						}
						mhohitfence(i);
					}	
				}
			}
		}
		for (int i = Hivolts.indexes.size() - 1; i >= 0; i--) {
			Hivolts.mhos.remove(Hivolts.indexes.get(i).intValue());
		}
		Hivolts.indexes.clear();
	}
	
	/**
	 * checks if the mho is on the same square as the player, other mhos, and the fences
	 * @param pointx the x coordinate of the mho
	 * @param pointy the y coordinate of the mho
	 * @return
	 */
	public static boolean emptysquare1(int pointx, int pointy) {
		//if the coordinates of the mho are the same as the coordinates of the player
		if ((pointx == Hivolts.player.getpointx()) && (pointy == Hivolts.player.getpointy())) {
			return false;
		}
		//if the coordinates of the mho are the same as the coordinates of other mhos
		for (int i = 0; i < Hivolts.mhos.size(); i++) {
			if ((pointx == Hivolts.mhos.get(i).getpointx()) && (pointy == Hivolts.mhos.get(i).getpointy())) {
				return false;
			}
		}
		//if the coordinates of the mho are the same as the coordinates of the fences
		for (int i = 0; i < Hivolts.fences.size(); i++) {
			if ((pointx == Hivolts.fences.get(i).getpointx()) && (pointy == Hivolts.fences.get(i).getpointy())) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * checks if the mho is on the same square as the player and other mhos
	 * @param pointx the x coordinate of the mho
	 * @param pointy the y coordinate of the mho
	 * @return
	 */
	public static boolean emptysquare2(int pointx, int pointy) {
		//if the coordinates of the mho are the same as the coordinates of the player
		if ((pointx == Hivolts.player.getpointx()) && (pointy == Hivolts.player.getpointy())) {
			return false;
		}
		//if the coordinates of the mho are the same as the coordinates of other mhos
		for (int i = 0; i < Hivolts.mhos.size(); i++) {
			if ((pointx == Hivolts.mhos.get(i).getpointx()) && (pointy == Hivolts.mhos.get(i).getpointy())) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * checks if the mho is on the same square as the fences
	 * @param i
	 */
	public static void mhohitfence(int i) {
		//if the coordinates of the mho are the same as the coordinates of the fence
		for (int j = 0; j < Hivolts.fences.size(); j++) {
			if ((Hivolts.mhos.get(i).getpointx() == Hivolts.fences.get(j).getpointx()) && (Hivolts.mhos.get(i).getpointy() == Hivolts.fences.get(j).getpointy())) {
				Hivolts.indexes.add(i);
			}
		}
	}
}
