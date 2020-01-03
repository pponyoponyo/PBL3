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

         findViewById(R.id.btnCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputUrl = input.getText().toString();

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
