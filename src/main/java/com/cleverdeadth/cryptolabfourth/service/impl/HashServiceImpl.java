package com.cleverdeadth.cryptolabfourth.service.impl;

import com.cleverdeadth.cryptolabfourth.service.HashService;

public class HashServiceImpl implements HashService {
    public static final int FNV_PRIME = 0x1000193;
    public static final int FNV_OFFSET_BASIC = 0x811C9DC5;

    @Override
    public String generateHash(String text) {
        int hash = FNV_OFFSET_BASIC;
        for (int i = 0; i < text.length(); i++) {
            hash ^= text.charAt(i);
            hash *= FNV_PRIME;
        }
        return Integer.toHexString(hash);
    }
}
