package com.manba.simple.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by lijin on 2017/10/3.
 */
public class StringUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 校验对象是否为空
     * @param param
     * @return
     */
    public static boolean isEmpty(Object param){
        if(param == null){
            return true;
        } else if(param instanceof String){
            return "".equals((String)param);
        } else if(param instanceof List){
            return ((List)param).size() == 0;
        } else if(param instanceof Long){
            return (Long)param <= 0l;
        }
        return false;
    }

    /**
     * 校验一组对象是否为空
     * @param param
     * @return
     */
    public static String checkEmpty(Map<String, Object> param) {
        if(null == param) {
            return "参数不能为空！";
        }
        for (Map.Entry<String, Object> map : param.entrySet()) {
            if (isEmpty(map.getValue())) {
                LOGGER.info("{}不能为空！", map.getKey());
                return String.format(String.format("[%s]不能为空！",map.getKey()));
            }
        }
        return "";
    }

}
