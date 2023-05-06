package StudyRoom.StudyRoom.repository;

import StudyRoom.StudyRoom.entity.room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface roomRepository extends JpaRepository<room,Long> {

    List findByroomName(String roomName);
}
