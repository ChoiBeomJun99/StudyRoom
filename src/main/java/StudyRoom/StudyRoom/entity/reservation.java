package StudyRoom.StudyRoom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class reservation {

    // 예약일 기본 키
    @Id @GeneratedValue
    Long possibleDtid;

    Date possibleRoomDt;

    Long roomId;



}
