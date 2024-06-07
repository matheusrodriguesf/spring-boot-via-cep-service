package br.com.arcelino.api.cepservice.controller;

import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arcelino.api.cepservice.model.AppInfo;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("app")
@RequiredArgsConstructor
public class AppInfoController {

    private final BuildProperties buildProperties;

    @GetMapping("/info")
    public ResponseEntity<AppInfo> getAppInfo() {
        return ResponseEntity.ok(new AppInfo(
                buildProperties.getName(),
                buildProperties.getVersion(),
                System.getProperty("java.version")));
    }
}
