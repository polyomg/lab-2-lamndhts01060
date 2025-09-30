package poly.edu.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.entity.Product;

@Controller
@RequestMapping("/product")   // <== thêm cái này
public class ProductControllerBai6 {

    @ModelAttribute("allProducts")   // đổi tên tránh đè "products"
    public List<Product> getProducts() {
        return Arrays.asList(
            new Product("iPhone 15", 30000.0),
            new Product("Samsung Galaxy S23", 25000.0),
            new Product("Xiaomi 13", 18000.0),
            new Product("Oppo Reno10", 15000.0),
            new Product("Vivo V27", 14000.0),
            new Product("Nokia X30", 12000.0),
            new Product("Sony Xperia 1 V", 28000.0),
            new Product("Asus ROG Phone 7", 32000.0),
            new Product("OnePlus 11", 26000.0),
            new Product("Realme GT Neo 5", 17000.0),
            new Product("Huawei P60 Pro", 29000.0),
            new Product("Google Pixel 7 Pro", 27000.0),
            new Product("Motorola Edge 40", 16000.0),
            new Product("Xiaomi Redmi Note 12", 9000.0),
            new Product("Samsung A54", 11000.0),
            new Product("Oppo Find N2 Flip", 33000.0),
            new Product("Vivo Y36", 8000.0),
            new Product("Honor Magic 5", 21000.0),
            new Product("ZTE Nubia Z50", 20000.0),
            new Product("Infinix Zero Ultra", 13000.0)
        );
    }

    @GetMapping("/listbai6")
    public String listBai6(Model model,
                           @RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "5") int size) {
        List<Product> allProducts = getProducts();

        int totalPages = (int) Math.ceil((double) allProducts.size() / size);

        int start = (page - 1) * size;
        int end = Math.min(start + size, allProducts.size());

        List<Product> pageProducts = allProducts.subList(start, end);

        model.addAttribute("products", pageProducts);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "product/listbai6"; // trỏ tới templates/product/listbai6.html
    }
}
