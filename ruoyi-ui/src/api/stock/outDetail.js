import request from '@/utils/request'

// 查询出库明细列表
export function listOutDetail(query) {
  return request({
    url: '/stock/outDetail/list',
    method: 'get',
    params: query
  })
}

// 查询出库明细详细
export function getOutDetail(stockOutDetailId) {
  return request({
    url: '/stock/outDetail/' + stockOutDetailId,
    method: 'get'
  })
}

// 新增出库明细
export function addOutDetail(data) {
  return request({
    url: '/stock/outDetail',
    method: 'post',
    data: data
  })
}

// 修改出库明细
export function updateOutDetail(data) {
  return request({
    url: '/stock/outDetail',
    method: 'put',
    data: data
  })
}

// 删除出库明细
export function delOutDetail(stockOutDetailId) {
  return request({
    url: '/stock/outDetail/' + stockOutDetailId,
    method: 'delete'
  })
}
