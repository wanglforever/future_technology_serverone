CREATE TABLE essay(
    essay_id        BIGINT  AUTO_INCREMENT  COMMENT '文章主键',
    essay_title     VARCHAR(100) NOT NULL  COMMENT '标题',
    catogory_id     INT           NULL      COMMENT '类别',
    status_id       INT           NULL      COMMENT '状态',
    essay_mktime    VARCHAR(32)  NULL       COMMENT '创建时间',
    essay_modtime   VARCHAR(32)  NULL       COMMENT '修改时间',
    essay_content   TEXT          NULL       COMMENT '内容',
PRIMARY KEY (`essay_id`)
) DEFAULT CHARSET = utf8 COMMENT = '文章essay';
