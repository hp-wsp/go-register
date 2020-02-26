package com.ts.server.mask.service;

import com.ts.server.mask.dao.GoRegisterDao;
import com.ts.server.mask.domain.GoRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    public Long count(String name, String goDate){
        return dao.count(name, goDate);
    }

    public List<GoRegister> query(String name, String goDate, int offset, int limit){
        return dao.find(name, goDate, offset, limit);
    }
}
