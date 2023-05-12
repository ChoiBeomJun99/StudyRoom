package StudyRoom.StudyRoom.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class roomDate extends BaseTimeEntity{

    @Id
    @GeneratedValue
    Long id;

    Date date;

    @ManyToOne
    @JoinColumn(name = "roomName")
    private room room;

}
