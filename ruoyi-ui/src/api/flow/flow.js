import request from '@/utils/request'

// 查询流程列表
export function listFlow(query) {
  return request({
    url: '/flow/flow/list',
    method: 'get',
    params: query
  })
}

// 查询流程详细
export function getFlow(flowId) {
  return request({
    url: '/flow/flow/' + flowId,
    method: 'get'
  })
}

// 新增流程
export function addFlow(data) {
  return request({
    url: '/flow/flow',
    method: 'post',
    data: data
  })
}

// 修改流程
export function updateFlow(data) {
  return request({
    url: '/flow/flow',
    method: 'put',
    data: data
  })
}

// 删除流程
export function delFlow(flowId) {
  return request({
    url: '/flow/flow/' + flowId,
    method: 'delete'
  })
}
