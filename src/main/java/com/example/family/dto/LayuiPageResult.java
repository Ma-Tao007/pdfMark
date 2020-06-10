package com.example.family.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LayuiPageResult {
    private Integer code = 0;//默认值为0  不然页面不渲染数据
    private String msg;
    private int count;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
