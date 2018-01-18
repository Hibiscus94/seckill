package com.mutou.seckill.entity;

import java.io.Serializable;
import java.util.Date;

public class Seckill implements Serializable {
    /**
     * 商品id
     */
    private Long seckillId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品库存
     */
    private Integer number;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 技术时间
     */
    private Date endTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * seckill
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
     * 商品名称
     * @return name 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 商品名称
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 商品库存
     * @return number 商品库存
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 商品库存
     * @param number 商品库存
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 开始时间
     * @return start_time 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 技术时间
     * @return end_time 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 技术时间
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", seckillId=").append(seckillId);
        sb.append(", name=").append(name);
        sb.append(", number=").append(number);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}