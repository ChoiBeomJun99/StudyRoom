package StudyRoom.StudyRoom.service.Impl;

import StudyRoom.StudyRoom.Room.LoginDTO;
import StudyRoom.StudyRoom.Room.SignUpDTO;
import StudyRoom.StudyRoom.entity.Member;
import StudyRoom.StudyRoom.repository.MemberRepository;
import StudyRoom.StudyRoom.security.WebSecurityConfig;
import StudyRoom.StudyRoom.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public ResponseEntity signUp(SignUpDTO memberDTO) throws IllegalArgumentException{

        WebSecurityConfig webSecurityConfig = new WebSecurityConfig();
        String new_password =  webSecurityConfig.getPasswordEncoder().encode(memberDTO.getPassword());

        Member member = Member.builder()
                .email(memberDTO.getEmail())
                .password(new_password)
                .name(memberDTO.getName())
                .build();

        try{
            memberRepository.save(member);
            return new ResponseEntity("회원가입에 성공하였습니다.", HttpStatus.OK);
        }catch(IllegalArgumentException e){
            return new ResponseEntity("회원가입에 실패하였습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity login(LoginDTO loginDTO) {

        Member member = memberRepository.findByEmail(loginDTO.getEmail());

        if (member == null){
            return new ResponseEntity("해당 아이디를 가진 회원이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        // 암호화같은거 신경 안씀
        if (member.getPassword().equals(loginDTO.getPassword())){
            return new ResponseEntity("로그인 되었습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity("회원 정보가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public Member getMemberByEmail(String email){
        Member member = memberRepository.findByEmail(email);

        return member;
    }
}
