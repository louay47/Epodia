package org.epodia.component;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.epodia.dao.UserRepository;
import org.epodia.entities.User;
import org.epodia.metier.UserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class SendConfirmationEmail {
	
	@Autowired
	private JavaMailSender sender ;
	@Autowired
	private Configuration freemarkerConfig;
	
	
	
 private void sendEmail(User user) throws Exception{
		 
		 MimeMessage message = sender.createMimeMessage();
		 MimeMessageHelper helper = new MimeMessageHelper(message);
		 Map<String, Object> model = new HashMap();
		 model.put("user", "qpt");
		 freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");

		 Template t = freemarkerConfig.getTemplate("Nouvel e-mail.html");
		 String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		 
		

		 helper.setTo(user.getEmail());
		 helper.setText(text, true);
		 helper.setSubject("Epodia");

		 /*ClassPathResource file = new ClassPathResource("hqdefault.jpg");
		 File f = new resource.getFile();
		 File f = new File("hqdefault.jpg");
		 System.out.println(f.getAbsolutePath());
		 System.out.println(f.exists());
		 String absolutePath = f.getAbsolutePath();
		 helper.addAttachment("hqdefault.jpg", file);*/

		 sender.send(message);
		 
	 }

}
