CREATE TABLE bpositiondir(
    bposition_id           INT      NOT NULL         COMMENT 'positiondir主键',
    bposition_name         VARCHAR(100) NOT NULL        COMMENT  '位置名称',
PRIMARY KEY (`bposition_id`)
) DEFAULT CHARSET = utf8 COMMENT = '运营bpositiondir';