package com.pinyougou.entity;

/**
 * @program: pinyougou_parent
 * @description: 处理返回结果的类
 * @author: YF
 * @create: 2018-07-06 21:38
 **/
public class Result {
    //返回是否成功
    private boolean success;
    //返回的消息
    private String message;
    //获取有参构造
    public Result(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
