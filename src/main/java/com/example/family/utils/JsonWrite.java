package com.example.family.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wj
 * @date 2019/11/4
 * @desc 后台返回前台json格式
 */
@Data
@NoArgsConstructor
public class JsonWrite {
    /**
     * 状态码
     */
    private String code;
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 提示消息
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Object data;


    public JsonWrite(String code, boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }


    public JsonWrite(String code, boolean success, String msg, Object data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 自定义返回内容
     *
     * @param code
     * @param success
     * @param msg
     * @param data
     * @return
     */
    public static JsonWrite CUSTOMIZE(String code, boolean success, String msg, Object data) {
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode(code);
        jsonWrite.setSuccess(success);
        jsonWrite.setMsg(msg);
        jsonWrite.setData(data);
        return jsonWrite;
    }

    /**
     * 自定义返回内容
     *
     * @param code
     * @param success
     * @param msg
     * @return
     */
    public static JsonWrite CUSTOMIZE(String code, boolean success, String msg) {
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode(code);
        jsonWrite.setSuccess(success);
        jsonWrite.setMsg(msg);
        return jsonWrite;
    }

    /**
     * 操作成功，无数据传递
     *
     * @return
     */
    public static JsonWrite SUCCESS() {
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode("500");
        jsonWrite.setSuccess(true);
        jsonWrite.setMsg("");
        return jsonWrite;
    }

    /**
     * 操作成功，传递数据
     *
     * @return
     */
    public static JsonWrite SUCCESS(Object data) {
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode("500");
        jsonWrite.setSuccess(true);
        jsonWrite.setMsg("msg500");
        jsonWrite.setData(data);
        return jsonWrite;
    }

    /**
     * 操作失败，无数据传递
     *
     * @return
     */
    public static JsonWrite ERROR() {
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode("500");
        jsonWrite.setSuccess(false);
        jsonWrite.setMsg("mgsg500");
        return jsonWrite;
    }

    /**
     * 操作失败，传递数据
     *
     * @param data
     * @return
     */
    public static JsonWrite ERROR(Object data) {
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode("500");
        jsonWrite.setSuccess(false);
        jsonWrite.setMsg("msg500");
        jsonWrite.setData(data);
        return jsonWrite;
    }

    /**
     * 操作成功，自定义消息
     *
     * @param msg
     * @return
     */
    public static JsonWrite SUCCESS(String msg) {
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode("500");
        jsonWrite.setSuccess(true);
        jsonWrite.setMsg(msg);
        return jsonWrite;
    }

    /**
     * 操作成功，传递数据及自定义消息
     *
     * @param msg
     * @param data
     * @return
     */
    public static JsonWrite SUCCESS(String msg, Object data) {
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode("500");
        jsonWrite.setSuccess(true);
        jsonWrite.setMsg(msg);
        jsonWrite.setData(data);
        return jsonWrite;
    }

    /**
     * 操作失败，自定义消息
     *
     * @param msg
     * @return
     */
    public static JsonWrite ERROR(String msg) {
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode("500");
        jsonWrite.setSuccess(false);
        jsonWrite.setMsg(msg);
        return jsonWrite;
    }

    /**
     * 操作失败，传递数据以及自定义消息
     *
     * @param msg
     * @param data
     * @return
     */
    public static JsonWrite ERROR(String msg, Object data) {
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode("500");
        jsonWrite.setSuccess(false);
        jsonWrite.setMsg(msg);
        jsonWrite.setData(data);
        return jsonWrite;
    }

    /**
     * 系统错误
     */
    public static JsonWrite SYSTEMERROR(String msg,Object data){
        JsonWrite jsonWrite = new JsonWrite();
        jsonWrite.setCode("500");
        jsonWrite.setSuccess(false);
        jsonWrite.setMsg(msg);
        jsonWrite.setData(data);
        return jsonWrite;
    }
}
