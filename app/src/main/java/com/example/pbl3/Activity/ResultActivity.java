package com.example.pbl3.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pbl3.Method.EvidenceAc;
import com.example.pbl3.R;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ResultActivity extends BaseActivity {

    Handler handler = new Handler() ; // Thread에서 화면에 그리기 위해 필요
    private TextView txtResult;
    private TextView txtReason;
    private boolean compResult =false;

    private int testNum=9; // 연동 전 임의로 테스트 넘버 넣음
    private int value=0;
    private ProgressBar progressBar;
    private int add=5; // 증가량, 방향

    private int percent;
    private String reason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = findViewById(R.id.txtResult);
        txtReason = findViewById(R.id.txtReason);

        Intent i = getIntent();
        percent = i.getIntExtra("resultPer",0);
        reason = i.getStringExtra("resultR");

        txtResult.setText(percent+"%");
        txtReason.setText(reason);

        // 약간 수정 필요함!!
        final ProgressBar progressBar=findViewById(R.id.progress_circular1);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(value<= percent){
                    value=value+add;
                    if(value>100 || value<0){
                        add=-add;
                        break;

                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(value);
                        }
                    });
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e){}
                }

            }
        });
        t.start();

        // todo 리턴되는 true 개수를 progressBar.setProgress(trueNum) 해주기


        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        findViewById(R.id.btnOff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
