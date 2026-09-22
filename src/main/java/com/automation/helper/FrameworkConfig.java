package com.automation.helper;

import org.aeonbits.owner.Config;

import static com.automation.helper.Constant.*;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        SYSTEM_PROPS,
        CONFIG_FILE_PATH

})
public interface FrameworkConfig extends Config {

    String browser();

    @DefaultValue("acceptance")
    String environment();

    @DefaultValue("10")
    String implicitWait();

    @Key("${environment}.url")
    String url();


}
