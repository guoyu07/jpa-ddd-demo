package moe.cnkirito.jpa.web;

import moe.cnkirito.jpa.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xujingfeng
 * @since 2017/11/22
 */
@RestController
public class TestController {

    @Autowired
    ClazzService clazzService;

    @RequestMapping("test1")
    public String test1(){
        //测试由clazz发起students的删除操作
        clazzService.test1();
        return "success";
    }

}
