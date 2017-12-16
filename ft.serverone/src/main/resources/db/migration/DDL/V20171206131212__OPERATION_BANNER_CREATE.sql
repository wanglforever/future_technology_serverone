CREATE TABLE banner(
    banner_id           BIGINT  AUTO_INCREMENT        COMMENT 'banner主键',
    banner_name         VARCHAR(100) NOT NULL        COMMENT  '名称',
    banner_title        VARCHAR(100) NOT NULL         COMMENT '标题',
    banner_content      VARCHAR(100) NOT NULL         COMMENT '内容',
    banner_description  VARCHAR(255)  NULL            COMMENT '描述',
    banner_source       VARCHAR(255)  NULL            COMMENT '资源',
    ref_address         VARCHAR(255)  NULL            COMMENT '链接地址',
    bposition_id        INT           NULL            COMMENT '位置id',
    bstatus_id          INT           NULL            COMMENT '内容',
    banner_mktime       VARCHAR(32)   NULL            COMMENT '创建时间',
    banner_modtime      VARCHAR(32)   NULL            COMMENT '修改时间',
PRIMARY KEY (`banner_id`)
) DEFAULT CHARSET = utf8 COMMENT = '运营banner';
