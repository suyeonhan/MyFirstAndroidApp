package com.example.suyeon.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //  MainActivity 가 TAG 로 됨(String 으로 변경)
    private static final String TAG = MainActivity.class.getSimpleName();

    private Button mMinusButton;
    private Button mPlusButton;
    private TextView mQuantityTextView;
    private TextView mResultTextView;

    //  수량데이터를 전역변수에 담아준다
    private int mQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  초기화 메소드
        init();

        //  레이아웃 표시
        setContentView(R.layout.coffee_order_layout);

        //  레이아웃에서 특정 id를 인스턴스 변수와 연결
        mMinusButton = (Button) findViewById(R.id.minus_button);
        mPlusButton = (Button) findViewById(R.id.plus_button);
        mQuantityTextView = (TextView) findViewById(R.id.quantity_text);
        mResultTextView = (TextView) findViewById(R.id.result_text);

        //  무명클래스로 클릭 이벤트 처리
        mMinusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  debug 모드로 출력
                Log.d(TAG, "마이너스 버튼 클릭");
                Log.v(TAG, "일반로그");
                Log.e(TAG, "에러로그");
                Log.i(TAG, "정보로그");
                Log.w(TAG, "경고로그");

                //  토스트 메시지
                Toast.makeText(MainActivity.this,
                        "메시지",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void init() {
        mQuantity = 0;
    }
}


//        Button button = (Button) findViewById(R.id.btn);
//        button.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        Toast.makeText(this, "버튼을 클릭하셨습니다.", Toast.LENGTH_SHORT).show();
