package com.example.lizelu.customnavigationbar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by lizelu on 15/11/29.
 */
public class CustomNavigationBar extends FrameLayout {

    /*
     *创建回调接口
     */
    public static interface OnClickCallBackListener {
        public void OnClickButton(View v);
    }


    private OnClickCallBackListener callBackListener;            //声明接口对象

    public String navigationTitle = "标题栏";

    /*
     * 设置标题栏的标题
     */
    public void setNavigationTitle(String navigationTitle) {
        this.navigationTitle = navigationTitle;
        TextView textView = (TextView) findViewById(R.id.navigation_title);
        textView.setText(navigationTitle);
    }

    public void setCallBackListener(OnClickCallBackListener callBackListener) {
        this.callBackListener = callBackListener;
    }

    /*
     *自定义组件的构造方法
     */
    public CustomNavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_navigation, this);     //加载布局文件
        onClickBackButton();
        callBackButton();
    }
    /*
     * 点击返回按钮方法
     */
    private void onClickBackButton() {
        Button button = (Button) findViewById(R.id.back_button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }

    /*
     *点击按钮时执行接口回调
     */
    private void callBackButton() {
        Button button = (Button) findViewById(R.id.call_back);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBackListener != null) {
                    callBackListener.OnClickButton(v);
                }
            }
        });
    }
}
