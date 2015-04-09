package org.apache.cordova.core;

import java.lang.*;
import java.io.*;

import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class ExceptionString{
	public static String get(final Throwable throwable) {
		 final StringWriter sw = new StringWriter();
		 final PrintWriter pw = new PrintWriter(sw, true);
		 throwable.printStackTrace(pw);
		 return sw.getBuffer().toString();
	}
}
