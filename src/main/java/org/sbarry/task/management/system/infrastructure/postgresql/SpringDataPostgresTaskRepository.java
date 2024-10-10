package org.sbarry.task.management.system.infrastructure.postgresql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataPostgresTaskRepository extends JpaRepository<TaskEntity, UUID>{

}
