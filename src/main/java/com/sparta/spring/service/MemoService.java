package com.sparta.spring.service;

import com.sparta.spring.Application;
import com.sparta.spring.dto.MemoRequestDto;
import com.sparta.spring.dto.MemoResponseDto;
import com.sparta.spring.entity.Memo;
import com.sparta.spring.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@RequiredArgsConstructor  // 4-1. 롬복을 통해 주입하는 방법 이 어노테이션과
public class MemoService { // memoService

    // 4-2. final로 단 필드를 사용하면 주입 가능 !
    //private final MemoRepository memoRepository;

    // 5. 직접 주입 (수동 주입)
/*    private final MemoRepository memoRepository;

    public MemoService(ApplicationContext context) {
        // 1. 'Bean' 이름으로 가져오기
        //MemoRepository memoRepository = (MemoRepository) context.getBean("memoRepository");

        // 2. 'Bean' 클래스 형식으로 가져오기
        MemoRepository memoRepository = context.getBean(MemoRepository.class);
        this.memoRepository = memoRepository;
    }*/

    // 1. 생성자로 주입하는 방법
    // 현업에서도 주로 이 방법으로 많이 쓰인다고 한다.
    // @Autowired 생략 가능 ( 1개일 땐 자동으로 처리됨 !! )
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    // 2. 메서드로 주입하는 방법
  /*

    private MemoRepository memoRepository;

    @Autowired
    public void setDi(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }
  */

    // 3. 필드로 주입하는 방법
    // 추천 x - > 불안정 ?!
    // 힉.. 난 이 방식으로 배웠었는데 하하하

//    @Autowired
//    private MemoRepository memoRepository;


    // 연결된 컨틀롤러의 메서드의 반환타입으로 자동으로 지정된다.
    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);
        // DB 저장
        Memo saveMemo = memoRepository.save(memo);
        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return memoResponseDto;
    }

    public List<MemoResponseDto> getMemos() {
        // DB 조회                                   // 여기 다시 이해 필요
        return memoRepository.findAll().stream().map(MemoResponseDto::new).toList();
    }

    @Transactional // 변경감지
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        // 옵셔널 문법 추가 공부 필요 !!

        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);

        // memo 내용 수정
        memo.update(requestDto);

        return id;
    }

    public Long deleteMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = findMemo(id);

        // memo 삭제
        memoRepository.delete(memo);

        return id;
    }

    private Memo findMemo(Long id) {
        return memoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Memo not found"));
    }

}
