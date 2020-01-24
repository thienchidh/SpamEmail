package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MessageContent {

    @SerializedName("subject")
    @Expose
    private final String subject;
    @SerializedName("message")
    @Expose
    private final String message;
    @SerializedName("toEmails")
    @Expose
    private final List<String> toEmails;

    public MessageContent(MessageContent content, List<String> toEmails) {
        this(content.getSubject(), content.getMessage(), toEmails);
    }

    public MessageContent(String subject, String message, List<String> toEmails) {
        super();

        Objects.requireNonNull(subject);
        Objects.requireNonNull(message);
        Objects.requireNonNull(toEmails);

        this.subject = subject;
        this.message = message;
        this.toEmails = toEmails;
    }

    public MessageContent(String subject, String message, String... toEmails) {
        this(subject, message, Arrays.asList(toEmails));
    }

    public String getMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }

    public List<String> getToEmails() {
        return toEmails;
    }

}