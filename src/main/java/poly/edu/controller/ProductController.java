package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.edu.entity.Product;

@Controller
public class ProductController {

    @GetMapping("/product/form")
    public String form(Model model) {
    	// Khởi tạo product rỗng 
        model.addAttribute("product", new Product());
        return "product/form"; // form.html nằm trong /templates/product/
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product product, Model model) {
    	// Sau khi submit form, product sẽ nhận dữ liệu từ form.html
        model.addAttribute("product", product);
        return "product/form"; // quay lại form.html để hiển thị
    }
}

