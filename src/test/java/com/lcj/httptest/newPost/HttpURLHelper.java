package com.lcj.httptest.newPost;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

 
public class HttpURLHelper {

	private static final Log logger = LogFactory.getLog(HttpURLHelper.class);
	public final static String TRANSMIT_DATA_URL="TRANSMIT_DATA_URL";
	
	private static Properties properties = new Properties();
	private final static String FILE_PATH = "config/url.properties";

	static {
		InputStream inputStream = null;
		
		try { 
			inputStream = HttpURLHelper.class.getClassLoader()
					.getResourceAsStream(FILE_PATH);
			if (inputStream != null) {
				properties.load(inputStream);
			}
		} catch (IOException e) {
			logger.error("加载url.properties失败!", e);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
			}
		}
	}

	private static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public static String getUrl(String module, String urlCode) {
		String url = getProperty(urlCode);
        Object[] fmtargs  =   {module};
        url =  MessageFormat.format(url, fmtargs);
		return url;
	}
	
	public static String getUrl(String urlCode) {
		String url = getProperty(urlCode);
		return url;
	}
	
	
}
