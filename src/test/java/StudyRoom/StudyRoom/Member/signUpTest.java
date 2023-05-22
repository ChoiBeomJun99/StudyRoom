package StudyRoom.StudyRoom.Member;

import StudyRoom.StudyRoom.entity.Member;
import StudyRoom.StudyRoom.entity.MemberRole;
import StudyRoom.StudyRoom.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback
class signUpTest {
    @Autowired
    MemberRepository repository;

    @Test
    public void testMember() {
        Member member = new Member(
                null, "hello@naver.com", "hello", "hello", MemberRole.USER
        );

        repository.save(member);

        Member findMember = repository.findByEmail(member.getEmail());

        assertEquals(findMember.getName(), member.getName());
        assertEquals(findMember.getRole(), member.getRole());
        assertEquals(findMember, member);
    }
}