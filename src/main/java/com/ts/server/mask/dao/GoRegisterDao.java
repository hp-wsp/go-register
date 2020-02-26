package com.ts.server.mask.dao;

import com.ts.server.mask.common.utils.DaoUtils;
import com.ts.server.mask.domain.GoRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * 外出登记数据操作
 *
 * @author TS Group
 */
@Repository
public class GoRegisterDao {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<GoRegister> mapper = (r, i) -> {
        GoRegister t = new GoRegister();

        t.setId(r.getLong("id"));
        t.setArea(r.getString("area"));
        t.setName(r.getString("name"));
        t.setIdCard(r.getString("id_card"));
        t.setSex(r.getString("sex"));
        t.setMobile(r.getString("mobile"));
        t.setProvince(r.getString("province"));
        t.setCity(r.getString("city"));
        t.setCouAddress(r.getString("cou_address"));
        t.setPoverty(r.getBoolean("is_poverty"));
        t.setInpArea(r.getBoolean("is_inp_area"));
        t.setDriver(r.getBoolean("is_driver"));
        t.setGoDate(r.getString("go_date"));
        t.setCreateTime(r.getTimestamp("create_time"));

        return t;
    };

    @Autowired
    public GoRegisterDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(GoRegister t){
        final String sql = "INSERT INTO t_register (area, name, id_card, sex, mobile, province, city, cou_address," +
                "is_inp_area, is_poverty, is_driver, go_date, create_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";

        jdbcTemplate.update(sql, t.getArea(), t.getName(), t.getIdCard(), t.getSex(), t.getMobile(), t.getProvince(),
                t.getCity(), t.getCouAddress(), t.isInpArea(), t.isPoverty(), t.isDriver(), t.getGoDate());
    }

    public boolean update(GoRegister t){
        final String sql = "UPDATE t_register SET area = ?, name = ?, sex = ?, mobile = ?, province = ?, city= ?," +
                "cou_address = ?, is_inp_area = ?, is_poverty = ?, is_driver = ?, go_date = ? WHERE id_card = ?";
        return jdbcTemplate.update(sql, t.getArea(), t.getName(), t.getSex(), t.getMobile(), t.getProvince(),
                t.getCity(), t.getCouAddress(), t.isInpArea(), t.isPoverty(), t.isDriver(), t.getGoDate(), t.getIdCard()) > 0;
    }

    public boolean has(String idCard){
        final String sql = "SELECT COUNT(id) FROM t_register WHERE id_card = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{idCard}, Integer.class);
        return count != null && count > 0;
    }

    public Long count(String name, String goDate){
        final String sql = "SELECT COUNT(id) FROM t_register WHERE name LIKE ? AND go_date LIKE ?";

        String nameLike = DaoUtils.like(name);
        String goDateLike = DaoUtils.like(goDate);

        return jdbcTemplate.queryForObject(sql, new Object[]{nameLike, goDateLike}, Long.class);
    }

    public List<GoRegister> find(String name, String goDate, int offset, int limit){
        final String sql = "SELECT * FROM t_register WHERE name LIKE ? AND go_date LIKE ? " +
                "ORDER BY create_time DESC LIMIT ? OFFSET ?";

        String nameLike = DaoUtils.like(name);
        String goDateLike = DaoUtils.like(goDate);

        return jdbcTemplate.query(sql, new Object[]{nameLike, goDateLike, limit, offset}, mapper);
    }

}
