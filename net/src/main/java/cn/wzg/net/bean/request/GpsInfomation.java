package cn.wzg.net.bean.request;

import java.util.Date;

/**
 * Gps回传信息对象类
 *
 * @author 李戴维
 */
public class GpsInfomation {
    private int ResponseId;//应答id
    private int Num;//应答流水号
    private byte result;//应答结果
    private String RoadDriveTimeIllegalAdditional;
    private String TurnoverAdditional;
    private String OverSpeedAdditional;
    private double speedAquare;// 行驶记录功能获取的速度
    private double Oil;// 油量
    private double Mileage = 0;// 里程
    private int height = 0;
    private double Speed = 0;// 车速
    private int Direction = 0;// 方向角
    private Date GpsTime;// gps时间
    private double Latitude = 0;// 纬度
    private double Longtitude = 0;// 经度 Longitude
    private boolean ACCisOpen;// 0-ACC关-false;1-ACC开-true
    private boolean isRegistering;// 是否定位，0代表未定位false;
    private String latitudeStatus;// 0代表北纬，1代表南纬
    private String longtitudeStatus;// 0代表东经，1代表西经
    private boolean isOperations;// 是否运营，0运营状态，true
    private boolean isEncryption;// 0代表未经加密false,1代表加密true
    private boolean isNormalOil;// 油路是否正常，0为正常，true
    private boolean isElectricNormal;// 电路是否正常
    private boolean isDoorUnlock;// 是否车门解锁
    private boolean isEmergencyAlarm;// 紧急报警
    private boolean isOverSpeedAlarm;// 超速报警
    private boolean isTiredAlarm;// 疲劳驾驶报警
    private boolean isPreventionAlarm;// 预警
    private boolean isGNSSError;
    private boolean isGNSSCutoff;// GNSS天线未接或者短路
    private boolean isGNSSShortcircuit;// GNSS天线短路
    private boolean isMainsUndervoltage;// 主电压欠压
    private boolean isMainPowerloss;// 主电压掉电
    private boolean isLCDError;// lcd或者显示器故障
    private boolean isTTSError;// TTS模块故障
    private boolean isCameraError;// 摄像头故障
    private boolean isDriveOvertime;// 当天累计驾驶超时
    private boolean isStopOvertime;// 超市停车
    private boolean isTurnoverArea;// 进出区域
    private boolean isTurnoverRoad;// 进出路线
    private boolean isRoadDriveTimeIllegal;// 路段行驶时间不足或过长
    private boolean isYawAlarm;// 是否偏航报警
    private boolean isVSSError;// vss故障
    private boolean isFuelAbnormal;// 油量异常
    private boolean isCarStolen;// 车辆被盗
    private boolean isCarIllegalIgnition;// 非法点火
    private boolean isCarIllegalDisplacement;// 非法位移
    private boolean isRolloverAlarm;// 侧翻报警

    private boolean isICcardError; //道路运输证ic卡模块故障
    private boolean isOverSpeedPrevetion; //超速预警
    private boolean isTiredDrivePretion; //疲劳驾驶预警
    private boolean isRolloverPrevetion; //侧翻预警
    private boolean isIllegeOpenDoor; //非法开门


    private int Status;
    private int Alarm;

    private String AlarmCollection; //报警集合字符串 以逗号分隔

    public String getAlarmCollection() {
        return AlarmCollection;
    }

    public void setAlarmCollection(String alarmCollection) {
        AlarmCollection = alarmCollection;
    }

    public int getDirection() {
        return Direction;
    }

    public void setDirection(int direction) {
        Direction = direction;
    }

    public Date getGpsTime() {
        return GpsTime;
    }

    public void setGpsTime(Date gpsTime) {
        GpsTime = gpsTime;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongtitude() {
        return Longtitude;
    }

    public void setLongtitude(double longtitude) {
        Longtitude = longtitude;
    }

    public boolean isACCisOpen() {
        return ACCisOpen;
    }

    public void setACCisOpen(boolean aCCisOpen) {
        ACCisOpen = aCCisOpen;
    }

    public boolean isRegistering() {
        return isRegistering;
    }

    public void setRegistering(boolean isRegistering) {
        this.isRegistering = isRegistering;
    }

    public String getLatitudeStatus() {
        return latitudeStatus;
    }

    public void setLatitudeStatus(String latitudeStatus) {
        this.latitudeStatus = latitudeStatus;
    }

    public String getLongtitudeStatus() {
        return longtitudeStatus;
    }

    public void setLongtitudeStatus(String longtitudeStatus) {
        this.longtitudeStatus = longtitudeStatus;
    }

    public boolean isOperations() {
        return isOperations;
    }

    public void setOperations(boolean isOperations) {
        this.isOperations = isOperations;
    }

    public boolean isEncryption() {
        return isEncryption;
    }

    public void setEncryption(boolean isEncryption) {
        this.isEncryption = isEncryption;
    }

    public boolean isNormalOil() {
        return isNormalOil;
    }

    public void setNormalOil(boolean isNormalOil) {
        this.isNormalOil = isNormalOil;
    }

    public boolean isElectricNormal() {
        return isElectricNormal;
    }

    public void setElectricNormal(boolean isElectricNormal) {
        this.isElectricNormal = isElectricNormal;
    }

    public boolean isDoorUnlock() {
        return isDoorUnlock;
    }

    public void setDoorUnlock(boolean isDoorUnlock) {
        this.isDoorUnlock = isDoorUnlock;
    }

    public boolean isEmergencyAlarm() {
        return isEmergencyAlarm;
    }

    public void setEmergencyAlarm(boolean isEmergencyAlarm) {
        this.isEmergencyAlarm = isEmergencyAlarm;
    }

    public boolean isOverSpeedAlarm() {
        return isOverSpeedAlarm;
    }

    public void setOverSpeedAlarm(boolean isOverSpeedAlarm) {
        this.isOverSpeedAlarm = isOverSpeedAlarm;
    }

    public boolean isTiredAlarm() {
        return isTiredAlarm;
    }

    public void setTiredAlarm(boolean isTiredAlarm) {
        this.isTiredAlarm = isTiredAlarm;
    }

    public boolean isPreventionAlarm() {
        return isPreventionAlarm;
    }

    public void setPreventionAlarm(boolean isPreventionAlarm) {
        this.isPreventionAlarm = isPreventionAlarm;
    }

    public boolean isGNSSError() {
        return isGNSSError;
    }

    public void setGNSSError(boolean isGNSSError) {
        this.isGNSSError = isGNSSError;
    }

    public boolean isGNSSCutoff() {
        return isGNSSCutoff;
    }

    public void setGNSSCutoff(boolean isGNSSCutoff) {
        this.isGNSSCutoff = isGNSSCutoff;
    }

    public boolean isGNSSShortcircuit() {
        return isGNSSShortcircuit;
    }

    public void setGNSSShortcircuit(boolean isGNSSShortcircuit) {
        this.isGNSSShortcircuit = isGNSSShortcircuit;
    }

    public boolean isMainsUndervoltage() {
        return isMainsUndervoltage;
    }

    public void setMainsUndervoltage(boolean isMainsUndervoltage) {
        this.isMainsUndervoltage = isMainsUndervoltage;
    }

    public boolean isMainPowerloss() {
        return isMainPowerloss;
    }

    public void setMainPowerloss(boolean isMainPowerloss) {
        this.isMainPowerloss = isMainPowerloss;
    }

    public boolean isLCDError() {
        return isLCDError;
    }

    public void setLCDError(boolean isLCDError) {
        this.isLCDError = isLCDError;
    }

    public boolean isTTSError() {
        return isTTSError;
    }

    public void setTTSError(boolean isTTSError) {
        this.isTTSError = isTTSError;
    }

    public boolean isCameraError() {
        return isCameraError;
    }

    public void setCameraError(boolean isCameraError) {
        this.isCameraError = isCameraError;
    }

    public boolean isDriveOvertime() {
        return isDriveOvertime;
    }

    public void setDriveOvertime(boolean isDriveOvertime) {
        this.isDriveOvertime = isDriveOvertime;
    }

    public boolean isStopOvertime() {
        return isStopOvertime;
    }

    public void setStopOvertime(boolean isStopOvertime) {
        this.isStopOvertime = isStopOvertime;
    }

    public boolean isTurnoverArea() {
        return isTurnoverArea;
    }

    public void setTurnoverArea(boolean isTurnoverArea) {
        this.isTurnoverArea = isTurnoverArea;
    }

    public boolean isTurnoverRoad() {
        return isTurnoverRoad;
    }

    public void setTurnoverRoad(boolean isTurnoverRoad) {
        this.isTurnoverRoad = isTurnoverRoad;
    }

    public boolean isRoadDriveTimeIllegal() {
        return isRoadDriveTimeIllegal;
    }

    public void setRoadDriveTimeIllegal(boolean isRoadDriveTimeIllegal) {
        this.isRoadDriveTimeIllegal = isRoadDriveTimeIllegal;
    }

    public boolean isYawAlarm() {
        return isYawAlarm;
    }

    public void setYawAlarm(boolean isYawAlarm) {
        this.isYawAlarm = isYawAlarm;
    }

    public boolean isVSSError() {
        return isVSSError;
    }

    public void setVSSError(boolean isVSSError) {
        this.isVSSError = isVSSError;
    }

    public boolean isFuelAbnormal() {
        return isFuelAbnormal;
    }

    public void setFuelAbnormal(boolean isFuelAbnormal) {
        this.isFuelAbnormal = isFuelAbnormal;
    }

    public boolean isCarStolen() {
        return isCarStolen;
    }

    public void setCarStolen(boolean isCarStolen) {
        this.isCarStolen = isCarStolen;
    }

    public boolean isCarIllegalIgnition() {
        return isCarIllegalIgnition;
    }

    public void setCarIllegalIgnition(boolean isCarIllegalIgnition) {
        this.isCarIllegalIgnition = isCarIllegalIgnition;
    }

    public boolean isCarIllegalDisplacement() {
        return isCarIllegalDisplacement;
    }

    public void setCarIllegalDisplacement(boolean isCarIllegalDisplacement) {
        this.isCarIllegalDisplacement = isCarIllegalDisplacement;
    }

    public boolean isRolloverAlarm() {
        return isRolloverAlarm;
    }

    public void setRolloverAlarm(boolean isRolloverAlarm) {
        this.isRolloverAlarm = isRolloverAlarm;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setMileage(int mileage) {
        Mileage = mileage;
    }

    public void setOverSpeedAdditional(String overSpeedAdditional) {
        OverSpeedAdditional = overSpeedAdditional;
    }

    public String getOverSpeedAdditional() {
        return OverSpeedAdditional;
    }

    public void setTurnoverAdditional(String turnoverAdditional) {
        TurnoverAdditional = turnoverAdditional;
    }

    public String getTurnoverAdditional() {
        return TurnoverAdditional;
    }

    public void setRoadDriveTimeIllegalAdditional(
            String roadDriveTimeIllegalAdditional) {
        RoadDriveTimeIllegalAdditional = roadDriveTimeIllegalAdditional;
    }

    public String getRoadDriveTimeIllegalAdditional() {
        return RoadDriveTimeIllegalAdditional;
    }

    public void setSpeedAquare(double speedAquare) {
        this.speedAquare = speedAquare;
    }

    public double getSpeedAquare() {
        return speedAquare;
    }

    public void setOil(double oil) {
        Oil = oil;
    }

    public double getOil() {
        return Oil;
    }

    public void setMileage(double mileage) {
        Mileage = mileage;
    }

    public double getMileage() {
        return Mileage;
    }

    public void setSpeed(double speed) {
        Speed = speed;
    }

    public double getSpeed() {
        return Speed;
    }

    public void setResponseId(int responseId) {
        ResponseId = responseId;
    }

    public int getResponseId() {
        return ResponseId;
    }

    public void setNum(int num) {
        Num = num;
    }

    public int getNum() {
        return Num;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public byte getResult() {
        return result;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getStatus() {
        return Status;
    }

    public void setAlarm(int alarm) {
        Alarm = alarm;
    }

    public int getAlarm() {
        return Alarm;
    }

    public boolean isICcardError() {
        return isICcardError;
    }

    public void setICcardError(boolean isICcardError) {
        this.isICcardError = isICcardError;
    }

    public boolean isOverSpeedPrevetion() {
        return isOverSpeedPrevetion;
    }

    public void setOverSpeedPrevetion(boolean isOverSpeedPrevetion) {
        this.isOverSpeedPrevetion = isOverSpeedPrevetion;
    }

    public boolean isTiredDrivePretion() {
        return isTiredDrivePretion;
    }

    public void setTiredDrivePretion(boolean isTiredDrivePretion) {
        this.isTiredDrivePretion = isTiredDrivePretion;
    }

    public boolean isRolloverPrevetion() {
        return isRolloverPrevetion;
    }

    public void setRolloverPrevetion(boolean isRolloverPrevetion) {
        this.isRolloverPrevetion = isRolloverPrevetion;
    }

    public boolean isIllegeOpenDoor() {
        return isIllegeOpenDoor;
    }

    public void setIllegeOpenDoor(boolean isIllegeOpenDoor) {
        this.isIllegeOpenDoor = isIllegeOpenDoor;
    }


}
