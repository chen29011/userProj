package com.cqlj.user.autoCoder.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.cqlj.user.autoCoder.Entity;

public class PropsUtil {
	static Properties props = null;

	static {
		props = new Properties();
		String url = Entity.class.getResource("/").getPath();
		try {
			InputStream in = new FileInputStream(new File(url + "resourceConfig.properties"));
			props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据参数名称返回/param/paramConfig.properties中配置的参数值
	 * 
	 * @param 参数名称
	 * @return 参数值
	 */
	public static String getParamcValue(String paramCode) {
		return props.getProperty(paramCode).trim();
	}

}
