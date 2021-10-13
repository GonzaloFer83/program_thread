package _02_buffer;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

import Exceptions.EmailException;

public class Buffer {

	private Queue<Email> emailBuffer = new LinkedList<Email>();
	private ArrayList<String> wrongEmails = new ArrayList<String>();
	private int bufferSize = 5;

	public Buffer(ArrayList<String> wrongEmails, int bufferSize) {

		this.wrongEmails = wrongEmails;
		this.bufferSize = bufferSize;
	}

	public synchronized void insertEmail(Email email) {
		while (emailBuffer.size() == bufferSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				;
			}
		}
		try {
			validateEmail(email);
			emailBuffer.add(email);
			notify();
		} catch (EmailException error) {
			System.out.println(error.getMessage());

		}

	}

	public synchronized Email getEmail() {
		Email email;
		while (emailBuffer.size() == 0) {

			try {
				wait();
			} catch (InterruptedException e) {

			}

		}
		email = emailBuffer.poll();
		notify();
		return email;
	}

	public void validateEmail(Email email) throws EmailException {

		if (wrongEmails.contains(email.getRecipient())) {
			throw new EmailException(
					"Detectado correo erroneo con el id " + email.getId());
		}

	}

}
