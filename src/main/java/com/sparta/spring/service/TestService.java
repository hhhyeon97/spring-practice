package com.sparta.spring.service;

import com.sparta.spring.dto.MemoResponseDto;
import com.sparta.spring.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<MemoResponseDto> getMemosByKeyword(String keyword) {
        return testRepository.findAllByContentsContainsOrderByModifiedAtDesc(keyword).stream().map(MemoResponseDto::new).toList();
    }

}
