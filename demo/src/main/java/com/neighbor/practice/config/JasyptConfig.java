package com.neighbor.practice.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Jasypt Config
 * @author ByungSung Min(bsmin@neighbor21.co.kr)
 * @version 1.0
 * @since 2020.07.09
 */
@Configuration
public class JasyptConfig {

	protected static final String ENCRYPT_KEY = "1exTMS!";
	
	@Bean("jasyptStringEncrptor") 
	public StringEncryptor stringEncryptor(){
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword(ENCRYPT_KEY);
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setProviderName("SunJCE");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");
		encryptor.setConfig(config); return encryptor;
	}

}
