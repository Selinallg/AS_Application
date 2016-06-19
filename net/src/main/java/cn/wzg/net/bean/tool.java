package cn.wzg.net.bean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class tool {
	/**
	 * 获取校验码
	 * @param data
	 * @return
	 */
	public static byte CheckBytes(byte[] data) {
		byte checked = (byte) (data[0] ^ data[1]);
		for (int i = 2; i < (data.length); i++) {
			checked = (byte) (checked ^ data[i]);
		}
		return checked;
	}

	/**
	 * 转义
	 * @param data byte[]数组
	 * @return byte[]数组
	 */
	public static byte[] escapeData(byte[] data) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] escapedDatabytes;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 0x7e) {
				bos.write((byte) 0x7d);
				bos.write((byte) 0x02);
			} else if (data[i] == 0x7d) {
				bos.write((byte) 0x7d);
				bos.write((byte) 0x01);
			} else {
				bos.write((byte) data[i]);
			}
		}
		escapedDatabytes = bos.toByteArray();
		try {
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return escapedDatabytes;
	}

	/**
	 * 反转转义
	 * @param data
	 * @return
	 */
	public static byte[] reverseEscapeData(byte[] data) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] reverseEscapedDatabytes;
		for (int i = 0; i < (data.length - 1); i++) {
			if (data[i] == 0x7d && data[i + 1] == 0x02) {
				bos.write((byte) 0x7e);
				i++;
			} else if (data[i] == 0x7d && data[i + 1] == 0x01) {
				bos.write((byte) 0x7d);
				i++;
			} else if ((data[i] == 0x7d && data[i + 1] != 0x02)
					|| (data[i] == 0x7d && data[i + 1] != 0x01)) {
				reverseEscapedDatabytes = null;
				System.out.println("数据有误");
				break;
			} else {
				bos.write((byte) data[i]);
			}
		}
		if (data[data.length - 1] != 0x7d) {
			bos.write((byte) data[data.length - 1]);
		} else {
			reverseEscapedDatabytes = null;
			System.out.println("数据有误");
		}
		reverseEscapedDatabytes = bos.toByteArray();
		try {
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reverseEscapedDatabytes;
	}
    
	/**
	 * 准备发送前数据
	 * @param heads 消息头
	 * @param data 消息体
	 * @return
	 */
	public static byte[] prepareDataToSend(byte[] heads, byte[] data) {// 传入的是消息头和消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
		ByteArrayOutputStream bosfinal = new ByteArrayOutputStream();
		byte[] forchecked;
		byte checked;
		byte[] forescape;
		byte[] escapedData;
		byte[] finaldata = null;
		try {
			bos.write(heads);
			bos.write(data);
			forchecked = bos.toByteArray();
			bos.close();
			checked = CheckBytes(forchecked);
			bos1.write(forchecked);
			bos1.write((byte) checked);
			forescape = bos1.toByteArray();
			bos1.close();
			escapedData = escapeData(forescape);
			bosfinal.write((byte) 0x7e);
			bosfinal.write(escapedData);
			bosfinal.write((byte) 0x7e);
			finaldata = bosfinal.toByteArray();
			bosfinal.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finaldata;
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] b = { 0x7d, 0x01, 0x73, 0x7e };
		byte[] co;
		byte[] e;
		byte d;
		tool c = new tool();
		d = tool.CheckBytes(b);
		co = c.escapeData(b);
		e = tool.reverseEscapeData(b);
		System.out.println(d);
		for (int i = 0; i < co.length; i++) {
			System.out.println(co[i]);
		}
		for (int i = 0; i < e.length; i++) {
			System.out.println(e[i]);
		}

	}
}
