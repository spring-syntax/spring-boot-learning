package com.bytechnology.springfirststeps.controllers;

import com.bytechnology.springfirststeps.model.Todo;
import com.bytechnology.springfirststeps.security.LoginService;
import com.bytechnology.springfirststeps.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/todo-list",method = RequestMethod.GET)
    public String loadLogin( ModelMap modelMap){
        String name = loginService.getLoggedInUserName();
        List<Todo> todos = toDoService.retrieveToDos(name);
        modelMap.put("todos",todos);
        return "todos";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String addToDoPage( ModelMap modelMap){
        modelMap.addAttribute("todo", new Todo(0, loginService.getLoggedInUserName(), "Learning ...",
                LocalDate.now().plusMonths(1), false));
        return "add-todo";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String addToDo(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "add-todo";
        }
        String name = loginService.getLoggedInUserName();
        toDoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), false);
        return "redirect:/todo-list";
    }

    @RequestMapping(value = "/delete-todo/{id}",method = RequestMethod.GET)
    public String deleteToDo(@PathVariable int id, ModelMap modelMap){
        toDoService.deleteTodo(id);
        return "redirect:/todo-list";
    }

    @GetMapping(value = "/update-todo/{id}")
    public String updateToDoPage(@PathVariable int id,ModelMap modelMap){
        Optional<Todo> todo = toDoService.retrieveToDo(id);
        if(todo.isPresent() && todo.get().getUser().equalsIgnoreCase(loginService.getLoggedInUserName())){
            modelMap.put("todo",todo.get());
            return "update-todo";
        }

        return "redirect:/todo-list";
    }

    @PostMapping(value = "/update-todo/{id}")
    public String updateToDo(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "update-todo";
        }
        toDoService.updateToDo(todo);
        return "redirect:/todo-list";
    }
}
