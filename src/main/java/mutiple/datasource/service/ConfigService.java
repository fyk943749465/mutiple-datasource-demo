package mutiple.datasource.service;

import mutiple.datasource.primary.domain.Config;
import mutiple.datasource.primary.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ConfigService {

    @Autowired
    private ConfigRepository configRepository;


    /**
     * 查询所有数据
     * @return
     */
    public List<Config> getConfig() {
        return configRepository.findAll();
    }

}
