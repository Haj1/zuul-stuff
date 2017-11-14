package com.haj.zuulbars;

public class Bar {
	private int barId;
	private int powerValue;

	public Bar(int barId, int powerValue) {
		this.barId = barId;
		this.powerValue = powerValue;
	}

	public int getBarId() {
		return barId;
	}

	public void setBarId(int barId) {
		this.barId = barId;
	}

	public int getPowerValue() {
		return powerValue;
	}

	public void setPowerValue(int powerValue) {
		this.powerValue = powerValue;
	}
}
