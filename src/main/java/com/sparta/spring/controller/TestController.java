package com.sparta.spring.controller;


import com.sparta.spring.dto.MemoResponseDto;
import com.sparta.spring.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/memos/contents")
    public List<MemoResponseDto> getMemosByKeyword(String keyword){
        return testService.getMemosByKeyword(keyword);
    }


}
