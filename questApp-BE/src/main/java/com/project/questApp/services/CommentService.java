package com.project.questApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.questApp.entities.Comment;
import com.project.questApp.entities.Post;
import com.project.questApp.entities.User;
import com.project.questApp.repos.CommentRepository;
import com.project.questApp.requests.CommentCreateRequest;
import com.project.questApp.requests.CommentUpdateRequest;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;
	

	
	public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
		if (userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		} else if (userId.isPresent()){
			return commentRepository.findByUserId(userId.get());
		} else if (postId.isPresent()){
			return commentRepository.findByPostId(postId.get());
		} else 
			return commentRepository.findAll();
	}

	public Comment getOneComment(Long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}

	public Comment createOneComment(CommentCreateRequest newCommentRequest) {
		User user = userService.getOneUser(newCommentRequest.getUserId());
		Post post = postService.getOnePost(newCommentRequest.getPostId());
		if (user != null && post != null) {
			Comment commentToSave = new Comment();
			commentToSave.setId(newCommentRequest.getId());
			commentToSave.setPost(post);
			commentToSave.setUser(user);
			commentToSave.setText(newCommentRequest.getText());
			return commentRepository.save(commentToSave);
		}
		return null;
	}

	public Comment updateOneComment(Long commentId, CommentUpdateRequest comUpdRequest) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if (comment.isPresent()) {
			Comment commentToUpdate = comment.get();
			commentToUpdate.setText(comUpdRequest.getTitle());
			return commentRepository.save(commentToUpdate);
		}
		return null;
	}

	public void deleteOneComment(Long commentId) {
		commentRepository.deleteById(commentId);		
	}

}
