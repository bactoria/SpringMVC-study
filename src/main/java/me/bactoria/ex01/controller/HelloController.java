package me.bactoria.ex01.controller;

import com.zaxxer.hikari.HikariConfig;
import lombok.RequiredArgsConstructor;
import me.bactoria.ex01.domain.hello.HelloService;
import me.bactoria.ex01.domain.hello.dto.HelloRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;
    private final HikariConfig hikariConfig;

    @ResponseBody
    @GetMapping("/hello")
    public String hello(HelloRequestDto requestDto) {
        System.out.println(requestDto);
        return requestDto.toString();
    }

    @ResponseBody
    @GetMapping("/useMapper")
    public String hello() {
        return helloService.getAccount();
    }

    @GetMapping("/helloJSP")
    public String helloJSP() {
        return "hello4";
    }

    @GetMapping("/datasource")
    public String datasource(Model model) {
        model.addAttribute("driverClassName", hikariConfig.getDriverClassName());
        model.addAttribute("username", hikariConfig.getUsername());
        return "datasource";
    }
}
