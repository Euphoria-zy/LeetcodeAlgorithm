package com.zy.normalproblem;

import java.util.HashSet;
import java.util.Set;
/*
*
1410. HTML 实体解析器
* */
public class entityParser_Medium {
    public static void main(String[] args) {
        String text = "and I quote: &quot;...&quot;";
        String result = Solution_57.entityParser(text);
        System.out.println(result);
    }
}

class Solution_57 {
    public static String entityParser(String text) {
        StringBuilder  result = new StringBuilder();

        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '&') {
                if(temp.length() != 0) {
                    result.append(temp.toString());
                    temp = new StringBuilder();
                }
                temp.append('&');
            } else {
                if(temp.length() == 0) {
                    result.append(text.charAt(i));
                } else {
                    temp.append(text.charAt(i));
                    if(text.charAt(i) == ';') {
                        String realStr = matchStr(temp.toString());
                        result.append(realStr);
                        temp = new StringBuilder();
                    }
                }

            }
        }
        if(temp.length() != 0) {
            result.append(temp.toString());
            temp = new StringBuilder();
        }
        return result.toString();
    }
    public static String matchStr(String str) {
        switch(str) {
            case "&quot;":
                return "\"";
            case "&apos;":
                return "'";
            case "&amp;":
                return "&";
            case "&gt;":
                return ">";
            case "&lt;":
                return "<";
            case "&frasl;":
                return "/";
            default:
                return str;
        }
    }
}
