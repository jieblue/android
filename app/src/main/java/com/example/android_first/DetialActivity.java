package com.example.android_first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetialActivity extends AppCompatActivity {
    private TextView tname;
    private TextView tcontent;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);

        tname=findViewById(R.id.dname);
        tcontent=findViewById(R.id.dcontent);
        button=findViewById(R.id.tv_back);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        tname.setText(bundle.getString("name"));
        tcontent.setText(bundle.getString("content"));
        System.out.println(tname.getText()+"  "+tcontent.getText());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
