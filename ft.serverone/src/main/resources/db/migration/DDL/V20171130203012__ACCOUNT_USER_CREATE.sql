CREATE TABLE account_user(
`id`              INT            AUTO_INCREMENT     COMMENT '主键id',
`userName`        VARCHAR (30)     NOT NULL           COMMENT '用户名',
`password`        VARCHAR (50)     NOT NULL           COMMENT '密码',
`accountName`     VARCHAR (30)     NULL           COMMENT '用户真实姓名',
`accountSex`      VARCHAR (10)     NULL           COMMENT '用户性别',
`accountBirthday` VARCHAR (50)     NULL           COMMENT '用户出生日期',
`accountGraduatedSchool` VARCHAR (50)   NULL      COMMENT '用户毕业院校',
`accountProfession`  VARCHAR (50)  NULL           COMMENT '用户专业',
`accountGraduatedTime`   VARCHAR (50)   NULL      COMMENT '用户毕业时间',
`accountEducation`   VARCHAR (30)  NULL           COMMENT '用户学历',
`accountAddress`     VARCHAR (100) NULL           COMMENT '用户地址',
`accountEmail`       VARCHAR (50)  NULL           COMMENT '用户邮箱',
`accountQQNum`       VARCHAR (30)  NULL           COMMENT '用户QQ号',
`accountPhone`       VARCHAR (30)  NULL           COMMENT '用户手机号',
`accountRole`        VARCHAR (30)                 COMMENT '用户角色',
PRIMARY KEY (`id`)
)DEFAULT CHARSET = utf8 COMMENT = 'udbs用户表';