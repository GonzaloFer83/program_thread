package _02_primo;

public class EmailGenerator implements Runnable {

	private Buffer buffer;
	private int nEmails;

	public EmailGenerator(Buffer buffer, int howEmailGenerate) {
		this.buffer = buffer;
		this.nEmails = howEmailGenerate;
	}

	public void run() {
		for (int i = 0; i < nEmails; i++) {
			Email email = new Email();
			System.out.println(String.format(
				"Hilo %s y el id del mail es el %s",
				Thread.currentThread().getName(),
				email.getId())
			);
			buffer.insertEmail(email);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
