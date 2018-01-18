-- 数据库ddl
-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
use seckill;

-- 创建秒杀数据表
CREATE TABLE seckill(
`seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品id',
`name` VARCHAR(120) NOT NULL DEFAULT '' COMMENT '商品名称',
`number` INT(10) unsigned NOT NULL DEFAULT 0 COMMENT '商品库存',
`start_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
`end_time` TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
KEY idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- 初始化数据
INSERT  INTO seckill
  (name,number,start_time,end_time)
VALUES
  ('1000远秒杀iPhone7',100,'2018-01-17 00:00:00','2018-01-19 00:00:00'),
  ('500远秒杀iPad3',200,'2018-01-17 00:00:00','2018-01-19 00:00:00'),
  ('300远秒杀小米6',300,'2018-01-17 00:00:00','2018-01-19 00:00:00'),
  ('200远秒杀红米note',400,'2018-01-17 00:00:00','2018-01-19 00:00:00');

-- 创建秒杀成功信息表
CREATE TABLE success_seckilled(
`seckill_id` BIGINT NOT NULL COMMENT '商品id',
`user_phone` BIGINT NOT NULL COMMENT '电话',
`state` tinyint NOT NULL DEFAULT 0 COMMENT '状态标识：-1：无效，0：成功，1：已付款',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT'抢购成功时间',
PRIMARY KEY (seckill_id,user_phone),
KEY idx_create_time (create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功信息表';

