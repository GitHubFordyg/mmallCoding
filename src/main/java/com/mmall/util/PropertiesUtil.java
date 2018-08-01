package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 */
public class PropertiesUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties props;

    // 设置静态代码块可以在Tomcat启动时读取到配置文件
    static {
        String fileName = "mmall.properties";
        props = new Properties();
        try {
            // PropertiesUtil.class.getClassLoader() 获取当前类的位置
            // getResourceAsStream(fileName), "UTF-8")) 获取输入流对象
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常", e);
        }
    }

//    // 执行优先级（ 静态代码块>普通代码块>构造代码块 ）
//    static {
//        // 这是静态代码块 (在类加载时执行且静态代码块只会执行一次)
//    }
//    {
//        // 这是普通代码块
//    }
//    public PropertiesUtil(){
//        // 这是构造代码块
//    }

    // 通过传入的key获取对应的value （trim()方法---去掉前后的空格）
    public static String getProperty(String key) {
        String value = props.getProperty(key.trim());
        // 判断value是否为空
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return value.trim();
    }

    // 通过传入的key获取对应的value，如果value是空，使用defaultValue作为返回值 （trim()方法---去掉前后的空格）
    public static String getProperty(String key, String defaultValue) {
        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            value = defaultValue;
        }
        return value.trim();
    }
}
