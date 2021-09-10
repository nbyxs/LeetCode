package com.spring.Dao;

import com.spring.enity.Dept;

import java.util.List;

public interface TestDao {
    public  void AddDept(Dept dept);

    List<Dept> Find();
    void GroupAdd(List<Object[]> deptList);
}
