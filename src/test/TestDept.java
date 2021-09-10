package test;

import com.spring.Service.TestService;
import com.spring.enity.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestDept {
      class ListNode {
   int val;
    ListNode next = null;
  }
    @Test
    public  void test1(){
        Dept dept=new Dept(110,"zs","aa");
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc1.xml");
        TestService testService=context.getBean("testService",TestService.class);
        testService.AddDept(dept);
    }
    @Test
    public void test2(){
        ApplicationContext context =new ClassPathXmlApplicationContext("jdbc1.xml");
        TestService testService=context.getBean("testService",TestService.class);
        List<Dept> deptList=testService.Find();

        for(Dept d:deptList){
            System.out.println(d.getId()+d.getDname()+d.getLocal());
        }
    }
    @Test
    public  void test3(){
        ApplicationContext context =new ClassPathXmlApplicationContext("jdbc1.xml");
        TestService testService=context.getBean("testService",TestService.class);
        List<Object[]>batchArgs=new ArrayList<>();
        Object[] o1={3,"java","a"};
        Object[]o2={4,"c++","b"};
        Object[]o3={5,"MySQL","c"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
//调用批量添加
        testService.GroupAdd(batchArgs);
        List<Dept> deptList=testService.Find();

        for(Dept d:deptList){
            System.out.println(d.getId()+d.getDname()+d.getLocal());
        }

    }

}
