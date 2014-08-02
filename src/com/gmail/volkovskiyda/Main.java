package com.gmail.volkovskiyda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Программа сделана для игры крестики-нолики для двух людей на NumPad. Поэтому стоит ограничение на ввод данных:
 * числа от 0 до 9 (как на NumPad).
 */

public class Main {

	public static void main(String[] args) {
		Field field = new Field();
		List<Point> points = new ArrayList<>();

		field.erase();
		field.show();

		boolean noTurn = false;
		while (!noTurn) {
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				boolean userPlacedSmth = false;
				while(!userPlacedSmth){
					System.out.println("place smth");
					int nextInt = sc.nextInt();
					if (nextInt < Point.MIN_VALUE_NUMPAD || nextInt > Point.MAX_VALUE_NUMPAD || !isCellFree(nextInt))//Нет свободного места {
						//noTurn = true;
						//break;
						continue;
					}else if(ifCellFree(nextInt)){
						placeUsersZnak(nextInt);	
					}
				}
				 Point p = new Point(nextInt, field.getTurnTicTac());
				 if (field.setCell(p)) {
				 	points.add(p);
				 	field.show();
				 }
			}
			noTurn = (field.isWinnerTac() || field.isWinnerTic() ||
					points.size() == field.getFieldSize() * field.getFieldSize());
		}

		if (noTurn) {
			System.out.println();
			if (field.isWinnerTac())
				System.out.println("Winner is O");
			if (field.isWinnerTic())
				System.out.println("Winner is X");
			if (!field.isWinnerTic() && !field.isWinnerTac())
				System.out.println("No Winner");
		}

		for (int i = 0; i < points.size(); i++) {
			System.out.println("Point #" + (i + 1) + ": " + points.get(i).getValue() + " " +
					(points.get(i).getTurn() ? "O" : "X"));
		}
		System.out.println();
		field.show();
	}
}
