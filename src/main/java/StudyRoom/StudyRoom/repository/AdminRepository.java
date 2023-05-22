package StudyRoom.StudyRoom.repository;

import StudyRoom.StudyRoom.entity.Admin;
import StudyRoom.StudyRoom.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findById(String id);
}
