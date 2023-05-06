package StudyRoom.StudyRoom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class room {

    @Id @GeneratedValue
    Long roomId;

    // 스터디 룸 가격
    Long roomPrice;

    // 수용 가능 인원
    Integer roomPerson;

    // 스터티 룸 설명
    @Lob
    String information;




}
