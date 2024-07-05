//package com.sparta.spring.controller;
//
//
//import com.sparta.spring.dto.MemoRequestDto;
//import com.sparta.spring.dto.MemoResponseDto;
//import com.sparta.spring.service.MemoService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//    public class JDBCMemoController {
//    // 현재 제어의 흐름 ( 강한 결합된 상태 )
//    // JDBCMemoController > MemoService > MemoRepository
//
//    // 강한 결합을 해결해 보자 !
//    // 1. 각 객체에 대한 객체 생성은 딱 한 번만
//    // 2. 생성된 객체를 모든 곳에서 재사용
//    // 3. 생성자 주입을 사용하여 필요로 하는 객체에 해당 객체 주입하기
//
//    private final MemoService memoService;
//
//    public JDBCMemoController(MemoService memoService) {
//        this.memoService = memoService;
//    }
//
//    @PostMapping("/memos")
//    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
//        // 다른 클래스의 메서드를 호출하려면 해당 클래스를 인스턴스화 해야 한다.
//
//        // controller의 메서드 이름과 일치해주면 이해하기 좋다.
//        return memoService.createMemo(requestDto);
//    }
//
//    @GetMapping("/memos")
//    public List<MemoResponseDto> getMemos() {
//        return memoService.getMemos();
//    }
//
//    @PutMapping("/memos/{id}")
//    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
//        return memoService.updateMemo(id, requestDto);
//    }
//
//    @DeleteMapping("/memos/{id}")
//    public Long deleteMemo(@PathVariable Long id) {
//        return memoService.deleteMemo(id);
//    }
//
//
//}