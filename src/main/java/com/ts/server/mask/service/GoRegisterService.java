package com.ts.server.mask.service;

import com.ts.server.mask.dao.GoRegisterDao;
import com.ts.server.mask.domain.GoRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GoRegisterService {
    private final GoRegisterDao dao;

    @Autowired
    public GoRegisterService(GoRegisterDao dao) {
        this.dao = dao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public GoRegister save(GoRegister t){
        if(dao.has(t.getIdCard())){
            dao.update(t);
        }else{
            dao.insert(t);
        }
        t.setCreateTime(new Date());
        return t;
    }

    public Optional<GoRegister> get(String idCard){
        try{
            return Optional.of(dao.findOne(idCard));
        }catch (DataAccessException e){
            return Optional.empty();
        }
    }

    public Long count(String name, String area, String village) {
        return dao.count(name, area, village);
    }

    public List<GoRegister> query(String name, String area, String village, int offset, int limit){
        return dao.find(name, area, village, offset, limit);
    }
}
