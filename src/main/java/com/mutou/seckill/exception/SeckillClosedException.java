package com.mutou.seckill.exception;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.seckill.exception <br>
 *
 * @author mutou <br>
 * @version 1.0.0
 * @description todo <br>
 * @date 17/01/2018 <br>
 */
public class SeckillClosedException extends SeckillException{
    public SeckillClosedException(String message) {
        super(message);
    }

    public SeckillClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}
