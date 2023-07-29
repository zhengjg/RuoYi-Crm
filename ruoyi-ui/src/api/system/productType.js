import request from '@/utils/request'

// 查询产品类别列表
export function listProductType(query) {
  return request({
    url: '/system/productType/list',
    method: 'get',
    params: query
  })
}

// 查询产品类别详细
export function getProductType(typeId) {
  return request({
    url: '/system/productType/' + typeId,
    method: 'get'
  })
}

// 新增产品类别
export function addProductType(data) {
  return request({
    url: '/system/productType',
    method: 'post',
    data: data
  })
}

// 修改产品类别
export function updateProductType(data) {
  return request({
    url: '/system/productType',
    method: 'put',
    data: data
  })
}

// 删除产品类别
export function delProductType(typeId) {
  return request({
    url: '/system/productType/' + typeId,
    method: 'delete'
  })
}
