package com.example.e_learning;

import java.io.File;

import com.example.e_learning.MailInfo;
import com.example.e_learning.MailSender;

import java.io.File;

public class SendMailUtil {

    private static final String HOST = "smtp.163.com";
    private static final String PORT = "25";
    private static final String FROM_ADD = "cl990321@163.com";
    private static final String FROM_PSW = "ckw990321";

    public static void send(String toAdd,String randomNum){
        final MailInfo mailInfo = creatMail(toAdd,randomNum);
        final MailSender sms = new MailSender();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sms.sendTextMail(mailInfo);
            }
        }).start();
    }

    private static MailInfo creatMail(String toAdd,String randomNum) {
        final MailInfo mailInfo = new MailInfo();
        mailInfo.setMailServerHost(HOST);
        mailInfo.setMailServerPort(PORT);
        mailInfo.setValidate(true);
        mailInfo.setUserName(FROM_ADD);
        mailInfo.setPassword(FROM_PSW);
        mailInfo.setFromAddress(FROM_ADD);
        mailInfo.setToAddress(toAdd);
        mailInfo.setSubject("\"Elearning\"系统验证邮件");
        mailInfo.setContent("感谢您使用Elearning App，\n您的验证码是:" + randomNum);
        return mailInfo;
    }

}