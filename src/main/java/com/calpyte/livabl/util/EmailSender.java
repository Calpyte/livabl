package com.calpyte.livabl.util;

import com.calpyte.livabl.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.core.Configuration;
import java.io.IOException;
import java.util.Map;

public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    Configuration fmConfiguration;

    public void sendEmail(Message mail) {
        MimeMessage mimeMessage =javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setFrom(mail.getFromId());
            mimeMessageHelper.setTo(mail.getToId());
//            mail.setBody(geContentFromTemplate(mail.getBody()));
            mimeMessageHelper.setText(mail.getBody(), true);
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate(Map< String, Object > model)     {
        StringBuffer content = new StringBuffer();
        try {
//            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(fmConfiguration.getTemplate("email-template.flth"), model));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }


    public void sendEmailWithAttachment(Message mail) throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(mail.getToId());
        helper.setFrom(mail.getFromId());
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getBody());
        // hard coded a file path
        // FileSystemResource file = new FileSystemResource(new    File("path/img.png"));
        // helper.addAttachment("Google Photo",file);
        helper.addAttachment("Google Photo", new ClassPathResource("img.png"));
        javaMailSender.send(msg);
    }
}
