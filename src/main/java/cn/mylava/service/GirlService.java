package cn.mylava.service;

import cn.mylava.bean.Girl;
import cn.mylava.dao.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/08/2018
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    //事务演示
    @Transactional
    public void transactionTest() {
        Girl g1 = new Girl();
        g1.setAge(19);
        g1.setCupSize("G");
        girlRepository.save(g1);

        Girl g2 = new Girl();
        g2.setAge(20);
        g2.setCupSize("FF");
        girlRepository.save(g2);
    }
}
