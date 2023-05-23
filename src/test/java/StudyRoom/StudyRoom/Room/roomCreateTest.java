package StudyRoom.StudyRoom.Room;

import StudyRoom.StudyRoom.repository.roomRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Rollback
@Transactional
class roomCreateTest {

    @Autowired roomRepository roomRepository;


    // 스터디 룸이 정상적으로 저장되는 경우

    @Test
    void 룸_생성_성공() {

        // given
        roomDto roomDto = new roomDto(roomRepository);
        String roomName = "test123";
        roomDto.create_room(roomName,10L,15000L,"test room 입니다");

        // when
        List test = roomRepository.findByroomName(roomName);

        // then
        Assertions.assertThat(test.isEmpty()==false);
    }


    // 스터디 룸이 중복인 경우

    @Test
    void 룸_생성_실패() {

        // given
        roomDto roomDto = new roomDto(roomRepository);
        String roomName = "test123";
        roomDto.create_room(roomName,10L,15000L,"test room 입니다");

        // when


        roomDto roomDto1 = new roomDto(roomRepository);
        roomDto.create_room(roomName,9L,1500L,"test room2 입니다");

        // then
        int room_count = roomRepository.findByroomName(roomName).size();
        Assertions.assertThat(room_count == 1);

    }
}