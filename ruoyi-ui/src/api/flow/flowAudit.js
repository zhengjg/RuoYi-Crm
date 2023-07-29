import request from '@/utils/request'

// 查询流程审核列表
export function listFlowAudit(query) {
  return request({
    url: '/flow/flowAudit/list',
    method: 'get',
    params: query
  })
}

// 查询流程审核详细
export function getFlowAudit(auditId) {
  return request({
    url: '/flow/flowAudit/' + auditId,
    method: 'get'
  })
}

// 新增流程审核
export function addFlowAudit(data) {
  return request({
    url: '/flow/flowAudit',
    method: 'post',
    data: data
  })
}

// 修改流程审核
export function updateFlowAudit(data) {
  return request({
    url: '/flow/flowAudit',
    method: 'put',
    data: data
  })
}

// 删除流程审核
export function delFlowAudit(auditId) {
  return request({
    url: '/flow/flowAudit/' + auditId,
    method: 'delete'
  })
}
