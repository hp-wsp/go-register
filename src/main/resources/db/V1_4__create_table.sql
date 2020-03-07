#----------------------------------------------
# 添加村字段
#----------------------------------------------
ALTER TABLE t_register ADD village VARCHAR(50) NOT NULL DEFAULT '' COMMENT '村';