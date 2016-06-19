package cn.wzg.net.bean.request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class RegistRequest extends Request {
	private int Provincial_ID;//省域ID
	private int City_ID;//市县域ID
	private String Manufacturers_Id;//制造商ID
	private String terminalType;//终端型号
	private String terminalID;//终端ID
	private byte color;//车牌颜色
	private String carNumber;//车牌号码
	
	
	public RegistRequest() {
		Provincial_ID =0x01;
		City_ID =0x01;
		Manufacturers_Id ="12323";
		terminalType="11111222223333344444";
		terminalID="1234567";
		color=0x01;
		carNumber="1212213";
	}
	
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
		return 0x0100;
	}
	
	/**
	 * terminalLogInfo tlInfo = new terminalLogInfo();
	
		
		
		
		byte color = Msgbody[24+12];
		byte[] carNum = new byte[Msgbody.length - (25+12)];
		for (int i = (25+12); i < Msgbody.length; i++) {
			carNum[i - (25+12)] = Msgbody[i];
		}
		String carNumber = new String(carNum, "GBK");
		
		tlInfo.setProvincial_ID(Provincial_ID);
		tlInfo.setCity_ID(City_ID);
		tlInfo.setColor(color);
		tlInfo.setManufacturers_Id(Manufacturers_Id);
		//String terminalID1 = carNumber.substring(0,11).trim();
		tlInfo.setTerminalID(terminalID);
		tlInfo.setTerminalType(terminalType);
		//String carnum = carNumber.substring(12);
		tlInfo.setCarNumber(carNumber);
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	public byte[] getMsgBody() throws IOException {
		ByteArrayOutputStream os  =new ByteArrayOutputStream();
		
		byte[] provincebyte=new byte[2];
		//int Provincial_ID = bytes2int2(provincebyte);
		provincebyte =int2bytes2(Provincial_ID);
		os.write(provincebyte);
		
		
		
		//int City_ID = bytes2int2(citybyte);
		byte[] citybyte = new byte[2];
		
		citybyte =int2bytes2(City_ID);
		os.write(citybyte);
		
		
		
		byte Manufacturersbyte[] = new byte[5];
		Manufacturersbyte = Manufacturers_Id.getBytes("US-ASCII");
		os.write(Manufacturersbyte);
		
		
		
		byte[] TerminalTypeByte = new byte[8+12];
		TerminalTypeByte= terminalType.getBytes("US-ASCII");
		os.write(TerminalTypeByte);
		
		byte[] terminalIDbyte = new byte[7];
		terminalIDbyte= terminalID.getBytes("US-ASCII");
		os.write(terminalIDbyte);
		
		byte color = this.color;
		os.write(color);
		
		byte[] carNum =carNumber.getBytes("GBK");
		os.write(carNum);
		
		
		
		
		
		
		return os.toByteArray();
	}

}
