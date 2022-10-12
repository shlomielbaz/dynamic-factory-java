package com.engages.Klaviyo;

import com.domain.intefaces.IMessage;
import com.domain.intefaces.IEngager;

import java.util.Map;

public class Main implements IEngager {
    private final String type = "KLAVIYO";

    @Override
    public void SendMessage(IMessage message) {
        System.out.println("SendMessage for " + type + " was called");
    }

    @Override
    public IMessage BuildMessage(Map<String, String> data) {
        try {
            System.out.println("BuildMessage for " + type + " was called");
            return new Message();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String Info() {
        return this.type;
    }
}
