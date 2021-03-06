package com.manba.simple.domain.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijin on 2017/10/28.
 * 兴趣枚举
 */
public enum InterestingEnum {

    COMIC(1, "动漫"),
    CARTOON(2, "漫画"),
    GAME(3, "游戏"),
    NOVEL(4, "小说"),
    COSPLAY(5, "cosplay"),
    FAN(6, "同人");

    InterestingEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private static final Map<Integer, YnEnum> map = new HashMap<Integer, YnEnum>();

    static {
        for (YnEnum t : YnEnum.values()) {
            map.put(t.getCode(), t);
        }
    }

    public static YnEnum idOf(Integer code) {
        return map.get(code);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(code).append(",").append(name).toString();
    }
}
