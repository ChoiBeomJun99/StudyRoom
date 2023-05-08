package StudyRoom.StudyRoom.Room;

import StudyRoom.StudyRoom.repository.roomRepository;
import StudyRoom.StudyRoom.service.admin.removeRoom;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class roomRemoveTest {
    @Autowired
    StudyRoom.StudyRoom.repository.roomRepository roomRepository;


    // 스터디 룸이 정상적으로 제거 되는 경우

    @Test
    void 룸_제거_성공() {

        // given
        roomDto roomDto = new roomDto(roomRepository);
        String roomName = "test123";
        roomDto.create_room(roomName,10L,15000L,"test room 입니다");

        // when
        removeRoom removeRoom = new removeRoom(roomRepository);

        // then

        Assertions.assertThat(removeRoom.removeRoom(roomName)==true);
        Assertions.assertThat(roomRepository.findByroomName(roomName).isEmpty()==true);


    }

    @Test
    void 룸_제거_실패() {

        // given
        String roomName = "test123";
        // when
        removeRoom removeRoom = new removeRoom(roomRepository);

        // then

        Assertions.assertThat(roomRepository.findByroomName(roomName).isEmpty()==false);


    }

}
