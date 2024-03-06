package com.service;

import starter.Speaker;

public class SpeakerSerivce implements Speaker {
    private String name;
    private String name2;

    @Override
    public String say(String content) {
        return String.format("name:%s,name1:%s says %s", name, name2, content);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}