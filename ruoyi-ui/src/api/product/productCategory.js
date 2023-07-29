import request from '@/utils/request'

// 查询产品类别列表
export function listProductCategory(query) {
  return request({
    url: '/product/productCategory/list',
    method: 'get',
    params: query
  })
}

// 查询产品类别详细
export function getProductCategory(prodcutTypeId) {
  return request({
    url: '/product/productCategory/' + prodcutTypeId,
    method: 'get'
  })
}

// 新增产品类别
export function addProductCategory(data) {
  return request({
    url: '/product/productCategory',
    method: 'post',
    data: data
  })
}

// 修改产品类别
export function updateProductCategory(data) {
  return request({
    url: '/product/productCategory',
    method: 'put',
    data: data
  })
}

// 删除产品类别
export function delProductCategory(prodcutTypeId) {
  return request({
    url: '/product/productCategory/' + prodcutTypeId,
    method: 'delete'
  })
}
