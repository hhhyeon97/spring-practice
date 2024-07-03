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

    private final MemoService memoService;

    public JDBCMemoController(JdbcTemplate jdbcTemplate) {
        this.memoService = new MemoService(jdbcTemplate);
    }

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // 다른 클래스의 메서드를 호출하려면 해당 클래스를 인스턴스화 해야 한다.

        // controller의 메서드 이름과 일치해주면 이해하기 좋다.
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        return memoService.getMemos();
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        return memoService.deleteMemo(id);
    }


}