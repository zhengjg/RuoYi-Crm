import request from '@/utils/request'

// 查询销售报价产品列表
export function listProductList(query) {
  return request({
    url: '/sales/productList/list',
    method: 'get',
    params: query
  })
}

// 查询销售报价产品详细
export function getProductList(quotationDetailId) {
  return request({
    url: '/sales/productList/' + quotationDetailId,
    method: 'get'
  })
}

// 新增销售报价产品
export function addProductList(data) {
  return request({
    url: '/sales/productList',
    method: 'post',
    data: data
  })
}

// 修改销售报价产品
export function updateProductList(data) {
  return request({
    url: '/sales/productList',
    method: 'put',
    data: data
  })
}

// 删除销售报价产品
export function delProductList(quotationDetailId) {
  return request({
    url: '/sales/productList/' + quotationDetailId,
    method: 'delete'
  })
}
