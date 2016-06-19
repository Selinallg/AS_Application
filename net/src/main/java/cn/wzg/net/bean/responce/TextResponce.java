package cn.wzg.net.bean.responce;

public class TextResponce extends Response{
	public byte state;
	public String text;
	
	@Override
	protected void paser(byte[] msgbody) {
		state =msgbody[0];
		text =new String(msgbody, 1, msgbody.length-1);
	}
	
	public boolean isJinji(){
		return (state&(1<<0))>0;
	}
	public boolean isTLCshow(){
		return (state&(1<<2))>0;
	}
	

}
