package com.yse.dev.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yse.dev.entity.Post;
import com.yse.dev.entity.PostRepository;


@Controller
public class PostController {

	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/post/posts")
	public String getPosts(Model model) {
		model.addAttribute("posts",postRepository.findAll());
		return "post/posts";
	}
	
	@GetMapping("/post/create")
	public String createPost() {
		return "post/create";
	}
	
	@PostMapping("/post/create")
	public String createPost(Post post, Model model) {
		postRepository.save(post);
		return "redirect:/post/posts";
	}
	
	@GetMapping("/post/read/{id}")
	public String readPost(@PathVariable("id") Integer id,Model model) {
		Post post = postRepository.findById(id).orElseThrow();
		model.addAttribute("post",post);
		return "post/read";
	}
	
	@GetMapping("/post/edit/{id}")
	public String editPostGet(@PathVariable("id") Integer id,Model model) {
		Post post = postRepository.findById(id).orElseThrow();
		model.addAttribute("post",post);
		return "post/edit";
	}
	
	@PostMapping("/post/edit/{id}")
	public String editPostPost(@PathVariable("id") Integer id, Post post) {
		Post post1 = postRepository.findById(id).orElseThrow();
		post1.setTitle(post.getTitle());
		post1.setAuthor(post.getAuthor());
		post1.setContent(post.getContent());
		
		postRepository.save(post1);
		
		return "redirect:/post/posts";
	}
	
	@GetMapping("/post/delete/{id}")
	public String deletePost(@PathVariable("id") Integer postId) {
		Post post = postRepository.findById(postId).orElseThrow();
		postRepository.delete(post);
		
		return "redirect:/post/posts";
	}
}
