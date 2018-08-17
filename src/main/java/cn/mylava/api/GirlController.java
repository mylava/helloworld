package cn.mylava.api;

import cn.mylava.dao.GirlRepository;
import cn.mylava.bean.Girl;
import cn.mylava.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 17/08/2018
 */
@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping("/girls")
    public List<Girl> grils() {
        return girlRepository.findAll();
    }

    //注意，虽然path相同，但是mapping类型不同
    @PostMapping("/girls")
    public Girl add(@RequestParam(name = "cupSize") String cupSize,
                    @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        Girl save = girlRepository.save(girl);

        return save;
    }

    @GetMapping("/girls/{id}")
    public Girl getGirl(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).get();
    }

    @PutMapping("/girls/{id}")
    public Girl update(@PathVariable("id") Integer id,
                       @RequestParam(name = "cupSize") String cupSize,
                       @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    @DeleteMapping("/girls/{id}")
    public void delete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> findGirlsByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/girls/tran")
    public void tran() {
        girlService.transactionTest();
    }
}

