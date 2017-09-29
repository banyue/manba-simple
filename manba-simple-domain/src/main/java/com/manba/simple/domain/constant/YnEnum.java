package com.manba.simple.domain.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 逻辑删除标识
 * Created by lijin on 2017/9/29.
 */
public enum YnEnum {
    YES(0, "有效"),
    NO(1, "无效");

    YnEnum(Integer code, String name) {
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