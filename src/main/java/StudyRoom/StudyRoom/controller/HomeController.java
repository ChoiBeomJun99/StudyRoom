package StudyRoom.StudyRoom.controller;

import StudyRoom.StudyRoom.repository.roomRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final roomRepository roomrepository;

    @GetMapping("/")
    public String home(Model model, HttpSession session){

        model.addAttribute("room",roomrepository.findAll());
        return "index";
    }
}
