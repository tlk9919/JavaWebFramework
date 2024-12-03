package com.starwisper.repository;

import com.starwisper.model.VerificationCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerificationCodeRepository extends MongoRepository<VerificationCode, String> {
    VerificationCode findByEmail(String email);
}
