import request from '@/utils/request'

// 查询产品入库列表
export function listStockIn(query) {
  return request({
    url: '/product/stockIn/list',
    method: 'get',
    params: query
  })
}

// 查询产品入库详细
export function getStockIn(stockInId) {
  return request({
    url: '/product/stockIn/' + stockInId,
    method: 'get'
  })
}

// 新增产品入库
export function addStockIn(data) {
  return request({
    url: '/product/stockIn',
    method: 'post',
    data: data
  })
}

// 修改产品入库
export function updateStockIn(data) {
  return request({
    url: '/product/stockIn',
    method: 'put',
    data: data
  })
}

// 删除产品入库
export function delStockIn(stockInId) {
  return request({
    url: '/product/stockIn/' + stockInId,
    method: 'delete'
  })
}
