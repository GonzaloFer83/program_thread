package _01_primo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
	HashMap<Integer, Boolean> result = new HashMap<Integer, Boolean>();

	public static void main(String[] args) {

		System.out.println("Por favor, introduce 3 numeros para calcular si son primos.");
		introduceNumbers();
		PrimeCalculator primeCalculator = new PrimeCalculator(inputNumbers);
		primeCalculator.startThread();
		System.out.println("Fin del programa");
	}

	public static void introduceNumbers() {
		for (int i = 0; i < 3; i++) {
			try {
				inputNumbers.add(sc.nextInt());

			} catch (InputMismatchException ex) {
				System.out.println("Debe ingresar obligatoriamente números enteros");
			}
		}
	}

}
