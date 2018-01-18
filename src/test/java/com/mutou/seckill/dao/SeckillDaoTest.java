package com.mutou.seckill.dao;

import com.mutou.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.seckill.dao <br>
 *
 * @author mutou <br>
 * @version 1.0.0
 * @description todo <br>
 * @date 17/01/2018 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class SeckillDaoTest {
    // 注入dao
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L,killTime);
        System.out.println(updateCount);
    }

    @Test
    public void queryById() throws Exception {
        long id =1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill seckill:seckills) {
            System.out.println(seckill);
        }
    }
}