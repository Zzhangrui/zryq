package com.zryq.cms.admin.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/30
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
public class MailService {

    private static final String MAIL_HOST="smtp.aliyun.com";

    private static final String MAIL_ACCOUNT="zzhangruiaq@aliyun.com";

    private static final String MAIL_PASSWORD="rui123456789";


    //定义一个发送邮件的方法,参数是发送方邮件地址，以及发送邮件的信息
    public static void sendMail(String subject ,String email, String emailMsg)
            throws AddressException, MessagingException {
        // 1.创建一个程序与邮件服务器会话对象 Session
        // 获取系统属性
        Properties props = new Properties();
        //设置发送的协议
        props.setProperty("mail.transport.protocol", "SMTP");

        //设置发送邮件的服务器，这里我使用的是163的邮箱

        props.setProperty("mail.host",MAIL_HOST);
        //使用本地邮件服务器设置
        //props.setProperty("mail.host", "localhost");
        props.setProperty("mail.smtp.auth", "true");// 指定验证为true

        // 创建验证器，就是输入自己的邮箱账号和密码
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //设置发送人的帐号和密码，
                return new PasswordAuthentication(MAIL_ACCOUNT, MAIL_PASSWORD);
            }
        };
        //
        Session session = Session.getInstance(props, auth);
        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        //设置发送者，发送中就是用哪个邮件进行发送
        message.setFrom(new InternetAddress(MAIL_ACCOUNT));
        //设置发送方式与接收者
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

        //设置邮件主题
        message.setSubject(subject);
        //设置邮件内容
        message.setContent(emailMsg, "text/html;charset=utf-8");

        // 3.创建 Transport用于将邮件发送
        Transport.send(message);
    }
    public static void main(String[] args) throws AddressException, MessagingException {
        //这里的第一个参数是发送对方的邮箱，字符串类型
        sendMail("ceshi","rui.zhang@mi-me.com", "这是一个测试的邮件,点击跳转到<a href='http://www.baidu.com'>百度</a>");
        System.out.println("发送成功！");
    }
}
