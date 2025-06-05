package com.topnotch.bcryptGenerator.factory;

import com.topnotch.bcryptGenerator.model.HashingAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncoderFactoryTests {

    @Test
    void testFactoryCreatesEncoders() {
        PasswordEncoder bcrypt = PasswordEncoderFactory.create(HashingAlgorithm.BCRYPT);
        assertNotNull(bcrypt);

        PasswordEncoder scrypt = PasswordEncoderFactory.create(HashingAlgorithm.SCRYPT);
        assertNotNull(scrypt);

        PasswordEncoder pbkdf2 = PasswordEncoderFactory.create(HashingAlgorithm.PBKDF2);
        assertNotNull(pbkdf2);

        PasswordEncoder argon2 = PasswordEncoderFactory.create(HashingAlgorithm.ARGON2);
        assertNotNull(argon2);

        PasswordEncoder noop = PasswordEncoderFactory.create(HashingAlgorithm.NOOP);
        assertNotNull(noop);
    }
}
