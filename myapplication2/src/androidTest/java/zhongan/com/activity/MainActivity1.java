package zhongan.com.activity;

import android.app.Activity;
import android.app.backup.BackupAgent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import zhongan.com.myapplication.BuildConfig;
import zhongan.com.myapplication.MainActivity;
import zhongan.com.myapplication.R;


public class MainActivity1 extends Activity {


    private Button btnTest0;
    private Button btnTest1;
    private Button btnTest2;

    private void assignViews() {
        btnTest0 = (Button) findViewById(R.id.btn_test0);
        btnTest1 = (Button) findViewById(R.id.btn_test1);
        btnTest2 = (Button) findViewById(R.id.btn_test2);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1);
        Button button1 = (Button) findViewById(R.id.btn_test1);

        Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show();
        if (BuildConfig.DEBUG) Log.d("MainActivity1", "heh");

    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private class MinaAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View inflate = View.inflate(MainActivity1.this, R.layout.list_item, null);
            return inflate;
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }
    }



}
