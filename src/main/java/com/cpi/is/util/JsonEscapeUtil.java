package com.cpi.is.util;

public class JsonEscapeUtil {

	public static String escape(String input) {
        if (input == null) {
            return null;
        }
        
        StringBuilder escaped = new StringBuilder();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '\\':
                    escaped.append("\\\\");
                    break;
                case '\'':
                    escaped.append("’"); 
                    break;
                case '"':
                    escaped.append("\\\"");
                    break;
                case '\b':
                    escaped.append("\\b");
                    break;
                case '\f':
                    escaped.append("\\f");
                    break;
                case '\n':
                    escaped.append("\\n");
                    break;
                case '\r':
                    escaped.append("\\r");
                    break;
                case '\t':
                    escaped.append("\\t");
                    break;
                default:
                    if (c < 32 || c > 127) {  // non-printable ASCII and non-ASCII
                        escaped.append(String.format("\\u%04x", (int) c));
                    } else {
                        escaped.append(c);
                    }
                    break;
            }
        }
        
        return escaped.toString();
    }
	
}
