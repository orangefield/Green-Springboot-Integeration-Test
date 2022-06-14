package site.orangefield.seoulweather.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.orangefield.seoulweather.domain.Seoul;
import site.orangefield.seoulweather.domain.SeoulRepository;

@RequiredArgsConstructor
@Controller
public class SeoulController {

    private final SeoulRepository seoulRepository;

    @GetMapping("/")
    public String main(Model model) {
        List<Seoul> seouls = seoulRepository.findAll();

        model.addAttribute("seouls", seouls);
        return "main";
    }
}
