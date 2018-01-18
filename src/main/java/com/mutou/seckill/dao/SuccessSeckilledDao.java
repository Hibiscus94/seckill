package com.mutou.seckill.dao;

import com.mutou.seckill.entity.SuccessSeckilled;
import org.apache.ibatis.annotations.Param;

public interface SuccessSeckilledDao {
    /**
     * 保存秒杀记录 可过滤重复
     * @param seckillId 商品id
     * @param userPhpne 用户电话
     * @return 插入行数
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhpne") long userPhpne);

    /**
     * 根据id查询SuccessSeckilled
     * @param seckillId 商品id
     * @param userPhone
     * @return successseckilled
     */
    SuccessSeckilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}