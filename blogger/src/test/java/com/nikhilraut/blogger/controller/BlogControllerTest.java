package com.nikhilraut.blogger.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nikhilraut.blogger.entity.Blog;
import com.nikhilraut.blogger.exception.BlogNotFoundException;
import com.nikhilraut.blogger.repository.IBlogRepository;

@RunWith(SpringRunner.class)
// @WebMvcTest(value = BlogController.class, secure = false)
public class BlogControllerTest {

	private MockMvc mockMvc;
	@InjectMocks
	private BlogController blogController;
	@Mock
	private IBlogRepository blogRepository;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
	}

	@Test
	public void should_return_all_blogs() throws Exception {
		Blog blog1 = new Blog(101, "angular", "angular js", "angular.jpg", true, false, new Date(), new Date());
		List<Blog> list = new ArrayList<>();
		list.add(blog1);

		Mockito.when(blogRepository.findAll()).thenReturn(list);
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8088/api/blog"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void should_return_blog_based_on_blog_id() throws Exception {
		String jsonString = "{\n" + "\"id\":1,\n" + "\"title\":\"Spring boot\",\n" + "\"description\":\"dnsbnsdgjb\"\n"
				+ "\"image\":\"springboot.jp\"\n" + "\"is_featured\":\"false\"\n" + "\"is_active\":\"true\"\n" + "}";

		Blog blog = new Blog(1, "angular", "angular js", "angular.jpg", true, false, new Date(), new Date());
		Optional<Blog> blog2 = Optional.of(blog);
		Mockito.when(blogRepository.findById(1)).thenReturn(blog2);
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8088/api/blog/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	public void should_return_not_found_exception_if_blogs_does_not_exists() throws Exception{
//		Blog blog1 = new Blog(101, "angular", "angular js", "angular.jpg", true, false, new Date(), new Date());
		List<Blog> list = new ArrayList<>();
		//list.add(blog1);
		
		Mockito.when(blogRepository.findAll()).thenThrow(new BlogNotFoundException("blog not found"));
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8088/api/blog"))
		.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
}
