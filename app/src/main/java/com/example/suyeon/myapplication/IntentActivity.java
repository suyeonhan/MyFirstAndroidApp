package com.example.suyeon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    // 아이디, 패스워드 EditText 와 로그인 Button 을 레이아웃에서 불러옵니다.
    private EditText mID, mPW;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        // 레이아웃에 있는 텍스트, 버튼과 연결해 줍니다.
        mID = (EditText) findViewById(R.id.id);
        mPW = (EditText) findViewById(R.id.pw);
        mLogin = (Button) findViewById(R.id.login);

        // 로그인 버튼을 누르면
        mLogin.setOnClickListener(this);
    }


        // 로그인 버튼 내용 : intent 로 IntentActivity 1과 2를 연결합니다.
        // && 화면에서 id 와 password 부분에 아이디와 비밀번호를 입력해줍니다.
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(IntentActivity.this, IntentActivity2.class);
        intent.putExtra("id", mID.getText().toString());
        intent.putExtra("password", mPW.getText().toString());

        startActivityForResult(intent, 1000);
    }

        // IntentActivity 화면에 IntentActivity2 에서 지정한 결과를 Toast 메시지로 출력해 줍니다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000 && resultCode == RESULT_OK && data != null) {
            Toast.makeText(IntentActivity.this, data.getStringExtra("menu"),
                    Toast.LENGTH_SHORT).show();
        }
    }
}