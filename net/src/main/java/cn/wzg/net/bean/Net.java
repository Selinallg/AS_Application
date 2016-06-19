package cn.wzg.net.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

import android.os.AsyncTask;
import cn.wzg.net.IOUtils;
import cn.wzg.net.LogUtils;
import cn.wzg.net.bean.responce.Response;

/**
 * 
 * 这是一个网络连接类，用于管理所有的外发链接及响应
 * 
 * @author wangzhonggang
 * 
 */
public class Net {

	private static final Net sInstance = new Net();

	private static final int DEF_TIMEOUT = 30000;

	/**
	 * 防止实例化
	 */
	private Net() {
		/** nothing **/
	}

	/**
	 * 获取唯一实例
	 */
	public static Net getInsatnce() {
		return sInstance;
	}

	/**
	 * 该方法内部的实现会被运行到子线程上
	 * 
	 * @param req
	 */
	public void send(NetAdapter data) {
		NetTask netTask = new NetTask();
		netTask.execute(data);

	}

	private static Socket connect(SocketAddress peer, int timeout)
			throws IOException {
		// LogUtils.i(Net.class, "Socket: " + host + ":" + port + ",timeout:"
		// + timeout);
		// SocketAddress peer = address;
		if (timeout <= 0) {
			timeout = DEF_TIMEOUT;
		}
		Socket socket = new Socket();
		socket.connect(peer, timeout);
		return socket;
	}

	static Socket connect(SocketAddress address) throws IOException {
		return connect(address, DEF_TIMEOUT);
	}

	/**
	 * 该接口标注了Net类需要的实现 里面的方法除特殊情况，一般运行在子线程中
	 * 
	 * @author wzg
	 * 
	 */
	public static interface NetAdapter extends NetCallback {
		/**
		 * 需要一个输入流
		 * 
		 * @return
		 * @throws IOException
		 */
		byte[] getOutputBytes() throws IOException;

		/**
		 * 需要一个地址
		 * 
		 * @return
		 */
		SocketAddress getAddress();

		/**
		 * 需要处理输入流
		 * 
		 * @param is
		 * @throws IOException
		 */
		Response handle(InputStream is, NetTask task) throws IOException;

	}

	public static class NetTask extends
			AsyncTask<NetAdapter, Integer, Response> {

		private NetAdapter mNetAdapter;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Response doInBackground(NetAdapter... params) {
			this.mNetAdapter = params[0];
			OutputStream os = null;
			InputStream is = null;
			Socket socket = null;
			try {
				socket = connect(mNetAdapter.getAddress());

				// socket.setKeepAlive(true);
//				 =socket.isInputShutdown();

//				LogUtils.d("当前状态：socket.isInputShutdown()："
//						+ socket.isInputShutdown()
//						+ "\nsocket.isOutputShutdown()"
//						+ socket.isOutputShutdown() + "\nsocket.isConnected()"
//						+ socket.isConnected() + "\nsocket.isClosed()"
//						+ socket.isClosed());
				os = socket.getOutputStream();
				os.write(params[0].getOutputBytes());
				os.flush();
				IOUtils.close(os);
//				LogUtils.d("当前状态：socket.isInputShutdown()："
//						+ socket.isInputShutdown()
//						+ "\nsocket.isOutputShutdown()"
//						+ socket.isOutputShutdown() + "\nsocket.isConnected()"
//						+ socket.isConnected() + "\nsocket.isClosed()"
//						+ socket.isClosed());
				is = socket.getInputStream();
//				LogUtils.d("可读数据" + is.available());
				Response response = mNetAdapter.handle(is, this);
				mNetAdapter.onWorkThread(response);
				return response;

			} catch (IOException e) {
//				LogUtils.e(e);
				e.printStackTrace();

			} finally {
				IOUtils.close(os);
				IOUtils.close(is);
				IOUtils.close(socket);
			}
			return null;
		}

		public void updataProcess(Integer process) {
			publishProgress(process);
		}

		@Override
		protected void onPostExecute(final Response result) {

			// TODO
			LogUtils.d("开始投递结果");

			mNetAdapter.onMainThread(result);

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO 进度处理
			LogUtils.d("更新进度为" + values[0].intValue());
		}

	}

}
