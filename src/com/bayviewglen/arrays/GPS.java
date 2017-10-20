package com.bayviewglen.arrays;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GPS {

	public static void main(String[] args) {
		double[][] coord = null;
		try {
			Scanner input = new Scanner(new FileReader("data/locations.dat"));
			coord = new double[Integer.parseInt(input.nextLine())][2];
			String line;
			for (int i = 0; i < coord.length; i++) {
				line = input.nextLine();
				coord[i][0] = Double.parseDouble(line.split(" ")[0]);
				coord[i][1] = Double.parseDouble(line.split(" ")[1]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		double dist = Math.sqrt(Math.pow((coord[1][1]-coord[0][1]),2.0) + Math.pow((coord[1][0]-coord[0][0]),2));		
		double newDist;
		double lowestX1 = 0.0;
		double lowestY1 = 0.0;
		double lowestX2 = 0.0;
		double lowestY2 = 0.0;
		
		for (int i = 0; i < coord.length; i++) {
			for (int j = 0; j < coord.length; j++) {
				newDist = Math.sqrt(Math.pow((coord[j][1]-coord[i][1]),2.0) + Math.pow((coord[j][0]-coord[i][0]),2));
				if (newDist < dist && (coord[j][1] != coord[i][1] || coord[i][0] != coord[i][0])) {
					dist = newDist;
					lowestX1 = coord[i][0];
					lowestY1 = coord[i][1];
					lowestX2 = coord[j][0];
					lowestY2 = coord[j][1];
				}
			}
		}
		System.out.println("The closest two points are: (" + lowestX1 + ", " + lowestY1 + ") and (" + lowestX2 + ", " + lowestY2 + ").");
	}
}