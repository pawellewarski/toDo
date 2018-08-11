package pl.akademiakodu.toDo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akademiakodu.toDo.Task;

@Controller
public class TaskController {

    @GetMapping("/")
    public String add(){
        return "add";
    }

    @ResponseBody
    @PostMapping
    public String create(@RequestParam String name,
                         @RequestParam String description,
                         @RequestParam (required = false) boolean finished,
                         ModelMap modelMap){
        Task task = new Task(name, description, finished);
        task.setName(name);
        task.setDescription(description);
        task.setFinished(finished);
        modelMap.put("task",task);

        return "added" + task;



    }

}
