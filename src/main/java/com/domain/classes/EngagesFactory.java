package com.domain.classes;

import com.domain.intefaces.IEngager;
import org.reflections.Reflections;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EngagesFactory {
    private static final Map<String, IEngager> CACHE = new HashMap<>();

    public static IEngager get(Map<String, String> message) throws Exception {
        if (message.containsKey("type")) {
            String type = message.get("type");
            if (!CACHE.containsKey(type)) {
                Reflections reflections = new Reflections("com.engages");
                Set<Class<? extends IEngager>> classes = reflections.getSubTypesOf(IEngager.class);
                for (Class<? extends IEngager> cls : classes) {

                    IEngager instance = cls.getDeclaredConstructor().newInstance();
                    String info = instance.Info();

                    if (info.equals(type)) {
                        System.out.println("Build cache handler for engager " + type + " on " + new Date());
                        CACHE.put(info, instance);
                    }
                }
            }

            if (CACHE.containsKey(type) && CACHE.get(type) != null) {
                return CACHE.get(type);
            }
        }
        return null;
    }
}
