package com.gmail.volkovskiyda;

/**
 * [ 7 ] [ 8 ] [ 9 ]		||		[00] [01] [02]
 * [ 4 ] [ 5 ] [ 6 ]		||		[10] [11] [12]
 * [ 1 ] [ 2 ] [ 3 ]		||		[20] [21] [22]
 */

public class Point {
	public static final int MIN_VALUE_NUMPAD = 1;
	public static final int MAX_VALUE_NUMPAD = 9;

	public static final int NUMPAD_7 = 7;
	public static final int NUMPAD_8 = 8;
	public static final int NUMPAD_9 = 9;
	public static final int NUMPAD_4 = 4;
	public static final int NUMPAD_5 = 5;
	public static final int NUMPAD_6 = 6;
	public static final int NUMPAD_1 = 1;
	public static final int NUMPAD_2 = 2;
	public static final int NUMPAD_3 = 3;

	private int point[] = new int[2];
	private int value;
	private boolean turn;
	private int x = 0, y = 0;

	public Point(int value, boolean turn) {
		this.value = value;
		setPoint(value);
		this.turn = turn;
	}

	public int getValue() {
		return value;
	}

	public int getX() {
		return point[0];
	}

	public int getY() {
		return point[1];
	}

	public boolean getTurn() {
		return turn;
	}

	public void setPoint(int value) {
		if (value < MIN_VALUE_NUMPAD || value > MAX_VALUE_NUMPAD)
			return;
		switch (value) {
			case NUMPAD_7:
				point = new int[]{0, 0};
				break;
			case NUMPAD_8:
				point = new int[]{0, 1};
				break;
			case NUMPAD_9:
				point = new int[]{0, 2};
				break;
			case NUMPAD_4:
				point = new int[]{1, 0};
				break;
			case NUMPAD_5:
				point = new int[]{1, 1};
				break;
			case NUMPAD_6:
				point = new int[]{1, 2};
				break;
			case NUMPAD_1:
				point = new int[]{2, 0};
				break;
			case NUMPAD_2:
				point = new int[]{2, 1};
				break;
			case NUMPAD_3:
				point = new int[]{2, 2};
				break;
			default:
				break;
		}
		return;
	}
}
