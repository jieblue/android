package com.example.android_first;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Info> Data;//聊天数据
    private RecyclerView recyclerView;
    private InfoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data=new ArrayList<Info>();
        recyclerView=findViewById(R.id.tv_rview);
        adapter=new InfoAdapter(this,Data);//
        Data.add(new Info("lan","jie"));
        adapter.setItemClickListener(new InfoAdapter.OnItemClickListener() {//向DetailActivity传递信息
            @Override
            public void onLongClick(int Position) {
                Intent intent=new Intent(MainActivity.this,DetialActivity.class);
                Bundle bundle=new Bundle();
                String str2=Data.get(Position).getContent();
                String str1=Data.get(Position).getName();
                bundle.putString("name",str1);
                bundle.putString("content",str2);
                intent.putExtras(bundle);
               // System.out.println(str1+"   "+str2);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);//适配器扔进去
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
    @Override
    protected void onResume()
    {
        super.onResume();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//菜单
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){//菜单item的监听器
        if (item.getItemId()==R.id.tosend){
            Intent intent=new Intent(MainActivity.this,SendActivity.class);
            startActivityForResult(intent,0);
        }
        return true;
    }
    @Override
    protected void onActivityResult(int rqd,int rsd,Intent intent) {//接受从SENDACTIVITY返回的消息
        // super.onActivityResult(rqd, rsd, intent);

        if (intent != null) {
            Bundle bundle=intent.getExtras();
            String str1 = bundle.getString("name");
            String str2 = bundle.getString("content");
            Data.add(new Info(str1,str2));
          //  System.out.println(adapter.getItemCount());
           // System.out.println(Data.get(2).getName()+""+Data.get(2).getContent());
        }
    }
}
