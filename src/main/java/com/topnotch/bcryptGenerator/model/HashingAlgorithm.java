package com.topnotch.bcryptGenerator.model;

/**
 * Supported hashing algorithms.
 */
public enum HashingAlgorithm {
    BCRYPT,
    SCRYPT,
    PBKDF2,
    ARGON2,
    NOOP
}
