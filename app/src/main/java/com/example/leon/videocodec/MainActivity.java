package com.example.leon.videocodec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText textUsrName;
    EditText textPwd;
    EditText textUID;

    Button buttonConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        textUsrName = findViewById(R.id.edit_usrname);
        textPwd = findViewById(R.id.edit_pwd);
        textUID = findViewById(R.id.edit_uid);

        buttonConnect = findViewById(R.id.buttonConnect);
        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usrname = textUsrName.getText().toString();
                String uid = textUID.getText().toString();
                String pwd = textPwd.getText().toString();
                if (TextUtils.isEmpty(usrname))
                {
                    Toast.makeText(getApplicationContext(),"用户名不能为空",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(pwd))
                {
                    Toast.makeText(getApplicationContext(),"密码不能为空",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(uid) || uid.length() != 8)
                {
                    Toast.makeText(getApplicationContext(),"UID错误",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //启动另一个显示界面,并将参数传递过去.
                    Intent intent = new Intent(MainActivity.this,CameraActivity.class);
                    intent.putExtra("usrname",usrname);
                    intent.putExtra("pwd",pwd);
                    intent.putExtra("uid",uid);
                    startActivity(intent);
                }
            }
        });
    }
}
