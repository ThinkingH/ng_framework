package com.ng.tool.util;

import java.util.regex.Pattern;

/**
 * IP校验工具类
 * @author  ZhengWei
 * @version 2013年11月18日上午11:13:06
 * @since   JDK1.6 
 */
public final class IpUtil {

	/** 本地IPv4地址过滤regx */
	public static final String LAN_IP_REGX = "(192.168|10.[0-9]{1,3}|172.(1[6-9]|2[0-9]|3[0-1])).[0-9]{1,3}.[0-9]{1,3}";
	
	/**
	 * 判断某IPv4地址是否为本地IP，非严格校验，只针对服务器获取到的IPv4地址进行校验<br/>
	 * 本地IPv4本地地址:<br/>
	 * 1、<b>192.168</b>.0.0 ~ <b>192.168</b>.255.255<br/>
	 * 2、<b>172.16</b>.0.0  ~ <b>172.31</b>.255.255<br/>
	 * 3、<b>10</b>.0.0.0    ~ <b>10</b>.255.255.255<br/>
	 * @param ip 要被检测的IPv4类型的IP
	 * @return
	 */
	public static final boolean isLanIPv4(String ip) {
		return Pattern.matches(LAN_IP_REGX, ip);
	}
	
	public static void main(String[] args) {
		System.out.println("192.168:" + isLanIPv4("192.168.0.255"));
		System.out.println("172:" + isLanIPv4("172.16.0.255"));
		System.out.println("10.:" + isLanIPv4("10.168.0.255"));
	}
	
}
