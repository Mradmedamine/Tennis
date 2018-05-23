package org.refactoring.refactored;

public class Player {

	private String name;

	public Player() {
	}

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof Player) {
			return ((Player) obj).getName().equals(this.name);
		}
		return false;
	}

}
