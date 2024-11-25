package br.com.welao.todolist.itemsTasks;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="tb_items_task")
public class ItemsTaskModel {

    @Id
    @GeneratedValue(generator="UUDI")
    private UUID id;

    @Column(length=50, unique=true)
    private String nameItem;

    private Boolean checkedItem = false;

    @Setter
    private UUID taskId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setNameItem(String nameItem) throws Exception {
        if (nameItem.length() > 50) {
            throw new Exception("Name Item exceeds 50 characters");
        }

        this.nameItem = nameItem;
    }

}
