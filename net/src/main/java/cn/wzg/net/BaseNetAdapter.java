package cn.wzg.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import cn.wzg.net.bean.Api;
import cn.wzg.net.bean.Net.NetTask;
import cn.wzg.net.bean.NetCallback;
import cn.wzg.net.bean.request.Request;
import cn.wzg.net.bean.responce.Response;


public abstract class BaseNetAdapter implements cn.wzg.net.bean.Net.NetAdapter {

	private Request mRequest;
	private Response mResponse;
	private NetCallback mCallback;

	public BaseNetAdapter(Request request,Response response,NetCallback callback) {
		this.mRequest=request;
		this.mResponse=response;
		this.mCallback=callback;
	}
	
	
	@Override
	public byte[] getOutputBytes() throws IOException {
		return mRequest.getBytes();
	}

	@Override
	public SocketAddress getAddress() {
		return new InetSocketAddress(Api.HOST, Api.POT);
	}

	public abstract Response handle(InputStream is, NetTask task) throws IOException;


	@Override
	public void onWorkThread(Response response) {
		mCallback.onWorkThread(response);
	}


	@Override
	public void onMainThread(Response response) {
		mCallback.onMainThread(response);
	}

}
