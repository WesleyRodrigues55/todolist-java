package br.com.welao.todolist.itemsTasks;

import br.com.welao.todolist.task.ITaskRepository;
import br.com.welao.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/items-task")
public class ItemsTaskController {

    @Autowired
    private IItemsTaskRepository itemsTaskRepository;

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/{idTask}")
    public ResponseEntity create(@RequestBody ItemsTaskModel itemsTaskModel, @PathVariable UUID idTask, HttpServletRequest request) {
        var task = taskRepository.findById(idTask).orElse(null);
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

    //testar
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody ItemsTaskModel itemsTaskModel, @PathVariable UUID id, HttpServletRequest request) {
        var itemsTask = this.itemsTaskRepository.findById(id).orElse(null);
        if (itemsTask == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Items Task not found.");
        }

        var nameItem = this.itemsTaskRepository.findByNameItem(itemsTaskModel.getNameItem());
        if (nameItem != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name Item Task already exists.");
        }

        Utils.copyNonNullProperties(itemsTaskModel, itemsTask);

        var updateItemsTask = this.itemsTaskRepository.save(itemsTask);

        return ResponseEntity.status(HttpStatus.OK).body(updateItemsTask);
    }


}
