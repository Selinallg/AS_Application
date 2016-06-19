package cn.wzg.net.bean.responce;

import java.io.UnsupportedEncodingException;


public class RegistResponce extends Response {

	
	
	
	private int Num;
	private byte result;
	private String Authentication_code;

	@Override
	protected void paser(byte[] msgbody) {
		byte[] numbyte = new byte[2];
		numbyte[0]=msgbody[0];
		numbyte[1]=msgbody[1];
		Num=bytes2int2(numbyte);
		
		result=msgbody[2];
		
		try {
			Authentication_code = new String(msgbody, 3, msgbody.length-3,"GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}
