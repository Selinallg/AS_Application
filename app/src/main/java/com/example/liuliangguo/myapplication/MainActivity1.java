package com.example.liuliangguo.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import java.io.IOException;
import java.io.InputStream;
import cn.wzg.net.BaseNetAdapter;
import cn.wzg.net.LogUtils;
import cn.wzg.net.bean.Net;
import cn.wzg.net.bean.responce.Response;


public class MainActivity1 extends Activity {


    private Button btnTest0;
    private Button btnTest1;
    private Button btnTest;
    private Button btnTest2;

    private void assignViews() {
        btnTest0 = (Button) findViewById(R.id.btn_test0);
        btnTest1 = (Button) findViewById(R.id.btn_test1);
        btnTest = (Button) findViewById(R.id.btn_test);
        btnTest2 = (Button) findViewById(R.id.btn_test2);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.acitvity_main_activity1);
      //  setContentView(android.R.layout.activity_main_activity1);
        setContentView(R.layout.activity_main_activity1);
        Button button = (Button) findViewById(R.id.btn_test);

        LogUtils.d("haha");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity1, menu);
        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
