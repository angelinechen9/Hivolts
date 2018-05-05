
public class Fence {
	private int pointx;
	private int pointy;
	
	public Fence() {
		pointx = (int) ((Math.random() * 10) + 1);
		pointy = (int) ((Math.random() * 10) + 1);
		boolean array = true;
		//if the coordinates of the fence are the same as the coordinates of the player
		if ((pointx == Hivolts.player.getpointx()) && (pointy == Hivolts.player.getpointy())) {
			array = false;
		}
		//if the coordinates of the fence are the same as the coordinates of the mhos
		for (int i = 0; i < Hivolts.mhos.size(); i++) {
			if ((pointx == Hivolts.mhos.get(i).getpointx()) && (pointy == Hivolts.mhos.get(i).getpointy())) {
				array = false;
			}
		}
		//if the coordinates of the fence are the same as the coordinates of other fences
		for (int i = 0; i < Hivolts.fences.size(); i++) {
			if ((pointx == Hivolts.fences.get(i).getpointx()) && (pointy == Hivolts.fences.get(i).getpointy())) {
				array = false;
			}
		}
		while (array == false) {
			pointx = (int) ((Math.random() * 10) + 1);
			pointy = (int) ((Math.random() * 10) + 1);
			array = true;
			//if the coordinates of the fence are the same as the coordinates of the player
			if ((pointx == Hivolts.player.getpointx()) && (pointy == Hivolts.player.getpointy())) {
				array = false;
			}
			//if the coordinates of the fence are the same as the coordinates of the mhos
			for (int i = 0; i < Hivolts.mhos.size(); i++) {
				if ((pointx == Hivolts.mhos.get(i).getpointx()) && (pointy == Hivolts.mhos.get(i).getpointy())) {
					array = false;
				}
			}
			//if the coordinates of the fence are the same as the coordinates of other fences
			for (int i = 0; i < Hivolts.fences.size(); i++) {
				if ((pointx == Hivolts.fences.get(i).getpointx()) && (pointy == Hivolts.fences.get(i).getpointy())) {
					array = false;
				}
			}
		}
	}
	
	public Fence(int pointx, int pointy) {
		this.pointx = pointx;
		this.pointy = pointy;
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
}
