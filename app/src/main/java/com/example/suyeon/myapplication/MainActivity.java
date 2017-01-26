package com.example.suyeon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    //  MainActivity 가 TAG 로 됨(String 으로 변경)
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int QUANTITY_MIN = 0;
    public static final int QUANTITY_MAX = 10;
    public static final int COFFEE_PRICE = 3000;
    public static final int CHREME_PRICE = 500;

    private Button mMinusButton;
    private Button mPlusButton;
    private Button mOrderButton;
    private TextView mQuantityTextView;
    private TextView mResultTextView;
    private CheckBox mCreamCheckBox;
    private EditText mCommentEditText;

    //  수량데이터를 전역변수에 담아준다
    private int mQuantity;

    //  휘핑크림
    private boolean mIsCream;

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
        mOrderButton = (Button) findViewById(R.id.order_button);
        mQuantityTextView = (TextView) findViewById(R.id.quantity_text);
        mResultTextView = (TextView) findViewById(R.id.result_text);
        mCreamCheckBox = (CheckBox) findViewById(R.id.creme_check);
        mCommentEditText = (EditText) findViewById(R.id.comment_edit);

        mCreamCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mIsCream = isChecked;
                displayResult();
            }
        });
        //  무명클래스로 클릭 이벤트 처리
        //  마이너스, 플러스 버튼 수량 조정 내용
        mMinusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mQuantity--;
                if (mQuantity < QUANTITY_MIN) {
                    mQuantity = QUANTITY_MIN;
                }
                displayResult();
            }
        });

        mPlusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mQuantity++;
                if (mQuantity > QUANTITY_MAX) {
                    mQuantity = QUANTITY_MAX;
                }
                displayResult();
            }
        });

        // ORDER 버튼 토스트 메시지 구현 내용
        mOrderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String message = mResultTextView.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        // OrderCheckActivity 화면을 시작
        Intent intent = new Intent(this, ordercheckActivity.class);

        //데이터 담기
        intent.putExtra("result",message);
        intent.putExtra("comment", mCommentEditText.getText().toString());
        startActivity(intent);
    }

    // 결과 값 메시지 메소드로 뺌
    private void displayResult() {
        mQuantityTextView.setText("" + mQuantity);

        int total = COFFEE_PRICE * mQuantity;

        if (mIsCream) {
            total += CHREME_PRICE;
        }

        String result = String.format("가격 : %d원\n수량 : %d개\n휘핑크림 : %s\n감사합니다",
                mQuantity, mIsCream);
        mResultTextView.setText(result);
    }

    private void init() {
        mQuantity = 0;
    }
}

//  debug 모드로 출력
//                Log.d(TAG, "마이너스 버튼 클릭");
//                Log.v(TAG, "일반로그");
//                Log.e(TAG, "에러로그");
//                Log.i(TAG, "정보로그");
//                Log.w(TAG, "경고로그");
//
//                //  토스트 메시지
//                Toast.makeText(MainActivity.this,
//                        "메시지",
//                        Toast.LENGTH_SHORT).show();

//        Button button = (Button) findViewById(R.id.btn);
//        button.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        Toast.makeText(this, "버튼을 클릭하셨습니다.", Toast.LENGTH_SHORT).show();
