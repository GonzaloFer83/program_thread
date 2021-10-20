package _02_buffer;

public class EmailSender implements Runnable {

	private Buffer buffer;

	public EmailSender(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		while (true) {
			System.out.println(buffer.getEmail().toString()+" el hilo es "
					+ Thread.currentThread().getName());

		}
	}

}
