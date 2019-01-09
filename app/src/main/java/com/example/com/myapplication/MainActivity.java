package com.example.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lib_core.utils.SpUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText phoneNumber;
    private EditText password;
    private CheckBox jizhu_cb;
    private TextView zhuce_tx;
    private TextView denglu_tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  getSupportActionBar().hide();//隐藏标题栏
        initView();

    }

    //找控件
    private void initView() {
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        password = (EditText) findViewById(R.id.password);
        jizhu_cb = (CheckBox) findViewById(R.id.jizhu_cb);
        zhuce_tx = (TextView) findViewById(R.id.zhuce_tx);
        denglu_tx = (TextView) findViewById(R.id.denglu_tx);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());//设置密码框隐藏数据
        zhuce_tx.setOnClickListener(this);
        denglu_tx.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhuce_tx:
                startActivity(new Intent(this, RegistActivity.class));
                break;
            case R.id.denglu_tx:
                String num = phoneNumber.getText().toString();
                String pass = password.getText().toString();
                SpUtils.getInstance().putSp("phone",num);
                SpUtils.getInstance().putSp("pwd",pass);

                break;
        }
    }
}
