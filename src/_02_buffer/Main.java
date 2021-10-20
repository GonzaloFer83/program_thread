package _02_buffer;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int nEmails = 10;
		int bufferSize = 5;
		ArrayList<String> wrongEmails = new ArrayList<String>();
		wrongEmails.add("pikachu@gmail.com");

		Buffer buffer = new Buffer(wrongEmails, bufferSize);
		EmailGenerator t1 = new EmailGenerator(buffer, nEmails);
		Thread thread1 = new Thread(t1);
		thread1.setName("Thread_Mail_Generator_1");
		EmailGenerator t2 = new EmailGenerator(buffer, nEmails);
		Thread thread2 = new Thread(t2);
		thread2.setName("Thread_Mail_Generator_2");
		EmailGenerator t3 = new EmailGenerator(buffer, nEmails);
		Thread thread3 = new Thread(t3);
		thread3.setName("Thread_Mail_Generator_3");
		EmailSender t4 = new EmailSender(buffer);
		Thread thread4 = new Thread(t4);
		thread4.setName("Thread_Send_Email_1");
		EmailSender t5 = new EmailSender(buffer);
		Thread thread5 = new Thread(t5);
		thread4.setName("Thread_Send_Email_2");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}

}
