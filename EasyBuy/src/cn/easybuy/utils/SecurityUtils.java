package cn.easybuy.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.chainsaw.Main;

public class SecurityUtils {
	/**
	 * md5加密
	 */
	public static String md5Hex(String value) {
		return DigestUtils.md5Hex(value);
	}

	/**
	 * 三次md5操作
	 */
	public static String md5Hex3(String value) {
		for (int i = 0; i < 3; i++) {
			value = DigestUtils.md5Hex(value);
		}
		return value;
	}

	/**
	 * sha256加密
	 * Secure Hash Algorithm:译作安全散列算法) 
	 * 是美国国家安全局 (NSA) 设计， 美国国家标准与技术研究院 (NIST) 发布的一系列密码散列函数。
	 * @param value
	 *            要加密的值
	 * @return sha256 加密后的值
	 */
	public static String sha256Hex(String value) {
		return DigestUtils.sha256Hex(value);
	}

	public static String sha512Hex(String value) {
		return DigestUtils.sha512Hex(value);
	}

	public static void main(String[] args) {
		System.out.println(SecurityUtils.md5Hex("123456"));
		System.out.println(SecurityUtils.md5Hex3("123456"));
		System.out.println(SecurityUtils.sha256Hex("123456"));
		System.out.println(SecurityUtils.sha512Hex("123456"));
	}
}
