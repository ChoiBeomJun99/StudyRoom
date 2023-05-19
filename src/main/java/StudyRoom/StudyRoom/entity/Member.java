package StudyRoom.StudyRoom.entity;

import jakarta.persistence.*;
import lombok.*;

import static StudyRoom.StudyRoom.entity.MemberRole.USER;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER")
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private MemberRole role = USER;

}

