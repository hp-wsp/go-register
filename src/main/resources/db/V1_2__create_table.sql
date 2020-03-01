#----------------------------------------------
# 登记添加字段
#----------------------------------------------
ALTER TABLE t_register ADD county VARCHAR(50) COMMENT '县';
ALTER TABLE t_register ADD skill VARCHAR(50) COMMENT '技能';