package io;

import com.google.gson.Gson;
import model.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServicesAccounts {
    private InputServices inputServices;
    private Gson gson;

    public ServicesAccounts() {
        super();
        inputServices = new InputServices();
        gson = new Gson();
    }

    public List<Account> readAllAcounts() throws IOException {
        String pathConfigAccounts = Config.PATH_FILE_ACCOUNTS;

        String json = inputServices.readFileAsString(pathConfigAccounts);
        List<?> jsonList = gson.fromJson(json, List.class);

        List<Account> list = new ArrayList<>();
        for (Object object : jsonList) {
            Account account = gson.fromJson(gson.toJson(object), Account.class);
            list.add(account);
        }
        return list;
    }

}