package com.onebooming.boecloudservice.common;


import com.onebooming.boecloudservice.bean.VMachine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

/**
 * @author Onebooming
 */
public class EmailRunnable implements Runnable {
    private VMachine vMachine;
    private JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;
    private String emailAddress;

    public EmailRunnable(VMachine vMachine,
                         JavaMailSender javaMailSender,
                         TemplateEngine templateEngine, String emailAddress) {
        this.vMachine = vMachine;
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.emailAddress = emailAddress;
    }
    @Override
    public void run() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(vMachine.getEmail());
            helper.setFrom(emailAddress);
            helper.setSubject("XXX集团：通知");
            Context ctx = new Context();
            ctx.setVariable("name", vMachine.getName());
            ctx.setVariable("IP", vMachine.getIp());
            ctx.setVariable("createDate", vMachine.getCreateDate());
            ctx.setVariable("beFormDate", vMachine.getBeFormDate());
            ctx.setVariable("notWorkDate", vMachine.getNotWorkDate());
            ctx.setVariable("department", vMachine.getDepartment());
            ctx.setVariable("supervisor", vMachine.getSupervisor());
            String mail = templateEngine.process("email.html", ctx);
            helper.setText(mail, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("发送失败");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }
}
