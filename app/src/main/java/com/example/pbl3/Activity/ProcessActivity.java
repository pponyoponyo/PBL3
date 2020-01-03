package com.example.pbl3.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.pbl3.Method.EvidenceAc;
import com.example.pbl3.R;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import javax.xml.transform.Result;

public class ProcessActivity extends BaseActivity{

    private ImageView imgLoading;
    private Animation anim;

    public String inputUrl;
    public String inputHtml;

    private int percent;
    private String reason = "";
    private int total=0;
    private int trueNum=0;
    private float temp =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);

        JsoupAsyncTask jsoupHttp = new JsoupAsyncTask();
        jsoupHttp.execute();

        Intent i = getIntent();
        inputUrl = i.getExtras().getString("url");

        imgLoading = (ImageView) findViewById(R.id.img_loading);
        anim = AnimationUtils.loadAnimation(this, R.anim.loading);
        imgLoading.setAnimation(anim);

    }

    private  void check(){
        EvidenceAc evidenceAc = new EvidenceAc(inputUrl,inputHtml);

        if(evidenceAc.upperAuthority()){
            trueNum++;
            reason += "상위 권한 탈취 가능성이 있습니다.\n ";
        }
        count();

        if(evidenceAc.ChinaTld()){
            trueNum++;
            reason += "중국 웹페이지입니다.\n";
        }
        count();

        if(evidenceAc.RussiaTld()){
            trueNum++;
            reason += "러시아 웹페이지입니다.\n";
        }
        count();

        if(evidenceAc.javaExe()){
            trueNum++;
            reason += "위험한 java script 함수의 실행 가능성이 있습니다.\n";
        }
        count();

        if(evidenceAc.fastPage()){
            trueNum++;
            reason += "빠르게 제작된 웹페이지입니다.\n";
        }
        count();

        if(evidenceAc.urlKor()){
            trueNum++;
            reason += "url 에 한글이 들어가있습니다.\n";

        }
        count();

        // result();

        percent = 10;
        reason = inputHtml;

        Intent i = new Intent(getBaseContext(), ResultActivity.class);
        i.putExtra("resultPer",percent);
        i.putExtra("resultR",reason);
        startActivity(i);
        finish();

    }
    private void count(){
        total++;
    }

    private void result(){

        if(trueNum == 0 ){
            percent = 0;
            reason = "정상적인 URL 입니다.\n";
            return;
        }


        temp = (float)trueNum/(float)total;
        percent = (int)(temp*100);
    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {

                Connection url = Jsoup.connect(inputUrl);
                url.followRedirects(true);
                Document doc = url.get();
                inputHtml = doc.html(); // html 소스 긁어오기

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            check();

        }
    }
}
