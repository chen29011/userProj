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
		json.put("headId", "11110001");
		json.put("branchId", "11110000");
		json.put("seatNo", "二楼清华!园");
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
