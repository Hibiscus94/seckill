package com.mutou.seckill.service.impl;

import com.mutou.seckill.dto.Exposer;
import com.mutou.seckill.dto.SeckillExecution;
import com.mutou.seckill.entity.Seckill;
import com.mutou.seckill.exception.RepeatKillException;
import com.mutou.seckill.exception.SeckillClosedException;
import com.mutou.seckill.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.seckill.service.impl <br>
 *
 * @author mutou <br>
 * @version 1.0.0
 * @description todo <br>
 * @date 17/01/2018 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-service.xml"})
public class SeckillServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() throws Exception {
        Seckill seckill = seckillService.getById(1000L);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillLogic() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long userPhone = 15215066115L;
            String md5 = exposer.getMd5();
            try{
                SeckillExecution execution = seckillService.executeSeckill(id,userPhone,md5);
                logger.info("result={}",execution);
            }catch(RepeatKillException e){
                logger.error(e.getMessage());
            }catch (SeckillClosedException e){
                logger.error(e.getMessage());
            }
        }else{
            // 秒杀未开启
            logger.warn("exposer={}",exposer);
        }
    }
}