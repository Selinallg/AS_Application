package cn.wzg.net.bean.request;

import java.io.IOException;

public class AuthoRequest extends Request{
	public String autho;

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
		return 0x0102;
	}

	@Override
	public byte[] getMsgBody() throws IOException {
		return autho.getBytes("GBK");
	}

}
