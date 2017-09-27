package com.manba.simple.domain.page;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijin on 2017/9/27.
 */
public class Criteria {

    private Map<String, Object> extFields;

    public Criteria() {
    }

    public Criteria addExtField(String fieldName, Object filedValue) {
        if(this.extFields == null) {
            this.extFields = new HashMap();
        }

        this.extFields.put(fieldName, filedValue);
        return this;
    }

    public Map<String, Object> getExtFields() {
        return this.extFields;
    }

    public void setExtFields(Map<String, Object> extFields) {
        this.extFields = extFields;
    }
}
