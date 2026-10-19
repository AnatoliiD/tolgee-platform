package io.tolgee.service

import io.tolgee.component.machineTranslation.MtValueProvider
import io.tolgee.dtos.request.prompt.PromptDto
import io.tolgee.dtos.request.prompt.PromptRunDto
import io.tolgee.exceptions.NotImplementedInOss
import io.tolgee.model.Prompt
import io.tolgee.model.enums.LlmProviderPriority
import io.tolgee.repository.PromptRepository
import org.springframework.stereotype.Service

@Service
class PromptServiceOssImpl(
  private val promptRepository: PromptRepository,
) : PromptService {
  override fun translate(
    projectId: Long,
    data: PromptRunDto,
    priority: LlmProviderPriority?,
  ): MtValueProvider.MtResult {
    throw NotImplementedInOss()
  }

  override fun findPromptOrDefaultDto(
    projectId: Long,
    promptId: Long?,
  ): PromptDto {
    throw NotImplementedInOss()
  }

  override fun findPrompt(
    projectId: Long,
    promptId: Long,
  ): Prompt {
    throw NotImplementedInOss()
  }

  override fun deleteAllByProjectId(projectId: Long) {
    // The prompt table is part of the OSS schema and can hold rows (e.g. from a former EE instance)
    promptRepository.deleteAllByProjectId(projectId)
  }
}
