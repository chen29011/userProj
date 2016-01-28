package com.cqlj.user.common.decryption;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import org.junit.Test;

import com.cqlj.user.common.decryption.aes.AESUtil;
import com.cqlj.user.common.decryption.base64.Base64Util;
import com.cqlj.user.common.decryption.dh.BytesToHex;
import com.cqlj.user.common.decryption.dh.DHUtil;
import com.cqlj.user.common.decryption.dh.MessageDigestUtil;
import com.cqlj.user.common.decryption.dh.TripleDESUtil;
import com.cqlj.user.common.decryption.rsa.RSAUtil;
import com.cqlj.user.common.decryption.tripleDES.DESUtil;

public class MainTest {
	/** 待加密的明文 */
	public static final String DATA = "jikexueyuan";
	public static final String PATH = "mysql-installer-web-community-5.6.22.0.msi";

	/**
	 * test Base64
	 * 
	 * @throws Exception
	 */
	@Test
	public void base64Test() throws Exception {

		String base64Result = Base64Util.encryptBase64(DATA.getBytes());
		System.out.println(DATA + "  >>>Base64编码>>>" + base64Result);
		String base64String = Base64Util.decryptBase64(base64Result);
		System.out.println(base64Result + "  >>>Base64解码>>>" + base64String);
	}

	/**
	 * Test MD5
	 * 
	 * @throws Exception
	 */
	@Test
	public void md5Test() throws Exception {
		String md5Result = MessageDigestUtil.encryptMD5(DATA.getBytes());
		System.out.println(DATA + ">>>MD5>>>" + md5Result);

		/* Test MD5 of File */
		String fileMD5Result = MessageDigestUtil.getMD5OfFile(PATH);
		System.out.println("File MD5 : " + fileMD5Result);
	}

	/**
	 * Test SHA
	 * 
	 * @throws Exception
	 */
	@Test
	public void shaTest() throws Exception {
		String shaResult = MessageDigestUtil.encryptSHA(DATA.getBytes());
		System.out.println(DATA + ">>>SHA>>>" + shaResult);
	}

	/**
	 * Test HMAC
	 * 
	 * @throws Exception
	 */
	@Test
	public void hmacTest() throws Exception {
		byte[] hmacKey = MessageDigestUtil.initHmacKey();
		System.out.println("HMAC KEY: " + BytesToHex.fromBytesToHex(hmacKey));
		String hmacResult = MessageDigestUtil.encryptHmac(DATA.getBytes(), hmacKey);
		System.out.println(DATA + ">>>HMAC>>>" + hmacResult);
	}

	/**
	 * Test DES
	 * 
	 * @throws Exception
	 */
	@Test
	public void desTest() throws Exception {

		byte[] desKey = DESUtil.initKey();
		System.out.println("DES KEY : " + BytesToHex.fromBytesToHex(desKey));
		byte[] desResult = DESUtil.encrypt(DATA.getBytes(), desKey);
		System.out.println(DATA + ">>>DES 加密>>>" + BytesToHex.fromBytesToHex(desResult));

		byte[] desPlain = DESUtil.decrypt(desResult, desKey);
		System.out.println(DATA + ">>>DES 解密>>>" + new String(desPlain));
	}

	/**
	 * Test 3DES
	 * 
	 * @throws Exception
	 */
	@Test
	public void do3desTest() throws Exception {
		byte[] tridesKey = TripleDESUtil.initKey();
		System.out.println("3DES KEY : " + BytesToHex.fromBytesToHex(tridesKey));
		byte[] tridesResult = TripleDESUtil.encrypt(DATA.getBytes(), tridesKey);
		System.out.println(DATA + ">>>3DES 加密>>>" + BytesToHex.fromBytesToHex(tridesResult));

		byte[] tridesPlain = TripleDESUtil.decrypt(tridesResult, tridesKey);
		System.out.println(DATA + ">>>3DES 解密>>>" + new String(tridesPlain));
	}

	/**
	 * Test AES
	 * 
	 * @throws Exception
	 */
	@Test
	public void aesTest() throws Exception {

		byte[] aesKey = AESUtil.initKey();
		System.out.println("AES KEY : " + BytesToHex.fromBytesToHex(aesKey));
		byte[] aesResult = AESUtil.encrypt(DATA.getBytes(), aesKey);
		System.out.println(DATA + ">>>AES 加密>>>" + BytesToHex.fromBytesToHex(aesResult));

		byte[] aesPlain = AESUtil.decrypt(aesResult, aesKey);
		System.out.println(DATA + ">>>AES 解密>>>" + new String(aesPlain));
	}

	/**
	 * Test DH
	 * 
	 * @throws Exception
	 */
	@Test
	public void dhTest() throws Exception {

		// 甲方公钥
		byte[] publicKey1;
		// 甲方私钥
		byte[] privateKey1;
		// 甲方本地密钥
		byte[] secretKey1;
		// 乙方公钥
		byte[] publicKey2;
		// 乙方私钥
		byte[] privateKey2;
		// 乙方本地密钥
		byte[] secretKey2;

		// 初始化密钥 并生成甲方密钥对
		Map<String, Object> keyMap1 = DHUtil.initKey();
		publicKey1 = DHUtil.getPublicKey(keyMap1);
		privateKey1 = DHUtil.getPrivateKey(keyMap1);
		System.out.println("DH 甲方公钥 : " + BytesToHex.fromBytesToHex(publicKey1));
		System.out.println("DH 甲方私钥 : " + BytesToHex.fromBytesToHex(privateKey1));

		// 乙方根据甲方公钥产生乙方密钥对
		Map<String, Object> keyMap2 = DHUtil.initKey(publicKey1);
		publicKey2 = DHUtil.getPublicKey(keyMap2);
		privateKey2 = DHUtil.getPrivateKey(keyMap2);
		System.out.println("DH 乙方公钥 : " + BytesToHex.fromBytesToHex(publicKey2));
		System.out.println("DH 乙方私钥 : " + BytesToHex.fromBytesToHex(privateKey2));

		// 对于甲方， 根据其私钥和乙方发过来的公钥， 生成其本地密钥secretKey1
		secretKey1 = DHUtil.getSecretKey(publicKey2, privateKey1);
		System.out.println("DH 甲方 本地密钥 : " + BytesToHex.fromBytesToHex(secretKey1));

		// 对于乙方， 根据其私钥和甲方发过来的公钥， 生成其本地密钥secretKey2
		secretKey2 = DHUtil.getSecretKey(publicKey1, privateKey2);
		System.out.println("DH 乙方 本地密钥 : " + BytesToHex.fromBytesToHex(secretKey2));
	}

	/**
	 * Test RSA
	 * 
	 * @throws Exception
	 */
	@Test
	public void rsaTest() throws Exception {

		Map<String, Object> keyMap = RSAUtil.initKey();
		RSAPublicKey rsaPublicKey = RSAUtil.getPublicKey(keyMap);
		RSAPrivateKey rsaPrivateKey = RSAUtil.getPrivateKey(keyMap);
		System.out.println("RSA PublicKey : " + rsaPublicKey);
		System.out.println("RSA PrivateKey : " + rsaPrivateKey);

//		byte[] rsaResult = RSAUtil.encrypt(DATA.getBytes(), rsaPublicKey);
//		System.out.println(DATA + ">>>RSA 加密>>>" + BytesToHex.fromBytesToHex(rsaResult));
//
//		byte[] plainResult = RSAUtil.decrypt(rsaResult, rsaPrivateKey);
//		System.out.println(DATA + ">>>RSA 解密>>>" + new String(plainResult));
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException{
		Map<String, Object> keyMap = RSAUtil.initKey();
		RSAPublicKey rsaPublicKey = RSAUtil.getPublicKey(keyMap);
		RSAPrivateKey rsaPrivateKey = RSAUtil.getPrivateKey(keyMap);
		System.out.println("RSA PublicKey : " + rsaPublicKey);
		System.out.println("RSA PrivateKey : " + rsaPrivateKey);
	}
}
