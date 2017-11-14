package com.haj.zuulfoos;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class FooController {

	private List<Foo> foos = new ArrayList<>();

	@RequestMapping("/foos/random")
	public Foo findRandom() {
		Random random = new Random();
		final Foo foo = new Foo(random.nextLong(), "Created randomly");
		this.foos.add(foo);
		return foo;
	}

	@RequestMapping("/foos/{id}")
	public Foo findById(@PathVariable long id) {
		final Foo foo = new Foo(id, "Created by findById");
		this.foos.add(foo);
		return foo;
	}

	@RequestMapping("/foos")
	public List<Foo> findAll() {

		if(this.foos.isEmpty()) {
			findRandom();
			findRandom();
			findRandom();
		}
		return this.foos;
	}
}
