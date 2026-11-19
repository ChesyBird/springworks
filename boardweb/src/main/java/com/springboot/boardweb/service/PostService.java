package com.springboot.boardweb.service;

import com.springboot.boardweb.domain.Post;
import com.springboot.boardweb.dto.AddPostRequest;
import com.springboot.boardweb.dto.UpdatePostRequest;
import com.springboot.boardweb.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor // 생성자 주입
@Service
public class PostService {
    private PostRepository postRepository;

    // 글 등록
    public Post save(AddPostRequest request){
        // 게시글이 DB에 저장
        return postRepository.save(request.toEntity());
    }

    // 글 목록 조회
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    // 글 상세보기
    public Post findById(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));  // 예외처리
    }

    // 글 삭제
    public void delete(Long id){
        postRepository.deleteById(id);
    }

    // 글 수정
    @Transactional  // 트랜젝션 종료 시 변경 내용이 반영됨
    public Post update(Long id, UpdatePostRequest request){
        // 수정할 게시글 가져오기
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
        // 글 수정 (update 함수 : post 클래스에 있다)
        post.update(request.getTitle(), request.getContent());
        return post;
    }

}
