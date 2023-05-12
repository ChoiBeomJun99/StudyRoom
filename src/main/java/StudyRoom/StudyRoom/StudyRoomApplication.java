package StudyRoom.StudyRoom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudyRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyRoomApplication.class, args);
	}

}
