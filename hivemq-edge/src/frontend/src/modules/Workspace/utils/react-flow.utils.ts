/* istanbul ignore file -- @preserve */
import type { ReactFlowState } from '@xyflow/react'

export const CONFIG_ZOOM_SKELETON = 0.5
export const CONFIG_ZOOM_MIN = 0.2
export const CONFIG_ZOOM_MAX = 1.5

export const selectorIsSkeletonZoom = (state: ReactFlowState) => state.transform[2] <= CONFIG_ZOOM_SKELETON

export const selectorSetZoomMinMax = (state: ReactFlowState) => ({
  setMinZoom: state.setMinZoom,
  setMaxZoom: state.setMaxZoom,
})

export const selectorIsInteractive = (s: ReactFlowState) => ({
  isInteractive: s.nodesDraggable || s.nodesConnectable || s.elementsSelectable,
})
