package io;

public class Config {

    public static final String PATH_FILE_ACCOUNTS = "input/accounts/Accounts.json";
    public static final String PATH_FILE_SUBJECT = "input/subject.txt";
    public static final String PATH_FILE_CONTENT = "input/content.txt";
    public static final String PATH_FILE_DEST_MAIL = "input/destEmails.txt";
    private Config() {
    }

    public static Config getInstance() {
        return Singleton.singleton;
    }

    private static class Singleton {
        private static Config singleton = new Config();
    }
}