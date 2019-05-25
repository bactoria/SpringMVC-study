package me.bactoria.ex01.controller;

import com.zaxxer.hikari.HikariConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import me.bactoria.ex01.domain.hello.HelloService;
import me.bactoria.ex01.domain.hello.dto.HelloRequestDto;
import me.bactoria.ex01.domain.hello.dto.HelloResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.RequestToViewNameTranslator;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;
    private final HikariConfig hikariConfig;

    @GetMapping("/hello")
    public void hello() {
    }

    @GetMapping("/helloLocale")
    public void helloLocale(Locale locale, Model model) {
        model.addAttribute(locale);
    }

    @GetMapping("/helloPage")
    public String helloPage(HelloRequestDto requestDto,
                            @ModelAttribute("page") int page, Model model) {
        log.info(String.valueOf(model));
        return "helloPage";
    }

    @ResponseBody
    @GetMapping("/mapper")
    public String helloMapper() {
        return helloService.getAccount();
    }

    @GetMapping("/helloDto")
    public String helloDto(HelloRequestDto requestDto) {
        return "helloDto";
    }

    @GetMapping("/datasource")
    public String datasource(Model model) {
        model.addAttribute("driverClassName", hikariConfig.getDriverClassName());
        model.addAttribute("username", hikariConfig.getUsername());
        return "datasource";
    }

    @GetMapping("/redirect")
    public String redirect(HelloRequestDto requestDto, RedirectAttributes rttr) {
        rttr.addFlashAttribute("id", requestDto.getId() + 10000);
        rttr.addFlashAttribute("date", requestDto.getDate());
        rttr.addFlashAttribute("requestDto", requestDto);

        return "redirect:/redirected";
    }

    @GetMapping("/redirected")
    public String redirected() {
        return "redirectPage";
    }

    @ResponseBody
    @GetMapping("/json")
    public HelloResponseDto json(@RequestParam String message) {
        log.info(message);
        HelloResponseDto responseDto = new HelloResponseDto();
        responseDto.setMessage(message);
        responseDto.setDate(LocalDate.now());
        return responseDto;
    }

    @ResponseBody
    @GetMapping("/responseEntity")
    public ResponseEntity responseEntity(@RequestParam String message) {
        log.info(message);
        HelloResponseDto responseDto = new HelloResponseDto();
        responseDto.setMessage(message);
        responseDto.setDate(LocalDate.now());
        return ResponseEntity.ok(responseDto);
    }

    @ResponseBody
    @GetMapping(value = "/header", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity header() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HelloResponseDto dto = new HelloResponseDto();
        return ResponseEntity.ok().headers(headers).body(dto);
    }

    @GetMapping("/fileUpload")
    public void fileUpload() {
        log.info("/fileUpload...");
    }

    @PostMapping("/fileUpload")
    public void fileUpload(ArrayList<MultipartFile> files) {
        files.forEach(file -> {
            log.info("-------------");
            log.info("name: " + file.getOriginalFilename());
            log.info("size: " + file.getSize());
        });
    }

}
