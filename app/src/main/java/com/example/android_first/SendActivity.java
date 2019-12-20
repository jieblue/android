package com.example.android_first;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendActivity extends AppCompatActivity {
    private EditText ename;
    private EditText econtent;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        ename=findViewById(R.id.sname);
        econtent=findViewById(R.id.scontent);
        button=findViewById(R.id.tv_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1=ename.getEditableText().toString();
                String str2=econtent.getEditableText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("name",str1);
                bundle.putString("content",str2);
                Intent intent=new Intent(SendActivity.this,MainActivity.class);
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
