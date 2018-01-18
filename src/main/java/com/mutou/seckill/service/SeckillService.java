package com.mutou.seckill.service;

import com.mutou.seckill.dto.Exposer;
import com.mutou.seckill.dto.SeckillExecution;
import com.mutou.seckill.entity.Seckill;
import com.mutou.seckill.exception.RepeatKillException;
import com.mutou.seckill.exception.SeckillClosedException;
import com.mutou.seckill.exception.SeckillException;

import java.util.List;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.seckill.service <br>
 * 定义粒度，参数，return
 * @author mutou <br>
 * @version 1.0.0
 * @description todo <br>
 * @date 17/01/2018 <br>
 */
public interface SeckillService {
    /**
     * 查询所有秒杀商品
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀商品
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 暴露秒杀接口
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException,RepeatKillException,SeckillClosedException;
}
