package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {

    @RequestMapping("/a")
    public String m1() {
        return "result/a";
    }

    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/a"; // forward đến mapping /a, nó vẫn render result/a.html
    }

    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a"; // redirect về mapping /a
    }

    @RequestMapping("/d")
    @ResponseBody
    public String m4() {
        return "I come from d";
    }

}
