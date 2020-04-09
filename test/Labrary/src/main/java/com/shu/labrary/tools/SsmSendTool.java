package com.shu.labrary.tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

public class SsmSendTool {
    public  static void SendCheckCode(String receiver, String SmsCode) throws MessagingException {

            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            // Get a Properties object
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.qq.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.enable", true);

            try {
            //添加认证内容
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("993323915@qq.com", "duabfsatepsibbef");
                }
            };

            //获取本次会话对象:连接成功
            Session session=Session.getInstance(props,authenticator);
            //创建发送消息
            MimeMessage msg=new MimeMessage(session);

            //发送人
            msg.setFrom(new InternetAddress("993323915@qq.com"));
            //接收人
            msg.setSubject("上海大学写作中心感谢您预约");
            msg.setRecipients(MimeMessage.RecipientType.TO,receiver);

            //邮件主题
            msg.setContent("<html>\n" +
                    "\n" +
                    "<head>\n" +
                    "<title>上海大学写作中心通知您：</title>\n" +
                    "</head>\n" +
                    "<body tabindex=\"0\" role=\"listitem\">\n" +
                    "<table width=\"700\" border=\"0\" align=\"center\" cellspacing=\"0\" style=\"width:700px;\">\n" +
                    "    <tbody>\n" +
                    "    <tr>\n" +
                    "        <td>\n" +
                    "        <div style=\"line-height:1.5;font-size:14px;margin-bottom:25px;color:#4d4d4d;\">\n" +
                    "                    <strong style=\"display:block;margin-bottom:15px;\">尊敬的用户：<span style=\"color:#f60;font-size: 16px;\"></span>您好！</strong>\n" +
                    "                    <strong style=\"display:block;margin-bottom:15px;\">\n" +
                    "                      感谢您预约上海大学写作中心，请在验证码输入框中输入：<span style=\"color:#f60;font-size: 24px\">"+SmsCode+"</span>，请在10分钟内填写验证码，以完成预约操作。\n" +
                    "                    </strong>\n" +
                    "                </div>\n" +
                    "        </td>\n" +
                    "    </tr>\n" +
                    "    </tbody>\n" +
                    "</table>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>\n","text/html;charset=utf-8");
            Transport.send(msg);

        }catch (MessagingException e)
        {
           throw new MessagingException("error");
        }
    }



}
