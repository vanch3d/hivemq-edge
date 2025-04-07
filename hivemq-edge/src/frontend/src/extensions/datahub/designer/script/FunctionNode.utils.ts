import type { Connection, Node, NodeAddChange, XYPosition } from '@xyflow/react'

import type { PolicyOperation } from '@/api/__generated__'
import { Script } from '@/api/__generated__'
import i18n from '@/config/i18n.config.ts'

import type { DataHubNodeData, DryRunResults, FunctionData } from '@datahub/types.ts'
import { DataHubNodeType, OperationData } from '@datahub/types.ts'
import { PolicyCheckErrors } from '@datahub/designer/validation.errors.ts'
import { CANVAS_POSITION } from '@datahub/designer/checks.utils.ts'
import {
  SCRIPT_FUNCTION_LATEST,
  SCRIPT_FUNCTION_PREFIX,
  SCRIPT_FUNCTION_SEPARATOR,
} from '@datahub/utils/datahub.utils.ts'

export const formatScriptName = (functionNode: Node<FunctionData>): string => {
  return `${SCRIPT_FUNCTION_PREFIX}:${functionNode.data.name}:${SCRIPT_FUNCTION_LATEST}`
}

export const parseScriptName = (operation: PolicyOperation): string => {
  const splitId = operation.functionId.split(SCRIPT_FUNCTION_SEPARATOR)
  if (splitId.length !== 3) return splitId[0]
  return splitId[1]
}

export function checkValidityJSScript(scriptNode: Node<FunctionData>): DryRunResults<Script> {
  if (!scriptNode.data.name || !scriptNode.data.version || !scriptNode.data.sourceCode) {
    return {
      node: scriptNode,
      error: PolicyCheckErrors.notConfigured(scriptNode, 'name, version, sourceCode'),
    }
  }

  const script: Script = {
    // TODO[19466] Id should be user-facing; Need to fix before merging!
    id: scriptNode.data.name,
    functionType: Script.functionType.TRANSFORMATION,
    source: btoa(scriptNode.data.sourceCode),
    // version is generated by the backend
  }
  return { data: script, node: scriptNode }
}

export const loadScripts = (
  parentNode: Node<DataHubNodeData>,
  positionInGroup: number,
  functions: PolicyOperation[],
  scripts: Script[]
) => {
  const position: XYPosition = {
    x: parentNode.position.x + CANVAS_POSITION.Function.x,
    y: parentNode.position.y,
  }

  const shiftLeft = () => {
    position.y += positionInGroup * CANVAS_POSITION.Function.y
    return position
  }

  const newNodes: (NodeAddChange | Connection)[] = []
  for (const fct of functions) {
    const [, functionName] = fct.functionId.split(':')
    const functionScript = scripts.find((script) => script.id === functionName)
    if (!functionScript)
      throw new Error(i18n.t('datahub:error.loading.connection.notFound', { type: DataHubNodeType.FUNCTION }) as string)

    const functionScriptNode: Node<FunctionData> = {
      id: functionScript.id,
      type: DataHubNodeType.FUNCTION,
      position: { ...shiftLeft() },
      data: {
        type: 'Javascript',
        name: functionScript.id,
        version: Number(functionScript.version),
        sourceCode: atob(functionScript.source),
      },
    }

    newNodes.push(
      { item: functionScriptNode, type: 'add' },
      {
        source: functionScriptNode.id,
        target: parentNode.id,
        sourceHandle: null,
        targetHandle: OperationData.Handle.FUNCTION,
      }
    )
  }
  return newNodes
}
