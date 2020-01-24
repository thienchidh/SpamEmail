package io;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class InputServices {
    private static final String UTF_8 = "UTF-8";
    private Gson gson;

    public InputServices() {
        super();
        gson = new Gson();
    }

    public List<String> readFile(File file) throws IOException {
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        }
        return list;
    }

    public List<String> readFile(String path) throws IOException {
        return readFile(new File(path));
    }

    public String readFileAsString(File file) throws IOException {

        StringBuilder sb = new StringBuilder();

        List<String> list = readFile(file);
        for (String string : list) {
            sb.append(string).append('\n');
        }

        return sb.toString();
    }

    public String readFileAsString(String path) throws IOException {

        return readFileAsString(new File(path));
    }

    public Map<String, String> readFileConfig(String file) throws Exception {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String json = sb.toString();

            @SuppressWarnings("unchecked")
            Map<String, String> map = gson.fromJson(json, Map.class);
            return map;
        }
    }

}