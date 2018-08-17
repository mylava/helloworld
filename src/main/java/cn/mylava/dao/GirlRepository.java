package cn.mylava.dao;

import cn.mylava.bean.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/08/2018
 */
public interface GirlRepository extends JpaRepository<Girl,Integer > {

    public List<Girl> findByAge(Integer age);
}
