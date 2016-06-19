package cn.wzg.net.bean.responce;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import cn.wzg.net.bean.MsgHeadinfo;

public abstract class Response {
	public boolean isFix;
	public boolean  isJiami;
	public int msgId;
	public String phoneT;
	public MsgHeadinfo msgheadinfo;
	
	public void  paserData(byte[] Msg) throws IOException{
		if(Msg==null){
			check(1, -1);
		}
		if(Msg.length<2){
			check(1, -1);
		}
		//add by shiqc 
		//走部标协议
		if(0x7e == Msg[0]&&0x7e==Msg[Msg.length-1]){
			// Object[] returndata = new Object[2];
			System.out.println("走部标协议？");
			msgheadinfo = new MsgHeadinfo();
			
			byte[] cutMsg = new byte[Msg.length - 2];
			for (int i = 0; i < cutMsg.length; i++) {
				cutMsg[i] = Msg[1 + i];
			}
			// 去掉校验码的
			byte[] cutcheck = new byte[cutMsg.length - 1];
			for (int i = 0; i < cutcheck.length; i++) {
				cutcheck[i] = cutMsg[i];
			}
			byte[] reverseEscapedDatabytes = reverseEscapeData(cutMsg);
				byte[] Messageid = new byte[2];
				Messageid[0] = reverseEscapedDatabytes[0];
				Messageid[1] = reverseEscapedDatabytes[1];
				msgheadinfo.setMsgId(bytes2int2(Messageid)); // 设置消息体id;
				msgId= msgheadinfo.getMsgId();
				
				
				byte[] byteMsgbodyProperty = new byte[2];
				byteMsgbodyProperty[0] = reverseEscapedDatabytes[2];
				byteMsgbodyProperty[1] = reverseEscapedDatabytes[3];
				byte[] forlength = new byte[2];
				forlength[0] = (byte) (byteMsgbodyProperty[0] & 0x03);
				forlength[1] = byteMsgbodyProperty[1];
				msgheadinfo.setMsgbodyLength(bytes2int2(forlength)); // 设置消息体长度
				msgheadinfo.setEncryptionMethod(byteMsgbodyProperty[1] & 0x1c); // 设置加密方式
				if ((byteMsgbodyProperty[0] & 0x20) == 0) {
					isFix=false;
				} else {
					isFix=true;
				}
				
				byte[] TerminalPhone = new byte[6];
				TerminalPhone[0] = reverseEscapedDatabytes[4];
				TerminalPhone[1] = reverseEscapedDatabytes[5];
				TerminalPhone[2] = reverseEscapedDatabytes[6];
				TerminalPhone[3] = reverseEscapedDatabytes[7];
				TerminalPhone[4] = reverseEscapedDatabytes[8];
				TerminalPhone[5] = reverseEscapedDatabytes[9];
				phoneT = new String(bcd2Str(TerminalPhone));
				msgheadinfo.setTerminalPhoneNum(phoneT);
				byte[] number = new byte[2];
				number[0] = reverseEscapedDatabytes[10];
				number[1] = reverseEscapedDatabytes[11];
				msgheadinfo.setNumber(bytes2int2(number));// 设置流水号
				if (!isFix) {// 不分包
					byte[] Msgbody = new byte[cutcheck.length - 12];
					for (int i = 0; i < Msgbody.length; i++) {
						Msgbody[i] = cutcheck[12 + i];
					}
					paser(Msgbody);
				}
		}

		
	}

	protected abstract void paser(byte[] msgbody);

	private void check(int read, int i) throws IOException {
		if(read!=i){
			throw new IOException("错误的数据结尾");
		}
		
	}
	/**
	 * 将两个字节的byte数组变成整数
	 * 
	 * @param byte[] b
	 * @return
	 */
	public static int bytes2int2(byte b[]) {
		int s = 0;
		s = ((b[0] & 0xff) << 8 | (b[1] & 0xff));
		return s;
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
	 * BCD码转为10进制串
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bcd2Str(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp
				.toString().substring(1) : temp.toString();

	}

}
