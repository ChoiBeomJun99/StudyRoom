package StudyRoom.StudyRoom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;

@Entity
@Getter
public class room {

    @Id @GeneratedValue
    Long roomId;

    // 스터디 룸 이름
    String roomName;

    // 수용 가능 인원
    Long roomPerson;

    // 스터디 룸 가격
    Long roomPrice;

    // 스터티 룸 설명
    @Lob
    String roomInformation;


    public room(String roomName, Long roomPerson, Long roomPrice, String roomInformation) {
        this.roomName = roomName;
        this.roomPerson = roomPerson;
        this.roomPrice = roomPrice;
        this.roomInformation = roomInformation;
    }

    public room() {

    }
}
