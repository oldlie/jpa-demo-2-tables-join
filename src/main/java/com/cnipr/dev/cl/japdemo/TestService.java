package com.cnipr.dev.cl.japdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━━━━━━━━━━━━
 * 2019/12/09
 * TestService
 *
 * @author 陈列
 */
@Service
@Slf4j
public class TestService {

    private BarRepository barRepository;
    private FooRepository fooRepository;
    private FooBarRepository fooBarRepository;

    @Autowired
    public void setBarRepository(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    @Autowired
    public void setFooRepository(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Autowired
    public void setFooBarRepository(FooBarRepository fooBarRepository) {
        this.fooBarRepository = fooBarRepository;
    }

    public void test() {
        Foo foo = Foo.builder().foo("foo").build();
        foo = this.fooRepository.save(foo);
        Bar bar = Bar.builder().fooId(foo.getId()).bar("bar").build();
        bar =this.barRepository.save(bar);

        List<FooBar> fooBar = this.fooBarRepository.findAll(
                (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("foo"), "foo")
        );

        System.out.println("total:" + fooBar.size());
    }
}
