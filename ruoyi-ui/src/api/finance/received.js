import request from '@/utils/request'

// 查询销售收款列表
export function listReceived(query) {
  return request({
    url: '/finance/received/list',
    method: 'get',
    params: query
  })
}

// 查询销售收款详细
export function getReceived(receivedId) {
  return request({
    url: '/finance/received/' + receivedId,
    method: 'get'
  })
}

// 新增销售收款
export function addReceived(data) {
  return request({
    url: '/finance/received',
    method: 'post',
    data: data
  })
}

// 修改销售收款
export function updateReceived(data) {
  return request({
    url: '/finance/received',
    method: 'put',
    data: data
  })
}

// 删除销售收款
export function delReceived(receivedId) {
  return request({
    url: '/finance/received/' + receivedId,
    method: 'delete'
  })
}
