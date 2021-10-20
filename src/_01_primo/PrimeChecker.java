package _01_primo;

public class PrimeChecker implements Runnable {
	private int posiblePrime;
	private boolean prime ;
	private double timeControl;

	public PrimeChecker(int posiblePrime) {

		this.posiblePrime = posiblePrime;

	}

	@Override
	public void run() {
		long initTime = System.currentTimeMillis();
		long endTime;
		if (isValidInput())
			isPrime();
		else
			System.out.println("Este valor no vale");

		endTime = System.currentTimeMillis();
		timeControl = (double) ((endTime - initTime));
		printResult();
	}

	public boolean isValidInput() {
		if (posiblePrime <= 1 || posiblePrime > Integer.MAX_VALUE) {
			System.out
					.println("Este valor no vale, tiene que ser superior a 1");
			return false;
		}
		return true;
	}

	public void isPrime() {
		prime = true;
		int accountant = 2;
		while ((prime) && (accountant != posiblePrime)) {
			if (posiblePrime % accountant == 0)
				prime = false;
			accountant++;
		}
	}

	public void printResult() {
		System.out.println(String.format(
				"El %s con valor = %d, %s es primo y ha tardado %f milisegundos en calcularlo",
				Thread.currentThread().getName(), posiblePrime, prime ? "" : "no",
						timeControl));

	}

}
