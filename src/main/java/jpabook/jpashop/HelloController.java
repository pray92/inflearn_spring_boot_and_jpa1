package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model /* 데이터를 싣고 View에 전달 */ model){
        model.addAttribute("data", "hello!!!");
        return "hello"; // 화면 이름
    }

}
