package com.mutou.seckill.dao;

import com.mutou.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId 秒杀商品id
     * @param killTime 秒杀时间
     * @return 插入的行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     *根据id查询
     * @param seckillId 商品id
     * @return seckill
     */
    Seckill queryById(long seckillId);

    /**
     * 秒杀列表
     * @param offset 偏移量
     * @param limit 查询条数
     * @return List
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}