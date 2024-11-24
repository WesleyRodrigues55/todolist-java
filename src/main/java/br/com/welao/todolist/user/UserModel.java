package br.com.welao.todolist.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Getter - apenas para métodos getters
 * @Setter - apenas para métodos setters
 * @Data - para os dois tipos de métodos
 */

@Data
@Entity(name="tb_users")
public class UserModel {

    /**
     * Se caso apena um metodo precisar ter um tipo, defina logo acima do metodo uma annotation antes da declaração do metodo, exemplo:
     * @Getter ou @Setter
     * private String username;
     */
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    /** constraint unique on database */
    @Column(unique=true)
    private String username;

    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
