package StudyRoom.StudyRoom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class reservation extends BaseTimeEntity{

    // 예약일 기본 키
    @Id @GeneratedValue
    Long possibleDtid;

    // 예약 가능 일자
    Date possibleRoomDt;

    Long roomId;



}
