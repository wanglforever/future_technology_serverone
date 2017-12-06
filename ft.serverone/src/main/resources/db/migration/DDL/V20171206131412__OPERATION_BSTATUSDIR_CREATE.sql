CREATE TABLE bstatusdir(
    `bstatus_id`           INT       NOT NULL        COMMENT 'bstatusdir主键',
    `bstatus_name`         VARCHAR(100) NOT NULL        COMMENT  '位置名称',
PRIMARY KEY (`bstatus_id`)
) DEFAULT CHARSET = utf8 COMMENT = '运营bstatusdir';