package com.starwisper.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "verification_codes")
public class VerificationCode {

    @Id
    private String id;
    private String email;
    private String code;
    private Date expires;
}
