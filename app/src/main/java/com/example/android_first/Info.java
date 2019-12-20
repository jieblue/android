package com.example.android_first;

public class Info {
    private String name;
    private String content;
    public Info(String one,String two)
    {
       this.name=one;
        this.content=two;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }
}
