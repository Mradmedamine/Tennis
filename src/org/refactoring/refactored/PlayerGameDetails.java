package org.refactoring.refactored;

class PlayerGameDetails {

	private Player player;
	private int score;

	public PlayerGameDetails(Player player) {
		super();
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getScore() {
		return score;
	}

	public void wonPoint() {
		this.score++;
	}

}
