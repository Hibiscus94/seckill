package com.mutou.seckill.service.impl;

import com.mutou.seckill.dao.SeckillDao;
import com.mutou.seckill.dao.SuccessSeckilledDao;
import com.mutou.seckill.dto.Exposer;
import com.mutou.seckill.dto.SeckillExecution;
import com.mutou.seckill.entity.Seckill;
import com.mutou.seckill.entity.SuccessSeckilled;
import com.mutou.seckill.enums.SeckillStateEnum;
import com.mutou.seckill.exception.RepeatKillException;
import com.mutou.seckill.exception.SeckillClosedException;
import com.mutou.seckill.exception.SeckillException;
import com.mutou.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

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
@Service
public class SeckillServiceImpl implements SeckillService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessSeckilledDao successSeckilledDao;

    public final String salt = "sdksHksjhdsjk)32$&Ss)*_sdshusS8EEKks-=pM";

    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 4);
    }

    @Override
    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        // 系统当前时间
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    @Override
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillClosedException {
        try{
            if (md5 == null || !md5.equals(getMD5(seckillId))){
                throw  new SeckillException("Seckill data rewrite!");
            }
            // 执行秒杀逻辑 : 减库存 + 记录购买行为
            // 记录购买行为
            int insertCount = successSeckilledDao.insertSuccessKilled(seckillId,userPhone);
            if (insertCount <= 0){
                // 重复秒杀
                throw new RepeatKillException("Seckill repeated!");
            }else{
                Date nowTime = new Date();
                int updateCount = seckillDao.reduceNumber(seckillId,nowTime);
                if (updateCount <= 0){
                    // 没有更新到操作 秒杀结束
                    throw new SeckillClosedException("Seckill is closed!");
                }else{
                    // 秒杀成功
                    SuccessSeckilled successSeckilled =successSeckilledDao.queryByIdWithSeckill(seckillId,userPhone);
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS,successSeckilled);
                }
            }
        }catch (SeckillClosedException e1){
            throw e1;
        }catch (RepeatKillException e2){
            throw e2;
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            throw  new SeckillException("Seckill inner error:" + e.getMessage());
        }
    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
