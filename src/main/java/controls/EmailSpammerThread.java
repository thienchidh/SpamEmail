package controls;

import _interface.IHandleNotification;
import _interface.ISpammer;
import _interface.ISpammersHandle;
import model.MessageContent;

import javax.mail.Message;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class EmailSpammerThread extends Thread implements ISpammersHandle, IHandleNotification {

    private final BlockingQueue<MessageContent> queue;
    private final ISpammer spammer;

    public EmailSpammerThread(BlockingQueue<MessageContent> queue, Spammer spammer) {
        super();

        Objects.requireNonNull(queue);
        Objects.requireNonNull(spammer);

        this.spammer = spammer;
        this.queue = queue;
    }

    @Override
    public void continues() {
        synchronized (this) {
            notifyAll();
        }
    }

    @Override
    public void pause() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                handleErr(e);
            }
        }
    }

    @Override
    public void run() {
        handleErr("Running...");

        while (!queue.isEmpty()) {
            MessageContent content = queue.remove();
            List<Message> emails = spammer.makeEmail(content);
            spammer.sendEmail(emails);
        }

        handleErr("Finished!");
    }
}

class MyExepction extends Exception {

    private static final long serialVersionUID = -3204124675639889668L;

    private final String msg;

    public MyExepction(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}