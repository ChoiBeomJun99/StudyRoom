package StudyRoom.StudyRoom.Dto;

import StudyRoom.StudyRoom.entity.room;
import StudyRoom.StudyRoom.repository.roomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class roomDto {

    final roomRepository roomRepository;

    String roomName;

    Long roomPerson;

    Long roomPrice;

    String roomInformation;



    // 새로운 스터디 룸 저장
    @Transactional
    public void create_room(String roomName, Long roomPerson, Long roomPrice, String roomInformation){


        this.roomName = roomName;
        this.roomPerson = roomPerson;
        this.roomPrice = roomPrice;
        this.roomInformation = roomInformation;

        room new_room = new room(roomName,roomPerson,roomPrice,roomInformation);
        roomRepository.save(new_room);

    }
}
