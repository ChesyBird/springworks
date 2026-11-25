package com.springboot.boardweb.service;

import com.springboot.boardweb.domain.Post;
import com.springboot.boardweb.domain.User;
import com.springboot.boardweb.repository.PostRepository;
import com.springboot.boardweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    // 회원 수
    public long countUsers(){
        return userRepository.count();
    }

    // 게시글 수
    public long countPosts(){
        return postRepository.count();
    }

    // 회원 목록
    public List<User> findAllUsers(){
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    // 게시글 목록 (최신 순 5개)
    public List<Post> findRecentPosts(){
        return postRepository.findTop5ByOrderByIdDesc();
    }

    // 회원 삭제 + 회원의 글도 함께 삭제
    @Transactional
    public void deleteUser(long id, String loginUsername){
        // 삭제할 회원
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found : " + id));
        // 관리자 본인은 삭제 불가
        if(user.getUsername().equals(loginUsername)){
            throw new IllegalArgumentException("자기 자신은 삭제할 수 없습니다.");
        }
        postRepository.deleteByWriter(user.getUsername());
        // 삭제
        userRepository.delete(user);    // 회원 삭제

    }

}
