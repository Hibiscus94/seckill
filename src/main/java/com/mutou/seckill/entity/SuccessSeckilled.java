package com.mutou.seckill.entity;

import java.io.Serializable;
import java.util.Date;

public class SuccessSeckilled implements Serializable {
    /**
     * 商品id
     */
    private Long seckillId;

    /**
     * 电话
     */
    private Long userPhone;

    /**
     * 状态标识：-1：无效，0：成功，1：已付款
     */
    private Byte state;

    /**
     * 抢购成功时间
     */
    private Date createTime;

    /**
     * scekill 对象
     */
    private Seckill seckill;

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    /**
     * success_seckilled
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     * @return seckill_id 商品id
     */
    public Long getSeckillId() {
        return seckillId;
    }

    /**
     * 商品id
     * @param seckillId 商品id
     */
    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    /**
     * 电话
     * @return user_phone 电话
     */
    public Long getUserPhone() {
        return userPhone;
    }

    /**
     * 电话
     * @param userPhone 电话
     */
    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 状态标识：-1：无效，0：成功，1：已付款
     * @return state 状态标识：-1：无效，0：成功，1：已付款
     */
    public Byte getState() {
        return state;
    }

    /**
     * 状态标识：-1：无效，0：成功，1：已付款
     * @param state 状态标识：-1：无效，0：成功，1：已付款
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 抢购成功时间
     * @return create_time 抢购成功时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 抢购成功时间
     * @param createTime 抢购成功时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SuccessSeckilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ", seckill=" + seckill +
                '}';
    }
}