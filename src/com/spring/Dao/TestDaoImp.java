package com.spring.Dao;

import com.spring.enity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class TestDaoImp implements  TestDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void AddDept(Dept dept) {
        String sql="insert into dept values(?,?,?)";
        int update=jdbcTemplate.update(sql,dept.getId(),dept.getDname(),dept.getLocal());
        System.out.println(update);
    }

    @Override
    public List<Dept> Find() {
        String sql="select *from dept";
       List<Dept> deptList= jdbcTemplate.query(sql,new BeanPropertyRowMapper<Dept>(Dept.class));
    return  deptList;
    }

    @Override
    public void GroupAdd(List<Object[]> deptList) {
        String sql="insert into dept values(?,?,?)";
       int [] res= jdbcTemplate.batchUpdate(sql, (List<Object[]>) deptList);
        System.out.println(Arrays.toString(res));
    }
}
