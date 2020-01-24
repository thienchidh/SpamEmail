package test;

import controls.EmailSpammerThread;
import controls.Spammer;
import io.ServicesAccounts;
import io.ServicesMessages;
import model.Account;
import model.MessageContent;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {

        List<Account> accounts = new ServicesAccounts().readAllAcounts();

        BlockingQueue<MessageContent> queue = new LinkedBlockingQueue<>();

        MessageContent content = new ServicesMessages().getContentEmail();
        Objects.requireNonNull(content);

//	int numOfEmails = 50;
//	for (int i = 0; i < numOfEmails; ++i) {
//	    queue.put(new MessageContent(content.getSubject() + " " + i, content.getMessage() + " " + i, toEmails));
//	}

        queue.put(content);

        for (Account account : accounts) {
            Spammer spammer = new Spammer(account);

            // make new threads
            EmailSpammerThread emailSpammerThread = new EmailSpammerThread(queue, spammer);
            emailSpammerThread.start();
        }
    }
}
