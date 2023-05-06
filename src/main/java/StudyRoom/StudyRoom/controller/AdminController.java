package StudyRoom.StudyRoom.controller;

import StudyRoom.StudyRoom.repository.reservationRepository;
import StudyRoom.StudyRoom.repository.roomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    final reservationRepository reservationRepository;
    final roomRepository roomRepository;

    // 관리자 메인 페이지

    @GetMapping("/admin")
    public String AdminMain(Model model){

        // 관리자 인증 기능 구현 필요


        // 인증 성공 시 -> model 에 현재 존재하는 방 리스트를 담아주어서 return 해준다

        model.addAttribute("room",roomRepository.findAll());

        return "admin/main";

        // 인증 실패 시

    }


    // 스터디룸 추가

    @GetMapping("/admin/add")
    public String AddRoom(){
        return "admin/add";
    }


    @PostMapping("/admin/add")
    public String AddRoom(@RequestParam("add_id") Long add_id){

        // 이미 존재하는 룸이면
        if(roomRepository.findById(add_id) != null){

            // 이미 존재하는 룸인 알림 표시 후 redirect
            return "redirect://admin/main";
        }

        // 룸 정상 추가 성공 시
        else{

            return "admin/main";
        }

    }

    // 스터디룸 제거

    @PostMapping("/admin/remove")
    public String RemoveRoom(@RequestParam("remove_id") String remove_id){

        // 존재하지 않는 룸이면

        // 룸 정상 제거 시

        return "admin/main";
    }

    // 스터디룸 설명 변경

    @GetMapping("/admin/change")
    // Pathvariable 로 변수 받기
    public String ChangeRoom(){


        return "00";
    }



}