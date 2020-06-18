package com.ctrip.framework.apollo.configservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

@Configuration
@ConditionalOnProperty(name = "apollo.crypto.encrypt.key", matchIfMissing = false)
public class ConfigServerEncryptConfigure {
    @Value("${apollo.crypto.encrypt.key}")
    String key;
    @Value("${apollo.crypto.encrypt.salt:deadbeef}")
    String salt;
    @Bean
 public TextEncryptor textEncryptor(){
     return Encryptors.text(key, salt);
 }
}
