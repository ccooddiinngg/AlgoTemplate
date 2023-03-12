package Regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TagValidator {
    public boolean isValid(String code) {
        String cdata = "<!\\[CDATA\\[.*?\\]\\]>";
        String tag = "<([A-Z]{1,9})>[^<]*</\\1>";
        String str = code.replaceAll(cdata, "~");
        while (str.contains("</")) {
            String next = str.replaceAll(tag, "~");
            if (next.length() == str.length()) break;
            str = next;
        }
        return str.equals("~");
    }

    @Test
    void test() {
        String code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>";
        Assertions.assertTrue(isValid(code));
    }
}
