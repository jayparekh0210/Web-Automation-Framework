package com.automation.objectmanager;

import com.automation.datareader.ConfigFileReader;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;

@Slf4j
public class FileReaderManager {

    private static final FileReaderManager INSTANCE = new FileReaderManager();

    private ConfigFileReader configFileReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return INSTANCE;
    }

    public synchronized ConfigFileReader getConfigReader() {
        if (configFileReader == null) {
            configFileReader = new ConfigFileReader();
        }

        return configFileReader;
    }
}
