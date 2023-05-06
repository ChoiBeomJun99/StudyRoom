package StudyRoom.StudyRoom.repository;

import StudyRoom.StudyRoom.entity.reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reservationRepository extends JpaRepository<reservation,Long> {
}
