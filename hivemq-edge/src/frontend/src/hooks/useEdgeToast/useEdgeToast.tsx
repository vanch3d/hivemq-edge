import type { UseToastOptions } from '@chakra-ui/react'
import { Text, useToast } from '@chakra-ui/react'

import type { ApiError } from '@/api/__generated__'
import type { ProblemDetailsExtended } from '@/api/types/http-problem-details.ts'
import { BASE_TOAST_OPTION, DEFAULT_TOAST_OPTION } from '@/hooks/useEdgeToast/toast-utils.ts'

export const useEdgeToast = () => {
  const createToast = useToast(BASE_TOAST_OPTION)

  const successToast = (options: UseToastOptions) =>
    createToast({
      ...DEFAULT_TOAST_OPTION,
      ...options,
    })

  const errorToast = (options: UseToastOptions, err: Error) => {
    const { body } = err as ApiError
    if ((options.id && !createToast.isActive(options.id)) || !options.id)
      createToast({
        ...DEFAULT_TOAST_OPTION,
        ...options,
        status: 'error',
        description: (
          <>
            <Text>{options?.description}</Text>
            {!body && <Text>{err.message}</Text>}
            {body && body.message && <Text>{body.message}</Text>}
            {body?.errors?.map((e: ProblemDetailsExtended) => (
              <Text key={e.fieldName as string}>
                {e.fieldName as string} : {e.detail || e.title}
              </Text>
            ))}
          </>
        ),
      })
  }

  return { successToast, errorToast }
}
