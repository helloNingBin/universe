package ning.markerhub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "m_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    // 头像
    private String avatar;

    // 微信用户身份id
    @JsonIgnore
    private String openId;

    // 上次登录
    private LocalDateTime lasted;
    private LocalDateTime created;

    private Integer statu;
}