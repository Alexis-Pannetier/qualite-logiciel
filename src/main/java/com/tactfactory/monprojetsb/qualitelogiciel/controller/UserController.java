package com.tactfactory.monprojetsb.qualitelogiciel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tactfactory.monprojetsb.qualitelogiciel.entities.User;
import com.tactfactory.monprojetsb.qualitelogiciel.repositories.ProductRepository;
import com.tactfactory.monprojetsb.qualitelogiciel.repositories.UserRepository;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository repository;
	private ProductRepository productRepo;

	public UserController(UserRepository userRepository, ProductRepository productRepository) {
		this.repository = userRepository;
		this.productRepo = productRepository;
	}

	@RequestMapping(value = { "/index", "/" })
	public String index(Model model) {
		model.addAttribute("page", "User index");
		model.addAttribute("items", repository.findAll());
		return "user/index";
	}

	@GetMapping(value = { "/create" })
	public String createGet(Model model) {
		model.addAttribute("page", "User Create");
		model.addAttribute("products", productRepo.findAll());
		return "user/create";
	}

	@PostMapping(value = { "/create" })
	public String createPost(@ModelAttribute User user) {
		if (user != null) {
			repository.save(user);
		}
		return "redirect:index";
	}

	@PostMapping(value = { "/delete" })
	public String delete(Long id) {
		User user = repository.getOne(id);
		repository.delete(user);
		return "redirect:index";
	}

	@GetMapping(value = { "/show/{id}" })
	public String details(Model model, @PathVariable(value = "id") String id) {
		model.addAttribute("user", repository.getOne(Long.parseLong(id)));
		model.addAttribute("items", repository.getOne(Long.parseLong(id)).getProducts());
		return "user/detail";
	}
}
