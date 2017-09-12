package com.bayviewglen.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchAndDucking {

	public static void main(String[] args) throws FileNotFoundException {
		tryCatchMethod();
		// duckingMethod(); // it was thrown and now we ducked and Eclipse went down
		// like a shot when the
		// exception hit it in the face
		try {
			throwingAnExceptionWithPerfectMechanics();
		} catch (BestExceptionEver ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
		}
	}

	private static void throwingAnExceptionWithPerfectMechanics() throws BestExceptionEver {
		throw new BestExceptionEver();
	}

	private static void duckingMethod() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("data/words.dat"));
	}

	private static void tryCatchMethod() {
		try {
			Scanner scanner = new Scanner(new File("data/words.dat"));
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} finally {
			System.out.println("Finally");
		}
	}

}
