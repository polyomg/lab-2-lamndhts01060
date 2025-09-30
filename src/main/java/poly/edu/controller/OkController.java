package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OkController {

    @RequestMapping("/ok")
    public String ok(Model model) {
        model.addAttribute("message", "Phương thức ok()");
        return "ok/ok";
    }

    @PostMapping("/ctrl/ok")
    public String m1(Model model) {
        model.addAttribute("message", "Phương thức m1()");
        return "ok/ok";
    }

    @GetMapping("/ctrl/ok2")
    public String m2(Model model) {
        model.addAttribute("message", "Phương thức m2()");
        return "ok/ok";
    }

    @PostMapping("/ctrl/ok/{x}")
    public String m3(@PathVariable("x") Integer x ,Model model) {
        model.addAttribute("message", "M3(): x=" + x);
        return "ok/ok";
    }
}
