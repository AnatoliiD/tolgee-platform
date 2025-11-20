package io.tolgee.service.task

import io.tolgee.exceptions.NotImplementedInOss
import io.tolgee.model.UserAccount
import io.tolgee.model.enums.TaskType
import io.tolgee.model.task.Task
import io.tolgee.model.views.TranslationToTaskView
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component

@Component
class TaskServiceOssImpl(
  entityManager: EntityManager,
) : AbstractTaskService(entityManager) {
  override fun deleteAll(tasks: List<Task>) {
    // No-op: OSS doesn't have task functionality, so there are no tasks to delete
  }

  override fun findAssigneeById(
    projectId: Long,
    taskNumber: Long,
    userId: Long,
  ): List<UserAccount> {
    return emptyList()
  }

  override fun findAssigneeByKey(
    keyId: Long,
    languageId: Long,
    userId: Long,
    type: TaskType?,
  ): List<UserAccount> {
    // No-op: OSS doesn't have task functionality, so there are no tasks to retrieve
    return emptyList()
  }

  override fun getKeysWithTasks(
    userId: Long,
    keyIds: Collection<Long>,
  ): Map<Long, List<TranslationToTaskView>> {
    // No-op: OSS doesn't have task functionality, so there are no tasks to retrieve
    return emptyMap()
  }

  override fun getAgencyTasks(agencyId: Long): List<Task> {
    // No-op: OSS doesn't have task functionality, so there are no tasks to retrieve
    return emptyList()
  }
}
