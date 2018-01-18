package com.mutou.seckill.exception;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.seckill.exception <br>
 * 重复秒杀异常 运行时异常
 * @author mutou <br>
 * @version 1.0.0
 * @description todo <br>
 * @date 17/01/2018 <br>
 */
public class RepeatKillException extends SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
