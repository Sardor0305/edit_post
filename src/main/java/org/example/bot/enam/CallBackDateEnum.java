package org.example.bot.enam;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum CallBackDateEnum{
    CALLBACK_JOIN("join"),
    CALLBACK_DELETE("delete");
  private static final   Map<String,CallBackDateEnum> map = new HashMap<>();
    static {
        for (CallBackDateEnum c: CallBackDateEnum.values()) {
            map.put(c.val,c);

        }

    }

    String val;
    public static CallBackDateEnum of(String message){
        return map.get(message);
    }


}
