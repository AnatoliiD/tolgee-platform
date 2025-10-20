import React from 'react';
import { useTranslate } from '@tolgee/react';
import { CameraPlus, Edit02, Trash01 } from '@untitled-ui/icons-react';
import { styled } from '@mui/material';

import { CELL_SHOW_ON_HOVER } from './styles';
import { ControlsButton } from './ControlsButton';
import { useProjectPermissions } from 'tg.hooks/useProjectPermissions';

const StyledControls = styled('div')`
  display: flex;
  gap: 12px;
`;

type ControlsProps = {
  editEnabled?: boolean;
  onEdit?: () => void;
  onAddScreenshot?: () => void;
  onDelete?: () => void;
};

export const ControlsKey: React.FC<React.PropsWithChildren<ControlsProps>> = ({
  editEnabled,
  onEdit,
  onAddScreenshot,
  onDelete,
}) => {
  const { satisfiesPermission } = useProjectPermissions();
  const canViewScreenshots = satisfiesPermission('screenshots.view');
  const canDeleteKeys = satisfiesPermission('keys.delete');

  // right section
  const displayEdit = editEnabled && onEdit;
  const displayScreenshots = onAddScreenshot && canViewScreenshots;
  const displayDelete = onDelete && canDeleteKeys;

  const { t } = useTranslate();

  return (
    <StyledControls>
      {displayEdit && (
        <ControlsButton
          onClick={onEdit}
          data-cy="translations-cell-edit-button"
          className={CELL_SHOW_ON_HOVER}
          tooltip={t('translations_cell_edit')}
        >
          <Edit02 />
        </ControlsButton>
      )}
      {displayScreenshots && (
        <>
          <ControlsButton
            tooltip={t('translations_screenshots_add_tooltip')}
            data-cy="translations-cell-screenshots-button"
            className={CELL_SHOW_ON_HOVER}
            onClick={onAddScreenshot}
          >
            <CameraPlus />
          </ControlsButton>
        </>
      )}
      {displayDelete && (
        <ControlsButton
          onClick={onDelete}
          data-cy="translations-cell-delete-button"
          className={CELL_SHOW_ON_HOVER}
          tooltip={t('translations_cell_delete')}
        >
          <Trash01 />
        </ControlsButton>
      )}
    </StyledControls>
  );
};
