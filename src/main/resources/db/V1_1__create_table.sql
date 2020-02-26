#----------------------------------------------
# 登记添加乡镇字段
#----------------------------------------------
ALTER TABLE t_register ADD area VARCHAR(50) NOT NULL DEFAULT '' COMMENT '乡镇';