package com.mutou.seckill.dto;

import com.mutou.seckill.entity.SuccessSeckilled;
import com.mutou.seckill.enums.SeckillStateEnum;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.seckill.dto <br>
 *
 * @author mutou <br>
 * @version 1.0.0
 * @description todo <br>
 * @date 17/01/2018 <br>
 */
public class SeckillExecution {
    private long seckillId;
    private int state;
    private String stateInfo;
    private SuccessSeckilled successSeckilled;

    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum, SuccessSeckilled successSeckilled) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
        this.successSeckilled = successSeckilled;
    }

    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessSeckilled getSuccessSeckilled() {
        return successSeckilled;
    }

    public void setSuccessSeckilled(SuccessSeckilled successSeckilled) {
        this.successSeckilled = successSeckilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successSeckilled=" + successSeckilled +
                '}';
    }
}
