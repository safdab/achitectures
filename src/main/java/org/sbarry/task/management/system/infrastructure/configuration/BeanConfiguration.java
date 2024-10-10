package org.sbarry.task.management.system.infrastructure.configuration;

import org.sbarry.task.management.system.domain.repositoriesOutPorts.TaskRepository;
import org.sbarry.task.management.system.domain.services.DomainTaskService;
import org.sbarry.task.management.system.domain.services.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    TaskService taskService(final TaskRepository taskRepository) {
        return new DomainTaskService(taskRepository);
    }
}
