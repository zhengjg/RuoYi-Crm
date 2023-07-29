import request from '@/utils/request'

// 查询销售报价列表
export function listQuotation(query) {
  return request({
    url: '/sales/quotation/list',
    method: 'get',
    params: query
  })
}

// 查询销售报价详细
export function getQuotation(quotationId) {
  return request({
    url: '/sales/quotation/' + quotationId,
    method: 'get'
  })
}

// 新增销售报价
export function addQuotation(data) {
  return request({
    url: '/sales/quotation',
    method: 'post',
    data: data
  })
}

// 修改销售报价
export function updateQuotation(data) {
  return request({
    url: '/sales/quotation',
    method: 'put',
    data: data
  })
}

// 删除销售报价
export function delQuotation(quotationId) {
  return request({
    url: '/sales/quotation/' + quotationId,
    method: 'delete'
  })
}
