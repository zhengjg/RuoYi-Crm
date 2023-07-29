import request from '@/utils/request'

// 查询流程线列表
export function listFlowLine(query) {
  return request({
    url: '/flow/flowLine/list',
    method: 'get',
    params: query
  })
}

// 查询流程线详细
export function getFlowLine(flowLineId) {
  return request({
    url: '/flow/flowLine/' + flowLineId,
    method: 'get'
  })
}

// 新增流程线
export function addFlowLine(data) {
  return request({
    url: '/flow/flowLine',
    method: 'post',
    data: data
  })
}

// 修改流程线
export function updateFlowLine(data) {
  return request({
    url: '/flow/flowLine',
    method: 'put',
    data: data
  })
}

// 删除流程线
export function delFlowLine(flowLineId) {
  return request({
    url: '/flow/flowLine/' + flowLineId,
    method: 'delete'
  })
}
