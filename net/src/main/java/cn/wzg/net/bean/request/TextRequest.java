package cn.wzg.net.bean.request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TextRequest extends Request{
	public byte state;
	public String text;
	@Override
	public boolean isFix() {
		return false;
	}
	@Override
	public boolean isJiami() {
		return false;
	}
	@Override
	public int getId() {
		return 0x8300;
	}
	@Override
	public byte[] getMsgBody() throws IOException {
		ByteArrayOutputStream os  =new ByteArrayOutputStream();
		os.write(state);
		os.write(text.getBytes("GBK"));
		
		return os.toByteArray();
	}
	
	public void setJinji(boolean isjinji){
		state|=(1<<0);
	}
	public void setTLCshow(boolean isTcl){
		state|=(1<<2);
	}
	
	
	
	
}
