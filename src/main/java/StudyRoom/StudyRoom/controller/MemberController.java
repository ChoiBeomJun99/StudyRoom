package StudyRoom.StudyRoom.controller;

import StudyRoom.StudyRoom.Room.LoginDTO;
import StudyRoom.StudyRoom.Room.SignUpDTO;
import StudyRoom.StudyRoom.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static StudyRoom.StudyRoom.utils.ValidationRegex.isRegexEmail;

@RequiredArgsConstructor
@Controller
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @GetMapping("/signUp")
    public String signUpPage() { return "member/signUp"; }

    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }

    @PostMapping("/signUp")
    public ResponseEntity signUp(@ModelAttribute SignUpDTO signUpDTO){
        if(!isRegexEmail(signUpDTO.getEmail())){
            return new ResponseEntity("Invalid email format", HttpStatus.BAD_REQUEST);
        }

        ResponseEntity response = memberService.signUp(signUpDTO);

        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/login").build();
        } else {
            return response;
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@ModelAttribute LoginDTO loginDTO){
        ResponseEntity response = memberService.login(loginDTO);

        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/").build();
        } else {
            return response;
        }
    }
}
