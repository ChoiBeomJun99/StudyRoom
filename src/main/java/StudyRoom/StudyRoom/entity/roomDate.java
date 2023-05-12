package StudyRoom.StudyRoom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class roomDate extends BaseTimeEntity{

    @Id
    @GeneratedValue
    Long roomId;


    Date date;
}
