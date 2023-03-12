### 591. Tag Validator

```java
class Solution {
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
}
```