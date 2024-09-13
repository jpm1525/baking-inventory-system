package com.cpi.is.util;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class EscapeUtil {
	
	public static JSONArray escapeQuotes(JSONArray jsonArray) {
		for (int i=0; i<jsonArray.length(); i++) {
			jsonArray.put(i, escapeQuotes((JSONObject) jsonArray.get(i)));
		}
		return jsonArray;
	}
	
	public static JSONObject escapeQuotes(JSONObject jsonObject) {
		Iterator<String> keys = jsonObject.keys();
		while (keys.hasNext()) {
			String key = keys.next();
			Object obj = null;
			try {
				obj = jsonObject.get(key);
			} catch(Exception e) {
				continue;
			} finally {
				if (obj != null && obj instanceof String) {
					StringBuilder escaped = new StringBuilder();
					String value = obj.toString();
					
					for (char c : value.toCharArray()) {
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
					jsonObject.put(key, escaped);
				}
			}
		}
		return jsonObject;
	}

}