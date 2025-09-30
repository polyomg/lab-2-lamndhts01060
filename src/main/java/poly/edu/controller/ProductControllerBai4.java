package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import poly.edu.entity.Product;

import java.util.*;

@Controller
@RequestMapping("/product")
public class ProductControllerBai4 {

    // Danh sách sản phẩm mẫu (20 sp)
    @ModelAttribute("allProducts")
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

    // Hàm riêng xử lý phân trang
    private void addPagedProducts(Model model, int page, int size) {
        List<Product> products = getProducts();
        int start = page * size;
        int end = Math.min(start + size, products.size());
        List<Product> pageProducts = products.subList(start, end);
        int totalPages = (int) Math.ceil((double) products.size() / size);

        model.addAttribute("products", pageProducts);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
    }

    // Hiển thị form nhập + danh sách theo trang
    @GetMapping("/formbai4")
    public String form(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size) {
        Product p = new Product("iPhone 15", 30000.0);
        model.addAttribute("item", p);

        addPagedProducts(model, page, size); // gọi hàm chung
        return "product/formbai4";
    }

    // Lưu sản phẩm do user nhập từ form + hiện danh sách
    @PostMapping("/savebai4")
    public String save(@ModelAttribute("item") Product p,
                       Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size) {
        model.addAttribute("message", "Đã lưu sản phẩm: " + p.getName() + " - " + p.getPrice());

        addPagedProducts(model, page, size); // gọi hàm chung
        return "product/formbai4";
    }
}
