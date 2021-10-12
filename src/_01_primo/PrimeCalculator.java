package _01_primo;

import java.util.ArrayList;

public class PrimeCalculator{
	private ArrayList<Integer> numbers;

	public PrimeCalculator(ArrayList<Integer> numbers) {
		this.numbers=numbers;
	}

	@Override
	public String toString() {
		return "CalculatorPrime [list=" + numbers.toString() + "]";
	}

	public void startThread() {
		for(int i=0; i<numbers.size(); i++){
			PrimeChecker primeChecker = new PrimeChecker(numbers.get(i));
			Thread  thread = new Thread(primeChecker);
			thread.setName("Thread"+i);
			thread.start();
		}
	}
	
}
