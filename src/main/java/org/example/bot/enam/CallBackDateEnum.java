package org.example.bot.enam;


import java.util.HashMap;
import java.util.Map;


public enum CallBackDateEnum {
    CALLBACK_JOIN("join"),
    CALLBACK_DELETE("delete");

    CallBackDateEnum(String val) {
        this.val = val;
    }

    private static final Map<String, CallBackDateEnum> map = new HashMap<>();

    static {
        for (CallBackDateEnum c : CallBackDateEnum.values()) {
            map.put(c.val, c);

        }

    }

    String val;

    public static CallBackDateEnum of(String message) {
        return map.get(message);
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
