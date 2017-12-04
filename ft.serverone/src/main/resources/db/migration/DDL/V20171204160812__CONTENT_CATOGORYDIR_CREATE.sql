CREATE TABLE catogorydir(
    catogory_id     INT     NOT NULL        COMMENT '文章类别id',
    catogory_name   VARCHAR(24) NOT NULL    COMMENT '文章类别name',
PRIMARY KEY (`catogory_id`)
)DEFAULT CHARSET = utf8 COMMENT = '文章类别catogorydir';