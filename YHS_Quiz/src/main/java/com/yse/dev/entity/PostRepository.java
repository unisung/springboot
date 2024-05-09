package com.yse.dev.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository 
   extends JpaRepository<Post, Integer> {

}
