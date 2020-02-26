#---------------------------------------------------------------------
#行政区划
#---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS b_district (
  id CHAR(32) NOT NULL COMMENT '编号',
  name VARCHAR(50) NOT NULL COMMENT '名称',
  full_name VARCHAR(50) COMMENT '全名称',
  parent_id CHAR(32) NOT NULL COMMENT '上级区划编号',
  location VARCHAR(20) COMMENT '地理位置',
  level TINYINT NOT NULL DEFAULT 0 COMMENT '级别',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (id),
  INDEX idx_level (level)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

#------------------------------------------------------------------------
#登记
#------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS t_register (
  id INT(10) NOT NULL AUTO_INCREMENT,
  name VARCHAR(32) NOT NULL DEFAULT '' COMMENT '姓名',
  id_card VARCHAR(32) NOT NULL DEFAULT '' COMMENT '身份证号',
  sex VARCHAR(2) NOT NULL DEFAULT '' COMMENT '性别',
  mobile VARCHAR(20) NOT NULL DEFAULT '' COMMENT '联系电话',
  province VARCHAR(50)  COMMENT '省份',
  city VARCHAR(50)  COMMENT '城市',
  cou_address VARCHAR(100) COMMENT '本县地址',
  is_inp_area TINYINT DEFAULT 0 NOT NULL COMMENT '是否在疫区',
  is_poverty TINYINT DEFAULT 0 NOT NULL COMMENT '是否贫困户',
  is_driver TINYINT DEFAULT 0 NOT NULL COMMENT '是否有政府统一安排出务工乘车需求',
  go_date VARCHAR(20) NOT NULL  COMMENT '外出时间',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (id),
  UNIQUE KEY idx_id_card (id_card)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

#------------------------------------------------------------------------
#系统管理员表
#------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS t_manager (
  id CHAR(32) NOT NULL,
  username VARCHAR(30) NOT NULL COMMENT '用户名',
  password VARCHAR(50) NOT NULL COMMENT '密码',
  name VARCHAR(30) COMMENT '姓名',
  phone VARCHAR(20) DEFAULT '' COMMENT '联系电话',
  email VARCHAR(50) DEFAULT '' COMMENT '邮件地址',
  roles VARCHAR(200) DEFAULT '' NOT NULL COMMENT '权限角色',
  is_root TINYINT DEFAULT 0 NOT NULL COMMENT '1=超级用户',
  is_forbid TINYINT DEFAULT 1 NOT NULL COMMENT '1=禁用',
  is_delete TINYINT DEFAULT 0 NOT NULL COMMENT '1=删除',
  update_time DATETIME NOT NULL COMMENT '修改时间',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (id),
  UNIQUE KEY idx_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

#初始化系统管理员
INSERT INTO t_manager(id, username, password, name, roles, is_root, is_forbid, is_delete, update_time, create_time)
VALUES ('1', 'admin', '12345678', 'admin', "ROLE_SYS", 1, 0, 0, now(), now());