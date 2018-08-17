package cn.mylava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * comment:
 *
 * @author: lipengfei
 * @date: 16/08/2018
 */
@RestController
public class HelloController {

   /* @Value("${cupSize}")
    private String cupSize;

    @Value("${content}")
    private String content;*/

   @Autowired
   private GirlProperties girl;

    @RequestMapping(value = {"/hello/{id}","/hi/{id}"},method = RequestMethod.GET)
    public String say(@PathVariable(value = "id",required = false) Integer myId,
                      @RequestParam(value = "name",required = false,defaultValue = "张尚三") String myName) {
        return "id:"+myId+",name:"+myName;
//        return girl.getCupSize();
    }
}
