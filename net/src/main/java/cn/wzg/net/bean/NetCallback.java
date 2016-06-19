package cn.wzg.net.bean;

import cn.wzg.net.bean.responce.Response;




/**
 *
 * @author wangzhonggang
 * @since 2015-5-26
 * @version 0.1 
 * @description  这是一个专门用于网络响应回掉的接口
 */
public interface NetCallback {
	/**
	 * 该方法会在子线程运行
	 * @param response
	 */
	void onWorkThread(Response response);
	/**
	 * 该方法会在主线程运行
	 * @param response
	 */
	void onMainThread(Response response);
}
