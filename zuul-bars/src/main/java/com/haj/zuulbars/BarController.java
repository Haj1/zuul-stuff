package com.haj.zuulbars;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class BarController {

	private List<Bar> bars = new ArrayList<>();

	@RequestMapping("/bars/random")
	public Bar findRandom() {
		Random random = new Random();
		final Bar bar = new Bar(random.nextInt(), 1);
		this.bars.add(bar);
		return bar;
	}

	@RequestMapping("/bars/{id}")
	public Bar findById(@PathVariable int id) {
		final Bar bar = new Bar(id, 2);
		this.bars.add(bar);
		return bar;
	}

	@RequestMapping("/bars")
	public List<Bar> findAll() {

		if(this.bars.isEmpty()) {
			findRandom();
			findRandom();
			findRandom();
		}
		return this.bars;
	}
}
