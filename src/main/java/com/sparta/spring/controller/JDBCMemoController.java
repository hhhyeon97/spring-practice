package com.sparta.spring.controller;


import com.sparta.spring.dto.MemoRequestDto;
import com.sparta.spring.dto.MemoResponseDto;
import com.sparta.spring.service.MemoService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
    public class JDBCMemoController {


    private final JdbcTemplate jdbcTemplate;

    public JDBCMemoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // 다른 클래스의 메서드를 호출하려면 해당 클래스를 인스턴스화 해야 한다.
        MemoService memoService = new MemoService(jdbcTemplate);
        // controller의 메서드 이름과 일치해주면 이해하기 좋다.
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        MemoService memoService = new MemoService(jdbcTemplate);
        return memoService.getMemos();
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        MemoService memoService = new MemoService(jdbcTemplate);
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        MemoService memoService = new MemoService(jdbcTemplate);
        return memoService.deleteMemo(id);
    }


}