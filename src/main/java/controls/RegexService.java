package controls;

import org.apache.commons.lang.StringEscapeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexService {

    // unicode to hop -> unicode dung san
    public String compound2Unicode(String str) {
        str = str.replaceAll("\u0065\u0309", "\u1EBB");
        str = str.replaceAll("\u0065\u0301", "\u00E9");
        str = str.replaceAll("\u0065\u0300", "\u00E8");
        str = str.replaceAll("\u0065\u0323", "\u1EB9");
        str = str.replaceAll("\u0065\u0303", "\u1EBD");
        str = str.replaceAll("\u00EA\u0309", "\u1EC3");
        str = str.replaceAll("\u00EA\u0301", "\u1EBF");
        str = str.replaceAll("\u00EA\u0300", "\u1EC1");
        str = str.replaceAll("\u00EA\u0323", "\u1EC7");
        str = str.replaceAll("\u00EA\u0303", "\u1EC5");
        str = str.replaceAll("\u0079\u0309", "\u1EF7");
        str = str.replaceAll("\u0079\u0301", "\u00FD");
        str = str.replaceAll("\u0079\u0300", "\u1EF3");
        str = str.replaceAll("\u0079\u0323", "\u1EF5");
        str = str.replaceAll("\u0079\u0303", "\u1EF9");
        str = str.replaceAll("\u0075\u0309", "\u1EE7");
        str = str.replaceAll("\u0075\u0301", "\u00FA");
        str = str.replaceAll("\u0075\u0300", "\u00F9");
        str = str.replaceAll("\u0075\u0323", "\u1EE5");
        str = str.replaceAll("\u0075\u0303", "\u0169");
        str = str.replaceAll("\u01B0\u0309", "\u1EED");
        str = str.replaceAll("\u01B0\u0301", "\u1EE9");
        str = str.replaceAll("\u01B0\u0300", "\u1EEB");
        str = str.replaceAll("\u01B0\u0323", "\u1EF1");
        str = str.replaceAll("\u01B0\u0303", "\u1EEF");
        str = str.replaceAll("\u0069\u0309", "\u1EC9");
        str = str.replaceAll("\u0069\u0301", "\u00ED");
        str = str.replaceAll("\u0069\u0300", "\u00EC");
        str = str.replaceAll("\u0069\u0323", "\u1ECB");
        str = str.replaceAll("\u0069\u0303", "\u0129");
        str = str.replaceAll("\u006F\u0309", "\u1ECF");
        str = str.replaceAll("\u006F\u0301", "\u00F3");
        str = str.replaceAll("\u006F\u0300", "\u00F2");
        str = str.replaceAll("\u006F\u0323", "\u1ECD");
        str = str.replaceAll("\u006F\u0303", "\u00F5");
        str = str.replaceAll("\u01A1\u0309", "\u1EDF");
        str = str.replaceAll("\u01A1\u0301", "\u1EDB");
        str = str.replaceAll("\u01A1\u0300", "\u1EDD");
        str = str.replaceAll("\u01A1\u0323", "\u1EE3");
        str = str.replaceAll("\u01A1\u0303", "\u1EE1");
        str = str.replaceAll("\u00F4\u0309", "\u1ED5");
        str = str.replaceAll("\u00F4\u0301", "\u1ED1");
        str = str.replaceAll("\u00F4\u0300", "\u1ED3");
        str = str.replaceAll("\u00F4\u0323", "\u1ED9");
        str = str.replaceAll("\u00F4\u0303", "\u1ED7");
        str = str.replaceAll("\u0061\u0309", "\u1EA3");
        str = str.replaceAll("\u0061\u0301", "\u00E1");
        str = str.replaceAll("\u0061\u0300", "\u00E0");
        str = str.replaceAll("\u0061\u0323", "\u1EA1");
        str = str.replaceAll("\u0061\u0303", "\u00E3");
        str = str.replaceAll("\u0103\u0309", "\u1EB3");
        str = str.replaceAll("\u0103\u0301", "\u1EAF");
        str = str.replaceAll("\u0103\u0300", "\u1EB1");
        str = str.replaceAll("\u0103\u0323", "\u1EB7");
        str = str.replaceAll("\u0103\u0303", "\u1EB5");
        str = str.replaceAll("\u00E2\u0309", "\u1EA9");
        str = str.replaceAll("\u00E2\u0301", "\u1EA5");
        str = str.replaceAll("\u00E2\u0300", "\u1EA7");
        str = str.replaceAll("\u00E2\u0323", "\u1EAD");
        str = str.replaceAll("\u00E2\u0303", "\u1EAB");
        str = str.replaceAll("\u0045\u0309", "\u1EBA");
        str = str.replaceAll("\u0045\u0301", "\u00C9");
        str = str.replaceAll("\u0045\u0300", "\u00C8");
        str = str.replaceAll("\u0045\u0323", "\u1EB8");
        str = str.replaceAll("\u0045\u0303", "\u1EBC");
        str = str.replaceAll("\u00CA\u0309", "\u1EC2");
        str = str.replaceAll("\u00CA\u0301", "\u1EBE");
        str = str.replaceAll("\u00CA\u0300", "\u1EC0");
        str = str.replaceAll("\u00CA\u0323", "\u1EC6");
        str = str.replaceAll("\u00CA\u0303", "\u1EC4");
        str = str.replaceAll("\u0059\u0309", "\u1EF6");
        str = str.replaceAll("\u0059\u0301", "\u00DD");
        str = str.replaceAll("\u0059\u0300", "\u1EF2");
        str = str.replaceAll("\u0059\u0323", "\u1EF4");
        str = str.replaceAll("\u0059\u0303", "\u1EF8");
        str = str.replaceAll("\u0055\u0309", "\u1EE6");
        str = str.replaceAll("\u0055\u0301", "\u00DA");
        str = str.replaceAll("\u0055\u0300", "\u00D9");
        str = str.replaceAll("\u0055\u0323", "\u1EE4");
        str = str.replaceAll("\u0055\u0303", "\u0168");
        str = str.replaceAll("\u01AF\u0309", "\u1EEC");
        str = str.replaceAll("\u01AF\u0301", "\u1EE8");
        str = str.replaceAll("\u01AF\u0300", "\u1EEA");
        str = str.replaceAll("\u01AF\u0323", "\u1EF0");
        str = str.replaceAll("\u01AF\u0303", "\u1EEE");
        str = str.replaceAll("\u0049\u0309", "\u1EC8");
        str = str.replaceAll("\u0049\u0301", "\u00CD");
        str = str.replaceAll("\u0049\u0300", "\u00CC");
        str = str.replaceAll("\u0049\u0323", "\u1ECA");
        str = str.replaceAll("\u0049\u0303", "\u0128");
        str = str.replaceAll("\u004F\u0309", "\u1ECE");
        str = str.replaceAll("\u004F\u0301", "\u00D3");
        str = str.replaceAll("\u004F\u0300", "\u00D2");
        str = str.replaceAll("\u004F\u0323", "\u1ECC");
        str = str.replaceAll("\u004F\u0303", "\u00D5");
        str = str.replaceAll("\u01A0\u0309", "\u1EDE");
        str = str.replaceAll("\u01A0\u0301", "\u1EDA");
        str = str.replaceAll("\u01A0\u0300", "\u1EDC");
        str = str.replaceAll("\u01A0\u0323", "\u1EE2");
        str = str.replaceAll("\u01A0\u0303", "\u1EE0");
        str = str.replaceAll("\u00D4\u0309", "\u1ED4");
        str = str.replaceAll("\u00D4\u0301", "\u1ED0");
        str = str.replaceAll("\u00D4\u0300", "\u1ED2");
        str = str.replaceAll("\u00D4\u0323", "\u1ED8");
        str = str.replaceAll("\u00D4\u0303", "\u1ED6");
        str = str.replaceAll("\u0041\u0309", "\u1EA2");
        str = str.replaceAll("\u0041\u0301", "\u00C1");
        str = str.replaceAll("\u0041\u0300", "\u00C0");
        str = str.replaceAll("\u0041\u0323", "\u1EA0");
        str = str.replaceAll("\u0041\u0303", "\u00C3");
        str = str.replaceAll("\u0102\u0309", "\u1EB2");
        str = str.replaceAll("\u0102\u0301", "\u1EAE");
        str = str.replaceAll("\u0102\u0300", "\u1EB0");
        str = str.replaceAll("\u0102\u0323", "\u1EB6");
        str = str.replaceAll("\u0102\u0303", "\u1EB4");
        str = str.replaceAll("\u00C2\u0309", "\u1EA8");
        str = str.replaceAll("\u00C2\u0301", "\u1EA4");
        str = str.replaceAll("\u00C2\u0300", "\u1EA6");
        str = str.replaceAll("\u00C2\u0323", "\u1EAC");
        str = str.replaceAll("\u00C2\u0303", "\u1EAA");
        return str;
    }

    private List<String> compute(String s, String regex) {

        List<String> array = new LinkedList<>();
        if ((s != null) && !s.isEmpty()) {
            s = compound2Unicode(StringEscapeUtils.unescapeHtml(s).replaceAll("\\s+", " "));
            Pattern pt = Pattern.compile(regex);
            Matcher m = pt.matcher(s);
            while (m.find()) {
                int groupCount = m.groupCount();
                StringBuilder sb = new StringBuilder();

                for (int i = 1; i <= groupCount; i++) {

                    String x = m.group(i);
                    if (x != null) {
                        String group = x.trim();
                        if (!group.isEmpty()) {
                            sb.append(group);
                        }
                    }
                }
                String res = sb.toString();
                if (!res.isEmpty()) {
                    array.add(res);
                }
            }
        }

        return array;
    }

    public String first(Object e, String regex) {

        List<String> list = null;
        if (e != null) {
            String s = e.toString();
            list = compute(s, regex);
        }
        if ((list == null) || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /**
     * never return null
     */
    public List<String> list(Object e, String regex) {

        if (e != null) {
            String s = e.toString();
            return compute(s, regex);
        }
        return new ArrayList<>();
    }

}
