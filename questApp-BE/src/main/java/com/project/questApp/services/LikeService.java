package com.project.questApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.questApp.entities.Like;
import com.project.questApp.entities.Post;
import com.project.questApp.entities.User;
import com.project.questApp.repos.LikeRepository;
import com.project.questApp.requests.LikeCreateRequest;

@Service
public class LikeService {

	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;
	
	public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
	}
	
	public List<Like> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
		if (userId.isPresent() && postId.isPresent()) {
			return likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
		} else if (userId.isPresent()){
			return likeRepository.findByUserId(userId.get());
		} else if (postId.isPresent()){
			return likeRepository.findByPostId(postId.get());
		} else 
			return likeRepository.findAll();
	}
	
	public Like getOneLike(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}


	public void deleteOneLike(Long likeId) {
		likeRepository.deleteById(likeId);
	}


	public Like createOneLike(LikeCreateRequest newLikeRequest) {
		User user = userService.getOneUser(newLikeRequest.getUserId());
		Post post = postService.getOnePost(newLikeRequest.getPostId());
		if (user != null && post != null) {
			Like likeToCreate = new Like();
			likeToCreate.setUser(user);
			likeToCreate.setPost(post);
			return likeRepository.save(likeToCreate);
		}
		return null;
		
	}

}
