package controllers;

import play.*;
import play.libs.Mail;
import play.mvc.*;

import java.util.*;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import models.*;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void contacts() {
		render();
	}

	public static void soumission() {
		render();
	}

	public static void quotationRequest(String name, String email,
			String phone, String address) throws EmailException {
		SimpleEmail confirEmail = new SimpleEmail();
		confirEmail.setFrom("info@innovationshb.com");
		confirEmail.addTo(email);
		confirEmail.setSubject("Confirmation demande  de soumission");
		confirEmail
				.setMsg("Votre demande a bien été reçu. \nNotre équipe vous contactera dans les plus bref délais. \n\nL'équpe InnovationsHB \ninfo@innovationshb.com");
		Mail.send(confirEmail);

		SimpleEmail simpleEmail = new SimpleEmail();
		simpleEmail.setFrom("info@innovationshb.com");
		simpleEmail.addTo("m.bellemare@innovationshb.com");
		simpleEmail.addTo("f.bellemare@innovationshb.com");
		
		simpleEmail.setSubject("Demande  de soumission");
		simpleEmail
				.setMsg("Une demande de soumission a été fait par : \nNom: "
						+ name + "\nCourriel: " + email + "\nTéléphone: "
						+ phone + "\nAdresse :" + address);
		Mail.send(simpleEmail);

		redirect("/");
	}

}