package br.edu.ifba.meublog.controles;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.meublog.entidades.Post;
import br.edu.ifba.meublog.repositorios.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostRepository postRepository;
	
	public PostController(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	public PostRepository getPostRepository() {
		return postRepository;
	}

	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@PostMapping
	public Post criarPost(@RequestBody Post post) {
		this.postRepository.save(post);
		return post;
	}
}
