CREATE TABLE `call_server_setting`(
`id`           INT           NOT NULL  AUTO_INCREMENT  COMMENT '主键id',
`callSwitch`   tinyint       NOT NULL  DEFAULT 0       COMMENT '呼叫开关，0为关闭，1为开启',
`callType`     varchar(20)   NULL                      COMMENT '呼叫方式',
`hideSwitch`   tinyint       NOT NULL  DEFAULT 0       COMMENT '隐私开关，0为关闭，1为开启',
`hideType`     varchar(20)   NULL                      COMMENT '隐私方式',
PRIMARY KEY (`id`)
)DEFAULT CHARSET = utf8 COMMENT = '呼叫服务器通用设置表';