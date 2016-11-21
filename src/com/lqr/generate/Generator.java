package com.lqr.generate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @author CSDN_LQR
 * @工程 mybatis_generate 
 * @包名 mybatis_generate
 * @TODO Mybatis的逆向生成工具
 * 
 * 		需要的jar包：
 * 		需要的配置文件：generatorConfig.xml
 * 
 * 		配置文件需要修改的地方：
 * 			1、修改数据库的连接信息
 * 			2、修改包名：PO类，Mapper映射文件、Mapper接口的包名（targetPackage）
 * 			3、指定数据库表（table）
 */
public class Generator {

	/**
	 * 使用前，需要删除之前生成过的代码。（逆向工程生成出来的代码是以追加形式生成的，若不删除，则会报错）
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("config/generatorConfig.xml");//配置文件路径
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
	}

}
