package mutiple.datasource.primary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "config")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Config implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 配置规则类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 配置规则代码
     */
    @Column(name = "code")
    private String code;

    /**
     * 配置规则名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 配置规则描述
     */
    @Column(name = "`desc`")
    private String desc;

    /**
     * 配置值
     */
    @Column(name = "value")
    private String value;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "created")
    private Instant created = Instant.now();
}
