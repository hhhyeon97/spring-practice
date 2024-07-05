package com.sparta.spring.repository;

import com.sparta.spring.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// SimpleJpaRepository에 @Repository가 달려 있어서
// 여기서 달아주지 않아도 자동으로 등록되고 있음 !
// 이전에 나는 명시적으로 달아줬던 거 같은데 달아줘도 상관 없는 듯 ?!
public interface MemoRepository extends JpaRepository<Memo, Long> {

}
