package com.example.pbl3.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pbl3.R;


public class MainActivity extends BaseActivity {

    private EditText input;
    private String inputUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.edtInput);

        //공유 기능으로 url data 받기
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();


        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);    // 가져온 인텐트의 텍스트 정보
                inputUrl = sharedText;
                sendUrl();
            }
        }

         findViewById(R.id.btnCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputUrl = input.getText().toString();
                if(!inputUrl.contains("http")){
                    inputUrl= "http://"+inputUrl;
                }
                if(inputUrl.equals("")){
                    Toast.makeText(getApplicationContext(), "URL을 입력하세요.",Toast.LENGTH_SHORT).show();
                    return;
                }

                sendUrl();
            }
        });

    }
    public void sendUrl(){
        Intent i = new Intent(getBaseContext(), ProcessActivity.class);
        i.putExtra("url",inputUrl);
        startActivity(i);
        finish();
    }
}
