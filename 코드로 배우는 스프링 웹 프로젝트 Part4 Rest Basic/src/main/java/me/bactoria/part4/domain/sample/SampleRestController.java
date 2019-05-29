package me.bactoria.part4.domain.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/samples")
public class SampleRestController {

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SampleVO getSample(@PathVariable int id) {
        return new SampleVO(id, "스타", "로드");
    }

    @GetMapping
    public List<SampleVO> getList() {
        return IntStream.range(1, 10)
                .mapToObj(i -> new SampleVO(i, i + "First", i + "Last"))
                .collect(Collectors.toList());
    }

 /*   @GetMapping
    public Map<String, SampleVO> getMap() {
        Map<String, SampleVO> map = new HashMap<>();
        map.put("First", new SampleVO(111, "그루트", "주니어"));

        return map;
    }
*/
    @GetMapping(value="/check", params = {"height", "weight"})
    public ResponseEntity<SampleVO> check(Double height, Double weight) {
        SampleVO vo = new SampleVO(0, "" + height, "" + weight);

        if(height < 150) {
            return ResponseEntity.badRequest().body(vo);
        }

        return ResponseEntity.ok().body(vo);

    }

    @GetMapping("/product/{cat}/{pid}")
    public String[] getPath( @PathVariable String cat,
                             @PathVariable Integer pid) {
        return new String[]{"category: " + cat, "productid: " + pid};
    }

    @PostMapping("/ticket")
    public Ticket convert(@RequestBody Ticket ticket) {
        log.info("convert..... ticket: {}", ticket);

        return ticket;
    }

}
