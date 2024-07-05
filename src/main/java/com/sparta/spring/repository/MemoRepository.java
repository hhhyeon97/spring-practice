package com.sparta.spring.repository;

import com.sparta.spring.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// SimpleJpaRepository에 @Repository가 달려 있어서
// 여기서 달아주지 않아도 자동으로 등록되고 있음 !
// 이전에 나는 명시적으로 달아줬던 거 같은데 달아줘도 상관 없는 듯 ?!
public interface MemoRepository extends JpaRepository<Memo, Long> {

    // 수정시간을 내림차순 기준으로 전체 내용을 반환해주라는 뜻
    // 원하는 기능에 대한 SQL을 작성하지 않아도 정해진 규칙에 맞게끔
    // 메서드명을 정하면 자동으로 해당 기능을 실행해준다.
    List<Memo> findAllByOrderByModifiedAtDesc();


    // 파라미터를 통해서 sql을 동적으로 처리할 수도 있음 !!
    List<Memo> findAllByUsername(String username);
}
