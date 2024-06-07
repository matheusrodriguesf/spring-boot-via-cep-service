package br.com.arcelino.api.cepservice.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;

public class AppInfoControllerTest {

    private AppInfoController appInfoController;
    private BuildProperties buildProperties;

    @BeforeEach
    public void setUp() {
        buildProperties = mock(BuildProperties.class);
        appInfoController = new AppInfoController(buildProperties);
    }

    @Test
    public void testGetAppInfo_ReturnsAppInfoWithCorrectNameAndVersion() {
        var appName = "Test App";
        var appVersion = "1.0.0";
        var javaVersion = "11.0.1";
        when(buildProperties.getName()).thenReturn(appName);
        when(buildProperties.getVersion()).thenReturn(appVersion);
        System.setProperty("java.version", javaVersion);

        var response = appInfoController.getAppInfo();

        var appInfo = response.getBody();
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(appName, appInfo.name()),
                () -> assertEquals(appVersion, appInfo.version()),
                () -> assertEquals(javaVersion, appInfo.javaVersion()));
    }

}
