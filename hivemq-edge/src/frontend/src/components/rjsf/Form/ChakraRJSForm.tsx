import { FC, useCallback, useEffect, useMemo, useRef, useState } from 'react'
import { useTranslation } from 'react-i18next'
import debug from 'debug'
import { immutableJSONPatch, JSONPatchAdd, JSONPatchDocument } from 'immutable-json-patch'
import Form from '@rjsf/chakra-ui'
import { FormProps, IChangeEvent } from '@rjsf/core'
import { IdSchema } from '@rjsf/utils'
import validator from '@rjsf/validator-ajv8'

import { ObjectFieldTemplate } from '@/components/rjsf/ObjectFieldTemplate.tsx'
import { FieldTemplate } from '@/components/rjsf/FieldTemplate.tsx'
import { DescriptionFieldTemplate } from '@/components/rjsf/Templates/DescriptionFieldTemplate.tsx'
import { BaseInputTemplate } from '@/components/rjsf/BaseInputTemplate.tsx'
import { ArrayFieldTemplate } from '@/components/rjsf/ArrayFieldTemplate.tsx'
import { ArrayFieldItemTemplate } from '@/components/rjsf/ArrayFieldItemTemplate.tsx'
import { ChakraRJSFormContext } from '@/components/rjsf/Form/types.ts'
import { customFormatsValidator } from '@/modules/ProtocolAdapters/utils/validation-utils.ts'
import { adapterJSFFields, adapterJSFWidgets } from '@/modules/ProtocolAdapters/utils/uiSchema.utils.ts'
import { customFocusError } from '@/components/rjsf/Form/error-focus.utils.ts'
import { TitleFieldTemplate } from '@/components/rjsf/Templates/TitleFieldTemplate.tsx'
import { ErrorListTemplate } from '@/components/rjsf/Templates/ErrorListTemplate.tsx'
import { useFormControlStore } from '@/components/rjsf/Form/useFormControlStore.ts'

interface CustomFormProps<T>
  extends Pick<
    FormProps<T>,
    'id' | 'schema' | 'uiSchema' | 'formData' | 'formContext' | 'customValidate' | 'readonly'
  > {
  onSubmit: (data: IChangeEvent) => void
}

const FLAG_POST_VALIDATE = false

const ChakraRJSForm: FC<CustomFormProps<unknown>> = ({
  id,
  schema,
  uiSchema,
  formData,
  onSubmit,
  formContext,
  customValidate,
  readonly,
}) => {
  const { t } = useTranslation()
  const { setTabIndex } = useFormControlStore()
  const ref = useRef(null)
  const [batchData, setBatchData] = useState<JSONPatchDocument | undefined>(undefined)
  const defaultValues = useMemo(() => {
    if (batchData) {
      return immutableJSONPatch(formData, batchData)
    }
    return formData
  }, [batchData, formData])

  const onValidate = useCallback(
    (data: IChangeEvent<unknown>) => {
      onSubmit?.(data)
    },
    [onSubmit]
  )

  useEffect(
    () => {
      setTabIndex(0)
      return () => setTabIndex(0)
    },
    // eslint-disable-next-line react-hooks/exhaustive-deps
    []
  )

  const context: ChakraRJSFormContext = {
    ...formContext,
    onBatchUpload: (idSchema: IdSchema<unknown>, batch) => {
      const path = idSchema.$id.replace('root_', '/').replaceAll('_', '/') + '/-'
      const operations: JSONPatchDocument = batch.map<JSONPatchAdd>((value) => ({ op: 'add', path, value }))

      if (schema && FLAG_POST_VALIDATE) {
        const updatedDocument = immutableJSONPatch(defaultValues, operations)
        const { $schema, ...rest } = schema
        const validate = validator.ajv.compile(rest)
        validate(updatedDocument)
      }

      setBatchData(operations)
    },
    focusOnError: customFocusError(ref),
  }

  const rjsfLog = debug(`RJSF:${id}`)
  // TODO[27657] Problem with the $schema property again; removing from the UI
  //   https://hivemq.kanbanize.com/ctrl_board/57/cards/27041/details/
  const { $schema, ...unspecifiedSchema } = schema

  return (
    <Form
      ref={ref}
      id={id}
      readonly={readonly}
      schema={unspecifiedSchema}
      uiSchema={uiSchema}
      formData={defaultValues}
      formContext={context}
      templates={{
        ObjectFieldTemplate,
        FieldTemplate,
        BaseInputTemplate,
        ArrayFieldTemplate,
        ArrayFieldItemTemplate,
        DescriptionFieldTemplate,
        ErrorListTemplate,
        TitleFieldTemplate,
      }}
      widgets={adapterJSFWidgets}
      fields={adapterJSFFields}
      onSubmit={onValidate}
      liveValidate
      // TODO[NVL] Removing HTML validation; see https://rjsf-team.github.io/react-jsonschema-form/docs/usage/validation/#html5-validation
      noHtml5Validate
      validator={customFormatsValidator}
      customValidate={customValidate}
      onError={(errors) => rjsfLog(t('error.rjsf.validation'), errors)}
      showErrorList="bottom"
      focusOnFirstError={context.focusOnError}
    />
  )
}

export default ChakraRJSForm
