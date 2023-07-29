import request from '@/utils/request'

// 查询流程节点列表
export function listFlownode(query) {
  return request({
    url: '/flow/flownode/list',
    method: 'get',
    params: query
  })
}

// 查询流程节点详细
export function getFlownode(flowNodeId) {
  return request({
    url: '/flow/flownode/' + flowNodeId,
    method: 'get'
  })
}

// 新增流程节点
export function addFlownode(data) {
  return request({
    url: '/flow/flownode',
    method: 'post',
    data: data
  })
}

// 修改流程节点
export function updateFlownode(data) {
  return request({
    url: '/flow/flownode',
    method: 'put',
    data: data
  })
}

// 删除流程节点
export function delFlownode(flowNodeId) {
  return request({
    url: '/flow/flownode/' + flowNodeId,
    method: 'delete'
  })
}
