package StudyRoom.StudyRoom.service.admin;

import StudyRoom.StudyRoom.repository.roomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class changeReview {

    final roomRepository roomRepository;
    public boolean exist(String changeName) {

        if(roomRepository.findByroomName(changeName).isEmpty()==true){
            return false;
        }
        else {
            return true;
        }

    }

    @Transactional
    public void changeReview(String roomName,String roomInformation) {

        List rooms = roomRepository.findByroomName(roomName);
        StudyRoom.StudyRoom.entity.room room = (StudyRoom.StudyRoom.entity.room) rooms.get(0);

        room.setRoomInformation(roomInformation);


    }
}
