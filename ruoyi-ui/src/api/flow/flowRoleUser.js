import request from '@/utils/request'

// 查询流程角色用户列表
export function listFlowRoleUser(query) {
  return request({
    url: '/flow/flowRoleUser/list',
    method: 'get',
    params: query
  })
}

// 查询流程角色用户详细
export function getFlowRoleUser(userId) {
  return request({
    url: '/flow/flowRoleUser/' + userId,
    method: 'get'
  })
}

// 新增流程角色用户
export function addFlowRoleUser(data) {
  return request({
    url: '/flow/flowRoleUser',
    method: 'post',
    data: data
  })
}

// 修改流程角色用户
export function updateFlowRoleUser(data) {
  return request({
    url: '/flow/flowRoleUser',
    method: 'put',
    data: data
  })
}

// 删除流程角色用户
export function delFlowRoleUser(userId) {
  return request({
    url: '/flow/flowRoleUser/' + userId,
    method: 'delete'
  })
}
