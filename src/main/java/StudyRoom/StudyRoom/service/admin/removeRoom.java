package StudyRoom.StudyRoom.service.admin;

import StudyRoom.StudyRoom.repository.roomRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class removeRoom {

    final roomRepository roomRepository;
    public boolean removeRoom(String remove_name){

        boolean remove = false;

        // 존재하지 않는 룸이면
        if(roomRepository.findByroomName(remove_name).isEmpty()==true){
            return false;
        }

        // 룸 정상 제거 시
        else{
            List room = roomRepository.findByroomName(remove_name);
            roomRepository.delete((StudyRoom.StudyRoom.entity.room) room.get(0));

            return true;
        }
    }
}
