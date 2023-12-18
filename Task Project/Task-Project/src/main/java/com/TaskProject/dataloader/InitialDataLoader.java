package com.TaskProject.dataloader;

import com.TaskProject.model.Role;
import com.TaskProject.model.Task;
import com.TaskProject.model.User;
import com.TaskProject.service.RoleService;
import com.TaskProject.service.TaskService;
import com.TaskProject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Loads initial data into the system on application startup.
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final UserService userService;
    private final TaskService taskService;
    private final RoleService roleService;
    private final Logger logger = LoggerFactory.getLogger(InitialDataLoader.class);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Value("${default.admin.mail}")
    private String defaultAdminMail;
    @Value("${default.admin.name}")
    private String defaultAdminName;
    @Value("${default.admin.password}")
    private String defaultAdminPassword;
  ;

    @Autowired
    public InitialDataLoader(UserService userService, TaskService taskService, RoleService roleService) {
        this.userService = userService;
        this.taskService = taskService;
        this.roleService = roleService;
    }

     Loads initial data into the system when the application context is refreshed.
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // ROLES --------------------------------------------------------------------------------------------------------
        roleService.createRole(new Role("ADMIN"));
        roleService.createRole(new Role("USER"));
        roleService.findAll().stream().map(role -> "saved role: " + role.getRole()).forEach(logger::info);
        //USERS --------------------------------------------------------------------------------------------------------
        //1
        User admin = new User(
                defaultAdminMail,
                defaultAdminName,
                defaultAdminPassword);
        userService.createUser(admin);
        userService.changeRoleToAdmin(admin);

        //2
        User manager = new User("manager@mail.com", "Manager", "manager@123");
        userService.createUser(manager);
        userService.changeRoleToAdmin(manager);
        //3 // 3 to 7 - Regular users
        userService.createUser(new User("mark@mail.com", "Mark", "112233"));
        //4
        userService.createUser(new User("ann@mail.com", "Ann", "112233"));
        //5
        userService.createUser(new User("ralf@mail.com", "Ralf", "112233"));
        //6
        userService.createUser(new User("kate@mail.com", "Kate", "112233"));
        //7
        userService.createUser(new User("tom@mail.com", "Tom", "112233"));

        userService.findAll().stream()
                .map(u -> "saved user: " + u.getName())
                .forEach(logger::info);

        // TASKS --------------------------------------------------------------------------------------------------------
        LocalDate today = LocalDate.now();

        // 1
        taskService.createTask(new Task(
                "Collect briefing document ",
                "Setup first meeting with client. Collect basic data about the client.",
                today.minusDays(40),
                true,
                userService.getUserByEmail("mark@mail.com").getName(),
                userService.getUserByEmail("mark@mail.com")
        ));

// 2
        taskService.createTask(new Task(
                "Define project questionnaire ",
                "Define and send project questionnaire to the client and wait for the client’s response. Finalize project questionnaire from client.",
                today.minusDays(30),
                true,
                userService.getUserByEmail("ann@mail.com").getName(),
                userService.getUserByEmail("ann@mail.com")
        ));

// 3
        taskService.createTask(new Task(
                "Research client’s company and industry",
                "Research client’s company to understand their brand, the way they communicate, their demographics, target audience. Research client’s industry to find ways of communicating specifically to the industry, strengths and weaknesses, trends and other industry specifics.",
                today.minusDays(20),
                true,
                userService.getUserByEmail("ralf@mail.com").getName(),
                userService.getUserByEmail("ralf@mail.com")
        ));

// 4
        taskService.createTask(new Task(
                "Get quotation for project",
                "Get quotation for development effort for project. Estimate design work with designers. Get quotation for copy/content or estimate work with your copywriters.  Get quotation for photography and video production or estimate effort involved.",
                today.minusDays(10),
                true,
                userService.getUserByEmail("kate@mail.com").getName(),
                userService.getUserByEmail("kate@mail.com")
        ));


// 5
        taskService.createTask(new Task(
                "Get quotation for hosting and domain",
                "Get quotation for hosting and domain, particularly if specialized hosting is involved such as VPS hosting, cloud hosting, or special hosting or environment requirements.",
                today.minusDays(5),
                false,
                userService.getUserByEmail("manager@mail.com").getName(),
                userService.getUserByEmail("magager@mail.com")
        ));

        taskService.findAll().stream().map(t -> "saved task: '" + t.getName()
                + "' for owner: " + getOwnerNameOrNoOwner(t)).forEach(logger::info);
    }

    //Helper method to get owner name or indicate "no owner" for a task.
    private String getOwnerNameOrNoOwner(Task task) {
        return task.getOwner() == null ? "no owner" : task.getOwner().getName();
    }
}
