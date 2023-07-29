import request from '@/utils/request'

// 查询对账单列表
export function listStatementAccount(query) {
  return request({
    url: '/finance/statementAccount/list',
    method: 'get',
    params: query
  })
}

// 查询对账单详细
export function getStatementAccount(salesId) {
  return request({
    url: '/finance/statementAccount/' + salesId,
    method: 'get'
  })
}

// 新增对账单
export function addStatementAccount(data) {
  return request({
    url: '/finance/statementAccount',
    method: 'post',
    data: data
  })
}

// 修改对账单
export function updateStatementAccount(data) {
  return request({
    url: '/finance/statementAccount',
    method: 'put',
    data: data
  })
}

// 删除对账单
export function delStatementAccount(salesId) {
  return request({
    url: '/finance/statementAccount/' + salesId,
    method: 'delete'
  })
}
