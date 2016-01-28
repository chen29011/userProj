package com.cqlj.user.common.barCode.qrCode;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

public class QrCodeUtilsTest {
	@Test
	public void qrEncodeTest() throws WriterException, IOException {
		String url = "http://www.dijiaapp.com?key=";
		JSONObject json = new JSONObject();
		json.put("headId", "1");
		json.put("branchId", "2");
		json.put("seatNo", "一楼22号");
		Path path = FileSystems.getDefault().getPath("D://", "zxing.png");
		QrCodeUtils.qrEncode(path, 200, 200, "png", url + json.toJSONString());
	}

	@Test
	public void qrDecodeTest() throws NotFoundException, IOException {
		File file = new File("D://zxing.png");
		String str = QrCodeUtils.qrDecode(file);
		System.out.println(str);
	}
}
