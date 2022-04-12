package com.monkeysh.blogs;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MonkeyshBlogsApplicationTests {

    private Logger LOGGER = LoggerFactory.getLogger(MonkeyshBlogsApplicationTests.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void contextLoads() {
        final String encodedPassword = bCryptPasswordEncoder.encode("1234");
        LOGGER.info("encoded password : {}", encodedPassword);

    }

}
