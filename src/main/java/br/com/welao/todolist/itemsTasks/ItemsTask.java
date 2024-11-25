package br.com.welao.todolist.itemsTasks;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/items-task")
public class ItemsTask {

    @Autowired
    private IItemsTaskRepository itemsTaskRepository;

    @PostMapping("/{idTask}")
    public ResponseEntity create(@RequestBody ItemsTaskModel itemsTaskModel, @PathVariable UUID idTask, HttpServletRequest request) {
        var task = itemsTaskRepository.findById(idTask);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task not found.");
        }

        var nameItem = this.itemsTaskRepository.findByNameItem(itemsTaskModel.getNameItem());
        if (nameItem != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item Task already exists.");
        }

        itemsTaskModel.setTaskId(idTask);

        var itemsTask = this.itemsTaskRepository.save(itemsTaskModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(itemsTask);
    }
}
