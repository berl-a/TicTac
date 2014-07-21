package com.gmail.volkovskiyda;

public class Field {
	public static final char DEFAULT_CELL_VALUE = ' ';
	public static final char CELL_VALUE_TIC = 'X';
	public static final char CELL_VALUE_TAC = 'O';
	public static final int DEFAULT_FIELD_SIZE = 3;
	private final int fieldSize;

	private boolean turnTicTac; //tic = false, tac = true;
	private char[][] field;

	public Field(int fieldSize) {
		this.fieldSize = fieldSize;
		field = new char[fieldSize][fieldSize];
	}

	public Field() {
		this(DEFAULT_FIELD_SIZE);
	}

	public boolean getTurnTicTac() {
		return turnTicTac;
	}

	public int getFieldSize() {
		return fieldSize;
	}

	public void erase() {
		for (int i = 0; i < fieldSize; i++) {
			for (int j = 0; j < fieldSize; j++) {
				field[i][j] = DEFAULT_CELL_VALUE;
			}
		}
	}

	public void show() {
		for (int i = 0; i < fieldSize; i++) {
			for (int j = 0; j < fieldSize; j++) {
				System.out.print("[ " + field[i][j] + " ] ");
			}
			System.out.println();
		}
	}

	public boolean setCell(int i, int j) {
		if (isCellEmpty(i, j)) {
			field[i][j] = turnTicTac ? CELL_VALUE_TAC : CELL_VALUE_TIC;
			turnTicTac = !turnTicTac;
			return true;
		}
		return false;
	}

	public boolean setCell(Point cell) {
		int i = cell.getX();
		int j = cell.getY();
		return this.setCell(i,j);
	}

	public boolean isCellEmpty(int i, int j) {
		if (field[i][j] == DEFAULT_CELL_VALUE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isWinnerTic() {
		int count = 0;
		for (int i = 0; i < fieldSize; i++) {
			count = 0;
			for (int j = 0; j < fieldSize; j++)
				if (field[i][j] == Field.CELL_VALUE_TIC)
					count++;
			if (count == fieldSize)
				return true;
		}

		for (int i = 0; i < fieldSize; i++) {
			count = 0;
			for (int j = 0; j < fieldSize; j++)
				if (field[j][i] == Field.CELL_VALUE_TIC)
					count++;
			if (count == fieldSize)
				return true;
		}

		count = 0;
		for (int i = 0; i < fieldSize; i++)
			if (field[i][i] == Field.CELL_VALUE_TIC)
				count++;
		if (count == fieldSize)
			return true;

		count = 0;
		for (int i = 0; i < fieldSize; i++)
			if (field[i][fieldSize - i - 1] == Field.CELL_VALUE_TIC)
				count++;
		if (count == fieldSize)
			return true;

		return false;
	}

	public boolean isWinnerTac() {
		int count = 0;
		for (int i = 0; i < fieldSize; i++) {
			count = 0;
			for (int j = 0; j < fieldSize; j++)
				if (field[i][j] == Field.CELL_VALUE_TAC)
					count++;
			if (count == fieldSize)
				return true;
		}

		for (int i = 0; i < fieldSize; i++) {
			count = 0;
			for (int j = 0; j < fieldSize; j++)
				if (field[j][i] == Field.CELL_VALUE_TAC)
					count++;
			if (count == fieldSize)
				return true;
		}

		count = 0;
		for (int i = 0; i < fieldSize; i++)
			if (field[i][i] == Field.CELL_VALUE_TAC)
				count++;
		if (count == fieldSize)
			return true;

		count = 0;
		for (int i = 0; i < fieldSize; i++)
			if (field[i][fieldSize - i - 1] == Field.CELL_VALUE_TAC)
				count++;
		if (count == fieldSize)
			return true;

		return false;
	}


}
