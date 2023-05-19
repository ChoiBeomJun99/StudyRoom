package StudyRoom.StudyRoom.entity;

import jakarta.persistence.*;
import lombok.*;

import static StudyRoom.StudyRoom.entity.MemberRole.ADMIN;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ADMIN")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;


    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private MemberRole role = ADMIN;

}

