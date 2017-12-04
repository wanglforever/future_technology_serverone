CREATE TABLE statusdir(
    status_id     INT     NOT NULL        COMMENT '文章状态id',
    status_name   VARCHAR(24) NOT NULL    COMMENT '文章状态name',
PRIMARY KEY (`status_id`)
)DEFAULT CHARSET = utf8 COMMENT = '文章状态statusdir';