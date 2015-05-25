package graphic.camera;

import entity.Entity;
import runner.Game;

public class Camera {
	private float xOffset, yOffset;
	private Game game;

	public Camera(Game game, float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}// End constructor

	public void centerOnEntity(Entity entity) {
		xOffset = entity.getX() - game.getWidth() / 2 + entity.getWidth() / 2;
		yOffset = entity.getY() - game.getHeight() / 2 + entity.getHeight() / 2;
	}// End method centerOnEntity

	public void move(float x, float y) {
		xOffset += x;
		yOffset += y;
	}// End method move

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}// End class Camera
