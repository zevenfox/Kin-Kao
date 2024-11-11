package ku.kinkao.service;

import ku.kinkao.dto.SignupRequest;
import ku.kinkao.entity.Member;
import ku.kinkao.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

@Service
public class SignupService {


    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private MemberRepository repository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }


    public void createMember(SignupRequest dto) {
        Member dao = modelMapper.map(dto, Member.class);
        dao.setCreatedAt(Instant.now());
        dao.setRole("ROLE_USER");


        String hashedPassword = passwordEncoder.encode(dto.getPassword());


        dao.setPassword(hashedPassword);


        repository.save(dao);
    }


    public Member getMember(String username) {
        return repository.findByUsername(username);
    }
}
