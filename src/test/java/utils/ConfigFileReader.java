package utils;

import enums.DriverType;
import enums.EnvironmentType;
import org.springframework.stereotype.Component;

@Component
public class ConfigFileReader {
private static PropertyLoader prop = new PropertyLoader();
    private static String url = prop.getPropertyValue("url");
    private static String browserName = prop.getPropertyValue("browserName");
    private static String envName = prop.getPropertyValue("envName");
    private static String timeOut = prop.getPropertyValue("timeOut");

    public static String getUrl(){
        if (url != null) return url;
        else
            throw new RuntimeException("url not specifies in the config file");
    }

    public static DriverType getBrowserType(){
        switch (browserName){
            case "chrome":
                return DriverType.CHROME;
            case "firefox":
                return DriverType.FIREFOX;
            case "safari":
                return DriverType.SAFARI;
            case "edge":
                return DriverType.EDGE;
            default:
                throw new RuntimeException("Browser name key value in configuration file is not matched:: " +browserName );
        }
    }

    public static EnvironmentType getEnvironmentType(){
        switch (envName){
            case "local":
                return EnvironmentType.LOCAL;
            case "remote":
                return EnvironmentType.REMOTE;
            default:
                throw new RuntimeException("Environment Type key value in configuration file is not matched:: " +envName );
        }
    }
}
