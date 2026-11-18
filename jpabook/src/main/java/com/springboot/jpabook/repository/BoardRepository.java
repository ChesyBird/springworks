package com.springboot.jpabook.repository;

import com.springboot.jpabook.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository<T(table), ID>
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // save(), findAll(), findById(), deleteById() : 저장, 목록조회, 단건조회, 삭제

    // find + 엔티티이름(생략가능) + By + 변수이름
    // 제목으로 검색
    List<Board> findByTitle(String searchKeyword);

    // 특정 단어가 포함된 글 내용
    List<Board> findByContentContaining(String searchKeyword);
}
