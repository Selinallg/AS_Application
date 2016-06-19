package cn.wzg.net.bean.request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import cn.wzg.net.bean.tool;

public abstract class Request {
	public static short num=0;
	public abstract boolean isFix();//是否分包
	public abstract boolean isJiami();//是否加密
	/**
	 * 消息id
	 * @return
	 */
	public abstract int getId();
	public abstract byte[] getMsgBody() throws IOException;
	
	/**
	 * 消息结构的封装
	 * @return
	 * @throws IOException
	 */
	public byte[] getBytes() throws IOException{
		byte[] id =int2bytes2(getId());
		byte[] body =getMsgBody();
		byte[] shuxing=null;
		if(body==null){
			
			//空消息，消息体长度为0
			shuxing=getShuxing(isFix(),isJiami(),0);
		}else{
			shuxing=getShuxing(isFix(),isJiami(),body.length);
		}
		//消息头
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(id);//消息id
		bos.write(shuxing);//消息属性
		bos.write(getPhoneNum());//手机号码
		bos.write(int2bytes2(num++));//流水号
		if(!isFix()){//分包信息
			//需要在bos添加分包的信息
			
		}
		byte[] head = bos.toByteArray();
		return setMsg(head, body);
	}
	
	
	
	public void send() throws IOException{
		// 
		byte[] data = getBytes();
		
		
	}
	
	
	
	
	/**
	 * 获取手机号码
	 * @return
	 */
	private byte[] getPhoneNum() {
		return str2Bcd("17812312311");
	}
	
	/**
	 * 消息头属性信息
	 * @param fix  是否需要分包
	 * @param jiami   是否加密
	 * @param i
	 * @return
	 */
	private byte[] getShuxing(boolean fix, boolean jiami, int i) {
		byte[] shux=new byte[2];
		shux[0] &=0x03;
		byte[] len = int2bytes2(i);
		shux[1]=len[1];
		shux[0]&=len[0];
		return shux;
	}
	/**
	 * String 转换成BCD数组
	 * 
	 * 1. 数字 直接转换成相应的bcd数字
	 * 2.  字母  字母 在0a的基础上加上超过a的值，不区分大小写
	 * 
	 * @param asc
	 * @return
	 */
	public static byte[] str2Bcd(String asc) {
		int len = asc.length();
		int mod = len % 2;

		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}

		byte abt[] = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}

		byte bbt[] = new byte[len];
		abt = asc.getBytes();
		int j, k;

		for (int p = 0; p < asc.length() / 2; p++) {
			if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				//
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}

			if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}

			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}

	/**
	 * int类型转换成一个4长度的byte数组
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] intToByteArray(int value) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			int offset = (b.length - 1 - i) * 8;
			b[i] = (byte) ((value >>> offset) & 0xFF);
		}
		return b;
	}

	/**
	 * int类型转换成一个2长度的byte数组
	 * 
	 * @param value
	 * @return
	 */
	public byte[] int2bytes2(int value) {
		byte[] ret = new byte[2];
		ret[1] = (byte) (value & 0xFF);// 低位
		value = value >> 8;
		ret[0] = (byte) (value & 0xFF);// 高位
		return ret;
	}
   
	/**
	 * float类型转换为一个4长度的byte数组
	 * @author wyd
	 * @param value
	 * @return  
	 */
	public  byte[] float2byte4(float x) {
	    byte[] b = new byte[4];
	    int l = Float.floatToIntBits(x);
	    for (int i = 0; i < 4; i++) {
	        b[i] = new Integer(l).byteValue();
	        l = l >> 8;
	    }	    
	    return b;
	}
	
	
	// ascii码字节转化成16进制字符串
	public final static byte[] bytes2BCDStr(byte[] src) {
		if (src == null || src.length <= 0) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < src.length; i++) {
			byte e = src[i];
			sb.append(Integer.toHexString((e >> 4) & 0x0f));
			sb.append(Integer.toHexString(e & 0x0f));
		}
		return sb.toString().getBytes();
	}
	
	/**
	 * 拼凑完整消息
	 * 
	 * @param Msghead
	 *            消息头
	 * @param Msgbody
	 *            消息体
	 * @return 完整的数据包byte[]
	 * @throws IOException
	 */
	public byte[] setMsg(byte[] Msghead, byte[] Msgbody) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ByteArrayOutputStream bosfinal = new ByteArrayOutputStream();
		tool c = new tool();
		//先写消息头
		bos.write(Msghead);
		//再写消息体
		if (Msgbody != null) {
			bos.write(Msgbody);
		}
		//校验前 先转化需要校验的消息头 和消息体 为byte
		byte[] forcheck = bos.toByteArray();
		/**
		 * 校验码
		 */
		byte checked = c.CheckBytes(forcheck);
		//写入校验后的 校验结果
		bos.write((byte) checked);
		byte[] turn = bos.toByteArray();
		/**
		 * 转义
		 */
		byte[] turndata = c.escapeData(turn);
		bos.close();
		//写入起止符 标识位
		//先写头标识
		bosfinal.write((byte) 0x7e);
		//在写入 转义后的消息内容（消息头+消息体+校验码）
		bosfinal.write(turndata);
		//写入 头标识 结束符
		bosfinal.write((byte) 0x7e);
		//转成byte
		byte[] returndata = bosfinal.toByteArray();
		return returndata;
	}
	
	/**
	 * 
	 * @author LiuLiangGuo
	 *
	 */
	public static interface Item{
		byte[] getByte();
	}
	
}
