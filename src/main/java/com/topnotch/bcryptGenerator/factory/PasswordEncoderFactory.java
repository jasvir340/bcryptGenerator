package com.topnotch.bcryptGenerator.factory;

import com.topnotch.bcryptGenerator.model.HashingAlgorithm;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * Factory for {@link PasswordEncoder} implementations.
 */
public final class PasswordEncoderFactory {

    private PasswordEncoderFactory() {
        // Utility class
    }

    /**
     * Create a {@link PasswordEncoder} for the given algorithm.
     *
     * @param algorithm the desired algorithm
     * @return an appropriate {@link PasswordEncoder}
     */
    public static PasswordEncoder create(HashingAlgorithm algorithm) {
        if (algorithm == null) {
            throw new IllegalArgumentException("algorithm must not be null");
        }
        switch (algorithm) {
            case SCRYPT:
                return new SCryptPasswordEncoder();
            case PBKDF2:
                return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
            case ARGON2:
                return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
            case NOOP:
                return NoOpPasswordEncoder.getInstance();
            case BCRYPT:
            default:
                return new BCryptPasswordEncoder();
        }
    }
}
