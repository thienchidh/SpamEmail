package io;

import model.MessageContent;

import java.io.IOException;
import java.util.List;

public class ServicesMessages {
    private InputServices inputServices;

    public ServicesMessages() {
        super();
        inputServices = new InputServices();
    }

    public MessageContent getContentEmail() throws IOException {

        String subject = inputServices.readFileAsString(Config.PATH_FILE_SUBJECT);
        String content = inputServices.readFileAsString(Config.PATH_FILE_CONTENT);
        List<String> destEmail = inputServices.readFile(Config.PATH_FILE_DEST_MAIL);

        return new MessageContent(subject, content, destEmail);
    }
}