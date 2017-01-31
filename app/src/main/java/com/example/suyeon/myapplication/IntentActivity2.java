package com.example.suyeon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntentActivity2 extends AppCompatActivity implements View.OnClickListener {

    // 고객관리, 매출관리, 상품관리 button 을 레이아웃에서 불러옵니다.
    private Button mCustomer, mSales, mGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent2);

        // 레이아웃에 있는 버튼과 연결해줍니다.
        mCustomer = (Button) findViewById(R.id.customer_btn);
        mSales = (Button) findViewById(R.id.sales_btn);
        mGoods = (Button) findViewById(R.id.goods_btn);

        // 세가지 버튼을 누르면
        mCustomer.setOnClickListener(this);
        mSales.setOnClickListener(this);
        mGoods.setOnClickListener(this);

        // IntentActivity 의 Intent 를 불러옵니다. && id 와 password 를 불러옵니다.
        // && Toast 메시지로 id와 password 를 하단에 띄웁니다.
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("password");
        Toast.makeText(IntentActivity2.this,
                "ID : " + id + " , PW : " + pw, Toast.LENGTH_SHORT).show();

    }

        // 고객관리, 매출관리, 상품관리 버튼 내용 :
        // switch 문으로 버튼을 누르면 메뉴의 텍스트를 출력하면서 종료해 주는 조건을 만족시켜줍니다.
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.customer_btn:
                intent.putExtra("menu", mCustomer.getText().toString());
                break;
            case R.id.sales_btn:
                intent.putExtra("menu", mSales.getText().toString());
                break;
            case R.id.goods_btn:
                intent.putExtra("menu", mGoods.getText().toString());
                break;
        }

        setResult(RESULT_OK, intent);
        finish();
    }
}
