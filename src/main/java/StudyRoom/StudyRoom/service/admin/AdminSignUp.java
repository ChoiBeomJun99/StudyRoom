package StudyRoom.StudyRoom.service.admin;

import StudyRoom.StudyRoom.entity.Admin;
import StudyRoom.StudyRoom.entity.MemberRole;
import StudyRoom.StudyRoom.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Component
public class AdminSignUp implements CommandLineRunner {

    final AdminRepository adminRepository;
    @Override
    public void run(String... args) throws Exception {
        Admin admin = new Admin(1L,"admin@naver.com","1234", MemberRole.ADMIN);

        adminRepository.save(admin);
    }
}
