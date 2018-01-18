package com.mutou.seckill.enums;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.seckill.enums <br>
 * 使用枚举标识 常量数据字段
 * @author mutou <br>
 * @version 1.0.0
 * @description todo <br>
 * @date 17/01/2018 <br>
 */
public enum SeckillStateEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private  int state;
    private String stateInfo;

    SeckillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStateEnum stateOf(int index){
        for (SeckillStateEnum stateEnum : values()){
            if (stateEnum.getState() == index){
                return stateEnum;
            }
        }
        return null;
    }
}
