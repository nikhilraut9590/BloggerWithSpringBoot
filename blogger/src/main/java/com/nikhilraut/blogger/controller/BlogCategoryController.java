package com.nikhilraut.blogger.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhilraut.blogger.entity.BlogCategory;
import com.nikhilraut.blogger.exception.CategoryNotFoundException;
import com.nikhilraut.blogger.repository.IBlogCategoryRepository;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
public class BlogCategoryController {

	@Autowired
	IBlogCategoryRepository iBlogCategoryRepository;

	@GetMapping("category")
	public ResponseEntity<List<BlogCategory>> getAllBlogCategory() {
		List<BlogCategory> blogCategoryList = iBlogCategoryRepository.findAll();
		if (blogCategoryList.isEmpty())
			throw new CategoryNotFoundException("Sorry ! No category available.");
		return new ResponseEntity<List<BlogCategory>>(blogCategoryList, HttpStatus.OK);
	}

	@PostMapping("category")
	public ResponseEntity<String> createBlogCategories(@RequestBody BlogCategory blogCategory) throws Exception {
		BlogCategory newBlogCategory = iBlogCategoryRepository.save(blogCategory);
		if (newBlogCategory == null)
			throw new Exception();
		return new ResponseEntity<String>("New BLogCategory Added successfully.", HttpStatus.CREATED);
	}

	@GetMapping("category/{id}")
	public ResponseEntity<Optional<BlogCategory>> getBlogCategoryById(@PathVariable("id") int categoryId) {
		Optional<BlogCategory> BlogCategory = iBlogCategoryRepository.findById(categoryId);
		if (!BlogCategory.isPresent())
			throw new CategoryNotFoundException();
		return new ResponseEntity<>(BlogCategory, HttpStatus.FOUND);
	}

	@DeleteMapping("category/{id}")
	public ResponseEntity<String> deleteBlogCategory(@PathVariable(value = "id") Integer blogCategoryId) {
		BlogCategory blogCategory = iBlogCategoryRepository.findById(blogCategoryId)
				.orElseThrow(() -> new CategoryNotFoundException());
		iBlogCategoryRepository.delete(blogCategory);
		return new ResponseEntity<String>("BlogCategory deleted successfully.!", HttpStatus.OK);
	}

	@PutMapping("category/{id}")
	public ResponseEntity<BlogCategory> updateFeedback(@PathVariable(value = "id") Integer blogCategoryId,
			@Valid @RequestBody BlogCategory blogCategoryDetails) {
		BlogCategory blogCategory = iBlogCategoryRepository.findById(blogCategoryId)
				.orElseThrow(() -> new CategoryNotFoundException());
		blogCategory.setCategoryName(blogCategoryDetails.getCategoryName());
		BlogCategory updatedBlogCategory = iBlogCategoryRepository.save(blogCategory);
		return new ResponseEntity<BlogCategory>(updatedBlogCategory, HttpStatus.OK);
	}

}
