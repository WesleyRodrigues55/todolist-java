package br.com.welao.todolist.itemsTasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IItemsTaskRepository extends JpaRepository<ItemsTaskModel, UUID> {

    ItemsTaskModel findByNameItem(String nameItem);
}
