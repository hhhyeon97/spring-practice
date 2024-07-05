package com.sparta.spring.repository;

import com.sparta.spring.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);
}
