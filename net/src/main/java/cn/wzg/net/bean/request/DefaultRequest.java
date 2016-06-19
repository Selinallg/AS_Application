package cn.wzg.net.bean.request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DefaultRequest extends Request{

	
	public int trimId;
	public int responceId;
	public byte  resault;
	
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
		return 0x001;
	}

	@Override
	public byte[] getMsgBody() throws IOException {
		ByteArrayOutputStream os  =new ByteArrayOutputStream();
		os.write(int2bytes2(trimId));
		os.write(int2bytes2(responceId));
		os.write(resault);
		return os.toByteArray();
	}

}
