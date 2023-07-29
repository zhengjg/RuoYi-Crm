import request from '@/utils/request'

// 查询产品出库列表
export function listStockout(query) {
  return request({
    url: '/product/stockout/list',
    method: 'get',
    params: query
  })
}

// 查询产品出库详细
export function getStockout(stockOutId) {
  return request({
    url: '/product/stockout/' + stockOutId,
    method: 'get'
  })
}

// 新增产品出库
export function addStockout(data) {
  return request({
    url: '/product/stockout',
    method: 'post',
    data: data
  })
}

// 修改产品出库
export function updateStockout(data) {
  return request({
    url: '/product/stockout',
    method: 'put',
    data: data
  })
}

// 删除产品出库
export function delStockout(stockOutId) {
  return request({
    url: '/product/stockout/' + stockOutId,
    method: 'delete'
  })
}
