package cn.wzg.net.bean.request;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class LocationUploadRequest extends Request {
	public GpsInfomation gpsinfo;

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
		return 0x0200;
	}

	@Override
	public byte[] getMsgBody() throws IOException {
		/*
		 * 解析报警标志位
		 */
		GpsInfomation gpsinfo = new GpsInfomation();
		StringBuffer sb = new StringBuffer();
		byte[] info = new byte[28];

		/**************** 解析报警标志位，第4字节（由于是大端模式） *******************************************/
		if (gpsinfo.isVSSError()) {// 车辆VSS故障,24
			info[0] |= 0x01;
		}
		if (gpsinfo.isNormalOil()) {// 车辆油量异常,25
			info[0] |= 0x02;
		}
		if (gpsinfo.isCarStolen()) {// 车辆被盗,26
			info[0] |= 0x04;
		}
		if (gpsinfo.isCarIllegalIgnition()) {// 车辆非法点火,27
			info[0] |= 0x08;
		}

		if (gpsinfo.isCarIllegalDisplacement()) {// 车辆非法位移，28
			info[0] |= 0x10;
		}
		if (gpsinfo.isRolloverAlarm()) {// 碰撞侧翻报警，29
			info[0] |= 0x20;
		}
		if (gpsinfo.isRolloverPrevetion()) {// 30 碰撞侧翻预警
			info[0] |= 0x40;
		}
		if (gpsinfo.isIllegeOpenDoor()) {// 31 非法开门报警
			info[0] |= 0x80;
		}
		/**************** 解析报警标志位，第3字节 *******************************************/
		// if ((Msgbody[1] & 0x01) == 0) {// 保留16
		//
		// } else {
		//
		// }
		// if ((Msgbody[1] & 0x02) == 0) {// 保留，17
		//
		// } else {
		//
		// }
		if (gpsinfo.isDriveOvertime()) {// 当天累计驾驶超时,18
			info[1] |= 0x04;
		}
		if (gpsinfo.isStopOvertime()) {// 超时停车,19

			info[1] |= 0x08;
		}
		if (gpsinfo.isTurnoverArea()) {// 进出区域，20
			info[1] |= 0x10;
		}
		if (gpsinfo.isTurnoverRoad()) {// 进出路线，21
			info[1] |= 0x20;
		}
		if (gpsinfo.isRoadDriveTimeIllegal()) {// 路段行驶时间不足/过长,22
			info[1] |= 0x40;
		}
		if (gpsinfo.isYawAlarm()) {// 路线偏离报警,23
			info[1] |= 0x80;
		}

		/**************** 解析报警标志位，第2字节（由于是大端模式，所以传过来后先解析DWORD的高位） *******************************************/
		if (gpsinfo.isMainPowerloss()) {// 终端主电源掉电
			info[2] |= 0x01;
		}
		if (gpsinfo.isLCDError()) {// 终端LCD或显示屏故障,9
			info[2] |= 0x02;
		} else {
			gpsinfo.isLCDError();
			sb.append(",10");
		}
		if (gpsinfo.isTTSError()) {// TTS模块故障,10
			info[2] |= 0x04;
		}
		if (gpsinfo.isCameraError()) {// 摄像头故障,11
			info[2] |= 0x08;
		}
		if (gpsinfo.isICcardError()) {// 12, IC卡模块故障
			info[2] |= 0x10;
		}
		if (gpsinfo.isOverSpeedPrevetion()) {// 13 超速预警
			info[2] |= 0x20;
		}
		if (gpsinfo.isTiredDrivePretion()) {// 14 疲劳驾驶预警
			info[2] |= 0x40;
		}
		// /** 15-17位是保留位，暂时不做任何处理 **/
		// if ((Msgbody[2] & 0x80) == 0) {// 15
		//
		// } else {
		//
		// }
		/**************** 解析报警标志位，第1字节 *******************************************/
		if (gpsinfo.isEmergencyAlarm()) {// 紧急报警
			info[3] |= 0x01;
		}
		if (gpsinfo.isOverSpeedAlarm()) {// 超速报警
			info[3] |= 0x02;
		}
		if (gpsinfo.isTiredAlarm()) {// 疲劳驾驶
			info[3] |= 0x04;
		}
		if (gpsinfo.isPreventionAlarm()) {// 预警
			info[3] |= 0x08;
		}
		if (gpsinfo.isGNSSError()) {// GNSS模块发生故障
			info[3] |= 0x10;
		}
		if (gpsinfo.isGNSSCutoff()) {// GNSS天线未接或被剪断
			info[3] |= 0x20;
		}
		if (gpsinfo.isGNSSShortcircuit()) {// GNSS天线短路
			info[3] |= 0x40;
		}
		if (gpsinfo.isMainsUndervoltage()) {// 主电压欠压
			info[3] |= 0x80;
		}
		/*
		 * 解析车辆状态标志位
		 */
		/**************** 解析车辆状态标志位，第四字节（大端模式，所以先传状态标志位的高位） *******************************************/
		// if ((Msgbody[4] & 0x01) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[4] & 0x02) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[4] & 0x04) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[4] & 0x08) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[4] & 0x10) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[4] & 0x20) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[4] & 0x40) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[4] & 0x80) == 0) {
		//
		// } else {
		//
		// }
		// /**************** 解析车辆状态标志位，第四字节（大端模式，所以先传状态标志位的高位）
		// *******************************************/
		// if ((Msgbody[5] & 0x01) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[5] & 0x02) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[5] & 0x04) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[5] & 0x08) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[5] & 0x10) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[5] & 0x20) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[5] & 0x40) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[5] & 0x80) == 0) {
		//
		// } else {
		//
		// }
		/**************** 解析车辆状态标志位，第二字节（大端模式，所以先传状态标志位的高位） *******************************************/
		// if ((Msgbody[6] & 0x01) == 0) {// 保留位，8
		//
		// } else {
		//
		// }
		// if ((Msgbody[6] & 0x02) == 0) {// 保留位，9
		//
		// } else {
		//
		// }
		if (gpsinfo.isNormalOil()) {// 车辆油路正常，10

		}
		if (gpsinfo.isElectricNormal()) {// 车辆电路正常,11
			info[6] |= 0x08;
		}
		if (gpsinfo.isDoorUnlock()) {// 车门解锁，12
			info[6] |= 0x10;
		}
		/** 第13-15位是保留位，不做处理 **/
		// if () {
		// info[6]|= 0x20;
		// }
		// if () {
		// info[6]|= 0x40;
		//
		// }
		// if ((Msgbody[6] & 0x80) == 0) {
		//
		// } else {
		//
		// }
		/**************** 解析车辆状态标志位，第一字节（大端模式） *******************************************/
		if (gpsinfo.isACCisOpen()) {// ACC关
			info[7] |= 0x01;
		}
		if (gpsinfo.isRegistering()) {// 未定位
			info[7] |= 0x02;
		}
		if (gpsinfo.getLatitudeStatus().equals("南纬")) {// 0北纬，1南纬
			info[7] |= 0x04;

		}
		if (gpsinfo.getLongtitudeStatus().equals("东经")) {// 0东经，1西经
			info[7] |= 0x08;
		}

		info[7] |= !gpsinfo.isOperations() ? 0x10 : 0x00;// 运营状态。0为运营，1为停运

		info[7] |= gpsinfo.isEncryption() ? 0x20 : 0x00;// 0表示经纬度未经保密插件加密，1表示经纬度已经有保密插件进行加密

		// /** 第6-7位是保留位，不做处理 **/
		// if ((Msgbody[7] & 0x40) == 0) {
		//
		// } else {
		//
		// }
		// if ((Msgbody[7] & 0x80) == 0) {
		//
		// } else {
		//
		// }
		DecimalFormat df1 = new DecimalFormat("####.000000");
		/*
		 * 解析纬度
		 */
		/************* 解析纬度 ***************************************************************/
		Double latitude = gpsinfo.getLatitude();
		int num = (int) (latitude * 1000000);
		byte[] nums = intToByteArray(num);
		info[8] = nums[0];
		info[9] = nums[1];
		info[10] = nums[2];
		info[11] = nums[3];
		/*
		 * 解析经度
		 */
		/************* 解析经度 ***************************************************************/
		double longitudeInt = gpsinfo.getLongtitude();
		num = (int) (longitudeInt * 1000000);
		nums = intToByteArray(num);
		info[12] = nums[0];
		info[13] = nums[1];
		info[14] = nums[2];
		info[15] = nums[3];

		/*
		 * 解析高度
		 */
		/************* 解析高度 ***************************************************************/
		int height = gpsinfo.getHeight();
		nums = int2bytes2(height);
		info[16] = nums[0];
		info[17] = nums[1];
		/*
		 * 解析速度
		 */
		/************* 解析速度 ***************************************************************/
		int speedint = (int) (gpsinfo.getSpeed() * 10);
		nums = int2bytes2(speedint);
		info[18] = nums[0];
		info[19] = nums[1];

		/*
		 * 解析方向
		 */
		/************* 解析方向 ***************************************************************/
		int directionint = gpsinfo.getDirection();
		nums = int2bytes2(directionint);
		info[20] = nums[0];
		info[21] = nums[1];

		/*
		 * 解析时间
		 */
		/************** 解析时间 ***************************************************************/
		DateFormat format1 = new SimpleDateFormat("yyMMddHHmmss");
		String format = format1.format(gpsinfo.getGpsTime());
		nums = str2Bcd(format);
		info[22] = nums[0];
		info[23] = nums[1];
		info[24] = nums[0];
		info[25] = nums[1];
		info[26] = nums[0];
		info[27] = nums[1];
		/*
		 * 解析协议的附加信息
		 */
		/************** 解析协议的附加信息 ******************************************************************/
//		if (Msgbody.length > 28) {
//			byte[] AdditionalMsg = new byte[Msgbody.length - 28];
//			for (int i = 0; i < Msgbody.length - 28; i++) {
//				AdditionalMsg[i] = Msgbody[i + 28];
//			}
//			judge(AdditionalMsg, gpsinfo);
//		}
//		String alarmCollection = gpsinfo.getAlarmCollection();
		
//		gpsinfo.isAlarmCollection(sb.toString());
		return info;

	}

}
