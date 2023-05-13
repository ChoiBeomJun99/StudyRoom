package StudyRoom.StudyRoom.repository;

import StudyRoom.StudyRoom.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);

}
