package ku.kinkao.entity;

import ku.kinkao.config.AttributeEncryptor;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Convert;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class Member {


    @Id
    @GeneratedValue
    private UUID id;


    private String username;
    private String password;


    @Convert(converter = AttributeEncryptor.class)
    private String firstName;


    @Convert(converter = AttributeEncryptor.class)
    private String lastName;


    @Convert(converter = AttributeEncryptor.class)
    private String email;


    private String role;
    private Instant createdAt;
}
