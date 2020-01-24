package _interface;

import model.MessageContent;

import javax.mail.Message;
import java.util.List;

public interface ISpammer {
    List<Message> makeEmail(MessageContent content);

    boolean sendEmail(List<Message> message);

    boolean sendEmail(Message... message);
}
