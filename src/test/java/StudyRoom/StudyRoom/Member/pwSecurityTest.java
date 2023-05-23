package StudyRoom.StudyRoom.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional

public class pwSecurityTest {

    @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
    @Test
    public void 암호화_매치_테스트(){

        String origin_pw = "1234";
        String secure_pw = bCryptPasswordEncoder.encode(origin_pw);

        Assertions.assertThat(bCryptPasswordEncoder.matches(origin_pw,secure_pw)==true);

    }
}
