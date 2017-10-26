package com.manba.simple.domain.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijin on 2017/10/24.
 * 业务类型枚举
 */
public enum BusiTypeEnum {

    USER_PHOTO(1, "用户头像"),
    ZONE(2, "动态图片"),
    GUILD(3, "公会图片");

    BusiTypeEnum(Integer code, String name) {
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
