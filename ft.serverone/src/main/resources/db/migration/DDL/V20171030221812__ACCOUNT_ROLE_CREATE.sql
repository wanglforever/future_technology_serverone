CREATE TABLE account_role(
`id`              INT        AUTO_INCREMENT       COMMENT '主键id',
`roleCode`        VARCHAR (30)         NOT NULL   COMMENT '权限码',
`roleName`        VARCHAR (30)         NOT NULL   COMMENT '权限名称',
PRIMARY KEY (`id`)
)DEFAULT CHARSET = utf8 COMMENT = 'udbs用户权限表';