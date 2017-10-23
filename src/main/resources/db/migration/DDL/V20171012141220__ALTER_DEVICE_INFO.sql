ALTER TABLE device_info
ADD callState tinyint NOT NULL DEFAULT 0 COMMENT '呼叫状态，0为未呼叫，1为正在呼叫';
ALTER TABLE device_info
ADD callCount int     NOT NULL DEFAULT 0 COMMENT '呼叫次数';
ALTER TABLE device_info
ADD callTime varchar(20) COMMENT '呼叫时间';