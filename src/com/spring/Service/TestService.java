package com.spring.Service;

import com.spring.Dao.TestDao;
import com.spring.enity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestService {
    @Autowired
    private TestDao testDao;
    public  void AddDept(Dept dept){
        testDao.AddDept(dept);
    }
    public List<Dept> Find(){
        return testDao.Find();
    }
    public  void GroupAdd(List<Object[]> dept){
        testDao.GroupAdd(dept);
    }
}
