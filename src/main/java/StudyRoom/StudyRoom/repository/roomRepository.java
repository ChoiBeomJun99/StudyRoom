package StudyRoom.StudyRoom.repository;

import StudyRoom.StudyRoom.entity.room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface roomRepository extends JpaRepository<room,Long> {
}
