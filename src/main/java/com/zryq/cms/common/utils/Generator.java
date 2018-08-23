package com.zryq.cms.common.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark
 */
public class Generator {
	public static void main(String[] args) {
		List<String> warnings = new ArrayList<>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config;
		try {
			config = cp.parseConfiguration(Generator.class
					.getResourceAsStream("/generator/generatorConfig.xml"));
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					callback, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}