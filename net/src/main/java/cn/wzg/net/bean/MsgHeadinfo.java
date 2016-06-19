package cn.wzg.net.bean;


	/**
	 * 消息头对象
	 * @author 李戴维
	 *
	 */
	public class MsgHeadinfo {
		private int MsgId;//消息id
		private int MsgbodyLength;//消息体长度
		private int EncryptionMethod;//加密方式
		private boolean bag;//分包信息
		private String TerminalPhoneNum;//终端手机号
		private int Number;//流水号
		private int totalBagNum;//包总数 
		private int packageNumber;//包序号
		public int getMsgId() {
			return MsgId;
		}
		public void setMsgId(int msgId) {
			MsgId = msgId;
		}
		public int getMsgbodyLength() {
			return MsgbodyLength;
		}
		public void setMsgbodyLength(int msgbodyLength) {
			MsgbodyLength = msgbodyLength;
		}
		public int getEncryptionMethod() {
			return EncryptionMethod;
		}
		public void setEncryptionMethod(int encryptionMethod) {
			EncryptionMethod = encryptionMethod;
		}
		public String getTerminalPhoneNum() {
			return TerminalPhoneNum;
		}
		public void setTerminalPhoneNum(String terminalPhoneNum) {
			TerminalPhoneNum = terminalPhoneNum;
		}
		public int getNumber() {
			return Number;
		}
		public void setNumber(int number) {
			Number = number;
		}
		public void setTotalBagNum(int totalBagNum) {
			this.totalBagNum = totalBagNum;
		}
		public int getTotalBagNum() {
			return totalBagNum;
		}
		public void setPackageNumber(int packageNumber) {
			this.packageNumber = packageNumber;
		}
		public int getPackageNumber() {
			return packageNumber;
		}
		public void setBag(boolean bag) {
			this.bag = bag;
		}
		public boolean isBag() {
			return bag;
		}


	}


