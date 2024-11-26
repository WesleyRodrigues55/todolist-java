package br.com.welao.todolist.itemsTasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IItemsTaskRepository extends JpaRepository<ItemsTaskModel, UUID> {

    ItemsTaskModel findByNameItem(String nameItem);

    List<ItemsTaskModel> findByTaskId(UUID taskId);
}
