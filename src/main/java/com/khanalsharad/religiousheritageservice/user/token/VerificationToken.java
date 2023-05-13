package com.khanalsharad.religiousheritageservice.user.token;

import com.khanalsharad.religiousheritageservice.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.security.interfaces.RSAKey;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
public class VerificationToken {
    //expiration time 10 min
    private static final int EXPIRATION_TIME =10;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date expirationTime;
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id",
    nullable = false,
    foreignKey = @ForeignKey(name="FK_USER_VERIFY_TOKEN"))
    private User user;

    public VerificationToken(User user, String token){
        super();
        this.user= user;
        this.token=token;
        this.expirationTime= calculateExpirationDate(EXPIRATION_TIME);
    }
    private Date calculateExpirationDate(int expirationTime){
        Calendar calendar =Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,expirationTime);
        return  new Date(calendar.getTime().getYear());
    }
}
