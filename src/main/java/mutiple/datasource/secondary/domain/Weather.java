package mutiple.datasource.secondary.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Timestamp ts;
    private Float temperature;
    private Float humidity;
    private String location;
    private String note;
    private int groupId;

    public Weather(Timestamp ts, float temperature, float humidity) {
        this.ts = ts;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}

