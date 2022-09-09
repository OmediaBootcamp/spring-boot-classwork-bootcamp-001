package dev.omedia.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/path/variable")
@Slf4j
@ConditionalOnProperty(value = "rpTest.enabled", matchIfMissing = false)
public class RPTestController {

    @GetMapping
    public void getArray(@RequestParam("array") String[] array) {
        log.info(Arrays.toString(array));
    }

    @GetMapping("/list")
    public void getList(@RequestParam("list") List<String> list) {
        log.info(list.toString());
    }

    @GetMapping("/multipleRP")
    public void getMultiple(@RequestParam("a") String a, @RequestParam("a") String b) {
        log.info("a: " + a + " b: " + b);
    }
}
