package com.chengyu.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

//final修饰，禁止继承
public final class Latte {

    public static  Configurator init(Context context) {
        getCofigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private  static WeakHashMap<String, Object> getCofigurations() {
        return  Configurator.getInstance().getLatteConfigs();
    }


}
