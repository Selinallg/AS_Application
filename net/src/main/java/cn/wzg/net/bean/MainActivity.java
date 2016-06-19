package cn.wzg.net.bean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.wzg.net.BaseNetAdapter;
import cn.wzg.net.R;
import cn.wzg.net.bean.Net.NetTask;
import cn.wzg.net.bean.request.RegistRequest;
import cn.wzg.net.bean.request.Request;
import cn.wzg.net.bean.responce.RegistResponce;
import cn.wzg.net.bean.responce.Response;

public class MainActivity extends Activity {

	private TextView tv_resault;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ev_input = (EditText) findViewById(R.id.ev_input);
		tv_resault = (TextView) findViewById(R.id.tv_resault);
		iv_icon = (ImageView) findViewById(R.id.iv_icon);
		
	}

	private EditText ev_input;
	private ImageView iv_icon;

	private void setText(String text) {
		tv_resault.setText(text);
	}

	public void onClick(View v) {

		if(v.getId() == R.id.btn_check){

		}else if (v.getId() == R.id.btn_find){

		}else if (v.getId() == R.id.btn_conn){

		}else if (v.getId() == R.id.btn_send){

		}else if (v.getId() == R.id.btn_service){

			//bm.starService();

		}else if (v.getId() == R.id.btn_adv_test){

		}else {

		}


//		switch (v.getId()) {
//
//		case R.id.btn_check:
//			break;
//
//		case R.id.btn_find:
//			break;
//		case R.id.btn_conn:
//			break;
//
//		case R.id.btn_send:
//			break;
//		case R.id.btn_service:
//			break;
//		case R.id.btn_adv_test:
////			bm.starService();
//			break;
//		case R.id.btn_test:
//			test();
//			break;
//
//		default:
//			break;
//		}
	}

	private void test() {
		Net net = Net.getInsatnce();
		Request req =new RegistRequest();
		res = new RegistResponce();
		
		
		net.send(new BaseNetAdapter(req,res,call) {
			
			@Override
			public Response handle(InputStream is, NetTask task) throws IOException {
				ByteArrayOutputStream os =new ByteArrayOutputStream();
				byte[] buff=new byte[1024];
				int len =-1;
				while ((len=is.read(buff))!=-1){
					os.write(buff,0,len);
				}
				byte[] msg=os.toByteArray();
				res.paserData(msg);
				
				return res;
			}
		});
	}
		
		private NetCallback call=new NetCallback() {
			
			@Override
			public void onWorkThread(Response response) {
					
			}
			
			@Override
			public void onMainThread(Response response) {
				
				RegistResponce res =(RegistResponce) response;
				
				Toast.makeText(getApplicationContext(), res.msgId+res.toString(), 1).show();
			}
		};
		private Response res;

}

	
