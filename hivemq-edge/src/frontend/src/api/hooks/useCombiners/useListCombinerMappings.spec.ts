import { expect } from 'vitest'
import { renderHook, waitFor } from '@testing-library/react'

import { server } from '@/__test-utils__/msw/mockServer.ts'
import { SimpleWrapper as wrapper } from '@/__test-utils__/hooks/SimpleWrapper.tsx'

import { handlers } from './__handlers__'

import type { DataCombiningList } from '../../__generated__'
import { useListCombinerMappings } from './useListCombinerMappings'

describe('useListCombinerMappings', () => {
  afterEach(() => {
    server.resetHandlers()
  })

  it('should load the data', async () => {
    server.use(...handlers)

    const { result } = renderHook(() => useListCombinerMappings('test'), { wrapper })

    await waitFor(() => {
      expect(result.current.isLoading).toBeFalsy()
      expect(result.current.isSuccess).toBeTruthy()
    })

    expect(result.current.data).toStrictEqual<DataCombiningList>({
      items: [
        {
          id: '58677276-fc48-4a9a-880c-41c755f5063b',
          sources: {
            tags: [],
            topicFilters: [],
          },
          destination: 'my/topic',
          instructions: [],
        },
      ],
    })
  })
})
