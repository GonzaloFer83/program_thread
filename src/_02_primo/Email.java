package _02_primo;

import com.github.javafaker.Faker;
import java.lang.Math;
public class Email {
	private String id;
	private String recipient;
	private String sender;
	private String body;
	private String subject;
	private Faker user = new Faker();
	private int randomize;
	

	

	public Email() {
		this.id = user.idNumber().ssnValid();
		randomize=(int) (Math.random()*8)+1;
		if(randomize==1) {
			
			this.recipient = "pikachu@gmail.com";
		}else {
			this.recipient = user.internet().emailAddress();

		}
		this.sender = user.internet().emailAddress();
		this.body = user.lorem().paragraph();
		this.subject = user.lorem().word();
	}
	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "mail [id=" + id + ", destinator=" + recipient + ", addressee="
				+ sender + ", issues=" + subject
				+ ", body=" + body + "]";
	}

}
