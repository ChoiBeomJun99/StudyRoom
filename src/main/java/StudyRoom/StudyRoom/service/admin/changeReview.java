package StudyRoom.StudyRoom.service.admin;

import StudyRoom.StudyRoom.repository.roomRepository;
import lombok.RequiredArgsConstructor;

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
}
