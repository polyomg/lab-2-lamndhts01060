package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ParamController {
	@RequestMapping("/param/form")
    public String form() {
        return "param/form"; // trả về form.html trong folder param
    }
	
	@RequestMapping("/param/save/{x}")
    public String save(
            @PathVariable("x") String x,
            @RequestParam("y") String y, 
            @RequestParam("z") String z,
            Model model) {
        
        // đưa dữ liệu ra view
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("z", z);
        
        return "param/form";
    }
}
