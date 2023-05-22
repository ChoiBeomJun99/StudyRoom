package StudyRoom.StudyRoom.controller;

import StudyRoom.StudyRoom.Room.LoginDTO;
import StudyRoom.StudyRoom.Room.SignUpDTO;
import StudyRoom.StudyRoom.entity.Member;
import StudyRoom.StudyRoom.entity.MemberRole;
import StudyRoom.StudyRoom.repository.MemberRepository;
import StudyRoom.StudyRoom.security.WebSecurityConfig;
import StudyRoom.StudyRoom.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static StudyRoom.StudyRoom.utils.ValidationRegex.isRegexEmail;


@RequiredArgsConstructor
@Controller
public class MemberController {


    @Autowired
    private final MemberService memberService;
    final MemberRepository memberRepository;
    final PasswordEncoder pwEncoder;


    @GetMapping("/signUp")
    public String signUpPage() { return "member/signUp"; }

    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }


    @PostMapping("/signUp")
    public ResponseEntity signUp(@ModelAttribute SignUpDTO signUpDTO, Model model){
        if(!isRegexEmail(signUpDTO.getEmail())){
            return new ResponseEntity("Invalid email format", HttpStatus.BAD_REQUEST);
        }

        ResponseEntity response = memberService.signUp(signUpDTO);

        if (response.getStatusCode() == HttpStatus.OK) {
            model.addAttribute("success", response.getBody().toString());
            return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/login").build();
        } else {
            model.addAttribute("error", response.getBody().toString());
            return response;
        }
    }

    // 로그인
    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpSession session, Model model) {

        // 복호화 후 비밀번호 비교 기능 필요

        String origin_pw = pwEncoder.encode(loginDTO.getPassword());
        String secure_pw = memberRepository.findByEmail(loginDTO.getEmail()).getPassword();

        System.out.println(origin_pw);
        System.out.println(secure_pw);

        System.out.println(pwEncoder.matches(origin_pw,secure_pw));

        ResponseEntity response = memberService.login(loginDTO);

        if (response.getStatusCode() == HttpStatus.OK) {

            Member member = memberService.getMemberByEmail(loginDTO.getEmail());

            session.setAttribute("member", member);
            model.addAttribute("member", member);

            return "redirect:/";

        } else {
            model.addAttribute("error", response.getBody().toString());

            return "member/login";
        }

    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        
        request.getSession().removeAttribute("member");

        return "redirect:/";
    }
}
