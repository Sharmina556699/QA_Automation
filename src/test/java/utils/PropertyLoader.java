package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.openqa.selenium.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlunit.builder.Input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyLoader.class);
    public static final long DEFAULT_WEBDRIVER_WAIT_TIMEOUT_IN_SECONDS = 15;

    public String getPropertyValue(String key) {
        InputStream in = null;
        Properties props = new Properties();

        String eiEnv = "dev";
        if (eiEnv.equalsIgnoreCase("local")) {
            in = this.getClass().getClassLoader().getResourceAsStream("application-local.properties");

        } else if (eiEnv.equalsIgnoreCase("dev")) {
            in = this.getClass().getClassLoader().getResourceAsStream("application-dev.properties");

        } else if (eiEnv.equalsIgnoreCase("qa")) {
            in = this.getClass().getClassLoader().getResourceAsStream("application-qa.properties");

        } else if (eiEnv.equalsIgnoreCase("stage")) {
            in = this.getClass().getClassLoader().getResourceAsStream("application-stage.properties");

        } else if (eiEnv.equalsIgnoreCase("prod")) {
            in = this.getClass().getClassLoader().getResourceAsStream("application-prod.properties");
        }
        try {
            props.load(in);
        } catch (IOException e){
            e.printStackTrace();
        }
        return props.getProperty(key);
    }

    public String getMavenPropertyValue(String key){
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("maven.properties");
        Properties props = new Properties();
        try {
            props.load(in);
        } catch (IOException e){
            e.printStackTrace();
        }
        return props.getProperty(key);
    }

    public String getPasswordFromVault(){
        String vaultText = getMavenPropertyValue("vault data");
        Gson gson = new Gson();
        JsonObject vaultJson = gson.fromJson(vaultText,JsonObject.class);
        return vaultJson.get("gei test").getAsString();
    }

}
