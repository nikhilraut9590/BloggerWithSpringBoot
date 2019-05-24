package com.nikhilraut.blogger;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BloggerApplicationTests {

	/*@LocalServerPort
	int randomServerPort;

	@Test
	public void testGetBlogListsuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseURL = "http://localhost:" + randomServerPort + "/api/blog";
		URI uri = new URI(baseURL);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assert.assertEquals(200, result.getStatusCodeValue());
		
	}
*/
}
