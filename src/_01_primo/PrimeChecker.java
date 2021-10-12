package _01_primo;

public class PrimeChecker implements Runnable {
	private int num;
	private boolean prime = (Boolean) null;
	private double time;

	public PrimeChecker(int num) {

		this.num = num;

	}

	@Override
	public void run() {
		long initTime = System.currentTimeMillis();
		long endTime;
		if (comprobation())
			isPrime();
		else
			System.out.println("Este valor no vale");

		endTime = System.currentTimeMillis();
		time = (double) ((endTime - initTime));
		printResult();
	}

	public boolean comprobation() {
		if (num <= 1 || num>Integer.MAX_VALUE) {
			System.out.println("Este valor no vale, tiene que ser superior a 1");
			return false;
		}
		return true;
	}

	public void isPrime() {
		prime = true;
		int accountant = 2;
		while ((prime) && (accountant != num)) {
			if (num % accountant == 0)
				prime = false;
			accountant++;
		}
	}

	public void printResult() {
		System.out.println(String.format("El %s con valor = %d, %s es primo y ha tardado %d milisegundos en calcularlo",
				Thread.currentThread().getName(), num, prime ? "" : "no", time));

	}

}
