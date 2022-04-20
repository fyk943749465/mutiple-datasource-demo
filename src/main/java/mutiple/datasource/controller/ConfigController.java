package mutiple.datasource.controller;

import mutiple.datasource.primary.domain.Config;
import mutiple.datasource.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/config")
@RestController
public class ConfigController {

    @Autowired
    ConfigService configService;

    @GetMapping("/all")
    public List<Config> getAllConfig() {
        return configService.getConfig();
    }
}
