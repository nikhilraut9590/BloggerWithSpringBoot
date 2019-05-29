package com.nikhilraut.blogger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhilraut.blogger.entity.Blog;
import com.nikhilraut.blogger.exception.BlogNotFoundException;
import com.nikhilraut.blogger.repository.IBlogRepository;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class BlogController {

	List<Blog> blogList = new ArrayList<>();

	@Autowired
	IBlogRepository blogRepository;

	// get all blogs list
	@GetMapping("/blog")
	public ResponseEntity<List<Blog>> getAllBlogs() throws BlogNotFoundException{
		List<Blog> blogList = blogRepository.findAll();
		if (blogList.isEmpty())
			throw new BlogNotFoundException();
		return new ResponseEntity<>(blogList, HttpStatus.OK);
	}

	@PostMapping("/blog")
	public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) throws Exception {
		Optional<Blog> blog1 = blogRepository.findById(blog.getId());	
		if(blog1.isPresent()){
			throw new Exception("Already exist");
		}
		return new ResponseEntity<Blog>(blogRepository.save(blog), HttpStatus.CREATED);
	}

	// get blog by id
	@GetMapping("/blog/{id}")
	public ResponseEntity<?> getBlogById(@PathVariable(value = "id") Integer blogId) {
		Blog blog = blogRepository.findById(blogId).orElseThrow(
				() -> {
					return new BlogNotFoundException("ID+: " + blogId);
				});
		/*if (!blog.isPresent())
			throw new BlogNotFoundException("ID+: " + blogId);
		*/
		return new ResponseEntity<>(blog, HttpStatus.OK);

	}

	@DeleteMapping("/blog/{id}")
	public ResponseEntity<?> deleteBlog(@PathVariable(value = "id") Integer blogId) {
		Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new BlogNotFoundException());
		blogRepository.delete(blog);
		return ResponseEntity.ok().build();
	}

	// Update a Note
	@PutMapping("/blog/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable(value = "id") Integer blogId,
			@Valid @RequestBody Blog blogDetails) {

		Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new BlogNotFoundException());

		blog.setTitle(blogDetails.getTitle());
		blog.setDescription(blogDetails.getDescription());
		blog.setIs_featured(blogDetails.isIs_featured());
		blog.setIs_active(blogDetails.isIs_active());
		blog.setImage(blogDetails.getImage());

		Blog updatedBlog = blogRepository.save(blog);
		return new ResponseEntity<Blog>(updatedBlog, HttpStatus.OK);
	}

}
