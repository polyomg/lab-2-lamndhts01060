package poly.edu.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.edu.entity.*;

@Controller
public class ProductControllerThem {

	private List<Product> items = new ArrayList<>();

	public ProductControllerThem() {
		items.add(new Product("A", 1.0));
		items.add(new Product("B", 12.0));
	}

	@GetMapping("/product/formmoi")
	public String form(Model model) {
	    Product p = new Product();
	    p.setName("iPhone 30");
	    p.setPrice(5000.0);
	    model.addAttribute("p1", p);
	    return "product/formthem";
	}

	@PostMapping("/product/savemoi")
	public String save(@ModelAttribute("p2") Product p, Model model) {
	    items.add(p);
	    model.addAttribute("p2", p);
	    model.addAttribute("items", items);

	    Product p1 = new Product("iPhone 30", 5000.0);
	    model.addAttribute("p1", p1);

	    return "product/formthem";
	}


	@ModelAttribute("items")
	public List<Product> getItems() {
		return items;
	}
}