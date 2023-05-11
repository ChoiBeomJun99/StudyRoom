package StudyRoom.StudyRoom.controller;


import StudyRoom.StudyRoom.Room.roomDto;
import StudyRoom.StudyRoom.entity.room;
import StudyRoom.StudyRoom.repository.reservationRepository;
import StudyRoom.StudyRoom.repository.roomRepository;
import StudyRoom.StudyRoom.service.admin.changeReview;
import StudyRoom.StudyRoom.service.admin.removeRoom;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        // 인증 실패 시


        // 인증 성공 시

        model.addAttribute("room",roomRepository.findAll());
        return "admin/main";

    }
    // 스터디룸 추가
    @GetMapping("/admin/add")
    public String AddRoom(){
        return "admin/add";
    }
    @PostMapping("/admin/add")
    public String AddRoom(@RequestParam("add_name") String add_name,@RequestParam("add_person") Long add_person,
                          @RequestParam("add_price") Long add_price, @RequestParam("add_information") String add_information,Model model ){

        // 룸 정상 추가 성공 시

        if(roomRepository.findByroomName(add_name).isEmpty()){

            roomDto roomDto = new roomDto(roomRepository);
            roomDto.create_room(add_name,add_person,add_price,add_information);

            return "redirect:/admin";
        }

        // 이미 존재하는 룸이면

        else{
            model.addAttribute("add_fail","이미 존재하는 스터디 룸 입니다.");
            return "admin/alert/add_fail";
        }
    }

    // 스터디룸 제거
    @PostMapping("/admin/remove")
    public String RemoveRoom(@RequestParam("remove_name") String remove_name,Model model){

        removeRoom removeRoom = new removeRoom(roomRepository);

        // 존재하지 않는 룸이면

        if(removeRoom.removeRoom(remove_name)==false){

            model.addAttribute("remove_fail","존재하지 않는 스터디 룸 입니다.");
            return "admin/alert/remove_fail";
        }

        // 룸 정상 제거 시

        else{
            model.addAttribute("remove_success",remove_name + " 룸이 제거되었습니다.");
            return "admin/alert/remove_success";
        }

    }

    // 스터디룸 설명 변경
    @GetMapping("/admin/change") // 왜 url 뒤에 change_name 이 붙는지?
    public String GetChangeRoom(@RequestParam("change_name") String change_name, Model model){

        changeReview changeReview = new changeReview(roomRepository);

        // 존재하지 않는 스터디 룸인 경우

        if(changeReview.exist(change_name)==false){
            model.addAttribute("change_fail","존재하지 않는 스터디 룸 입니다.");
            return "admin/alert/change_fail";
        }

        // 존재하는 스터디 룸인 경우

        List rooms = roomRepository.findByroomName(change_name);
        room room = (StudyRoom.StudyRoom.entity.room) rooms.get(0);

        model.addAttribute("roomName",change_name);
        model.addAttribute("roomInformation",room.getRoomInformation());

        return "admin/change";
    }


    @PostMapping("/admin/change")
    @Transactional
    public String PostChangeRoom(@RequestParam("roomName") String roomName, @RequestParam("roomInformation") String roomInformation){

        changeReview changeReview = new changeReview(roomRepository);
        changeReview.changeReview(roomName,roomInformation);



        return "redirect:/admin";
    }

}
