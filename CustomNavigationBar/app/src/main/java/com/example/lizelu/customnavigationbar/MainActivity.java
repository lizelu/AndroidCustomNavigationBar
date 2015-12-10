package com.example.lizelu.customnavigationbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNavigationTitle("首页");
    }

    private void setNavigationTitle(String title) {
        CustomNavigationBar navigationBar = (CustomNavigationBar) findViewById(R.id.custom_navigation_bar);
        navigationBar.setNavigationTitle(title);

        //实现组件上的按钮的接口回调
        navigationBar.setCallBackListener(new CustomNavigationBar.OnClickCallBackListener() {
            @Override
            public void OnClickButton(View v) {
                Toast.makeText(MainActivity.this, "回调执行的方法", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
