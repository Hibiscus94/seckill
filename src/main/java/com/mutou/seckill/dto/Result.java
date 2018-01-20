package com.mutou.seckill.dto;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.seckill.dto <br>
 * 封装json结果
 *
 * @author mutou <br>
 * @version 1.0.0
 * @description reult <br>
 * @date 20/01/2018 <br>
 */
public class Result<T> {
    private boolean success;
    private T data;
    private String msg;

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
