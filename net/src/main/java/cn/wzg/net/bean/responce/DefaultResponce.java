package cn.wzg.net.bean.responce;

public class DefaultResponce extends Response{
	public int trimId;
	public int responceId;
	public byte  resault;
	@Override
	protected void paser(byte[] msgbody) {
		if(msgbody==null||msgbody.length!=4){
			throw new IllegalArgumentException("数据错误");
		}
		
		byte[] data=new byte[2];
		data[0]=msgbody[0];
		data[1]=msgbody[1];
		trimId =bytes2int2(data);
		data[0]=msgbody[2];
		data[1]=msgbody[3];
		responceId=bytes2int2(data);
		resault=msgbody[4];
	}

}
