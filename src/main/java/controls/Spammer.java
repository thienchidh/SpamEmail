package controls;

import _interface.IHandleNotification;
import _interface.ISpammer;
import model.Account;
import model.MessageContent;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

public class Spammer implements IHandleNotification, ISpammer {
    private final String email;
    private Transport transport;
    private Session mailSession;

    public Spammer(Account account) {
        super();
        Objects.requireNonNull(account);
        Objects.requireNonNull(account.getUsername());
        Objects.requireNonNull(account.getPassword());

        System.out.println("Start Login: \"" + account.getUsername() + "\" ...");
        boolean isLogged = login(account);
        if (!isLogged) {
            throw new RuntimeException(account.getUsername() + " Login Failed!");
        }
        System.out.println("\"" + account.getUsername() + "\" Login Success!");

        email = account.getUsername();
    }

    @Override
    public String getName() {
        return "Spammer";
    }

    private boolean login(Account account) {
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.ssl.enable", "true");

            mailSession = Session.getDefaultInstance(props);

            transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", account.getUsername(), account.getPassword());
        } catch (MessagingException e) {
            handleErr(e);
            return false;
        }
        return true;
    }

    @Override
    public List<Message> makeEmail(MessageContent content) {
        List<Message> result = new ArrayList<>();

        List<String> toEmails = content.getToEmails();
        for (String toEmail : toEmails) {
            Message message = new MimeMessage(mailSession);
            try {
                message.setFrom(new InternetAddress(email));
                message.setSubject(content.getSubject());
                message.setContent(content.getMessage(), "text/html; charset=utf-8");
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            } catch (MessagingException e) {
                handleErr(e);
                return null;
            }
            result.add(message);
        }
        return result;
    }

    @Override
    public boolean sendEmail(List<Message> messages) {
        Objects.requireNonNull(messages);

        for (Message message : messages) {
            Objects.requireNonNull(message);
            try {
                transport.sendMessage(message, message.getAllRecipients());
            } catch (Exception e) {
                handleErr(e);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean sendEmail(Message... message) {
        return sendEmail(Arrays.asList(message));
    }
}