package com.mutou.seckill.dao;

import com.mutou.seckill.entity.SuccessSeckilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
public class SuccessSeckilledDaoTest {
    @Resource
    private SuccessSeckilledDao successSeckilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1000L;
        long phone = 15215066110L;
        int insertCount = successSeckilledDao.insertSuccessKilled(id, phone);
        System.out.println(insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        SuccessSeckilled successSeckilled = successSeckilledDao.queryByIdWithSeckill(1000L, 15215066110L);
        System.out.println(successSeckilled);
        System.out.println(successSeckilled.getSeckill());
    }
}