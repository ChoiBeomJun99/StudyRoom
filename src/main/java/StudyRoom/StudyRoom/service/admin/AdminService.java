package StudyRoom.StudyRoom.service.admin;

import StudyRoom.StudyRoom.Room.AdminLoginDTO;
import StudyRoom.StudyRoom.entity.Admin;
import StudyRoom.StudyRoom.entity.Member;
import StudyRoom.StudyRoom.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public ResponseEntity login(AdminLoginDTO adminLoginDTO) {

        Admin admin = adminRepository.findById(adminLoginDTO.getId());
        if (admin == null){
            return new ResponseEntity("해당 아이디를 가진 관리자가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        if (admin.getPassword().equals(adminLoginDTO.getPassword())){
            return new ResponseEntity("로그인 되었습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity("관리자 정보가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    public Admin getAdminById(String id){
        Admin admin = adminRepository.findById(id);

        return admin;
    }
}
