package org.epodia.services;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Controller
public class SimpleEmailController {
	
	@Autowired
	private JavaMailSender sender ;
	@Autowired
	private Configuration freemarkerConfig;
	
	@RequestMapping("/simpleemail2")
	@ResponseBody
	String home() {
		try {
			sendEmail();
			return "Email Sent!";
		}catch(Exception ex) {
			return "Error in sending email "+ex;
		}
		
	} 
	
	 private void sendEmail() throws Exception{
		 
		 MimeMessage message = sender.createMimeMessage();
		 MimeMessageHelper helper = new MimeMessageHelper(message);
		 Map<String, Object> model = new HashMap();
		 model.put("user", "qpt");
		 freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");

		 Template t = freemarkerConfig.getTemplate("Nouvel e-mail.html");
		 String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

		 helper.setTo("chatti.louay@gmail.com");
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
