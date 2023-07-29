import request from '@/utils/request'

// 查询finance列表
export function listReceivable(query) {
  return request({
    url: '/finance/receivable/list',
    method: 'get',
    params: query
  })
}

// 查询finance详细
export function getReceivable(billId) {
  return request({
    url: '/finance/receivable/' + billId,
    method: 'get'
  })
}

// 新增finance
export function addReceivable(data) {
  return request({
    url: '/finance/receivable',
    method: 'post',
    data: data
  })
}

// 修改finance
export function updateReceivable(data) {
  return request({
    url: '/finance/receivable',
    method: 'put',
    data: data
  })
}

// 删除finance
export function delReceivable(billId) {
  return request({
    url: '/finance/receivable/' + billId,
    method: 'delete'
  })
}
