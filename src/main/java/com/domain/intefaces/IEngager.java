package com.domain.intefaces;

import java.util.Map;

public interface IEngager {// extends AutoCloseable
    void SendMessage(IMessage message);
    IMessage BuildMessage(Map<String, String> data);
    String Info();
}
