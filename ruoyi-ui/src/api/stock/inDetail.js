import request from '@/utils/request'

// 查询入库明细列表
export function listInDetail(query) {
  return request({
    url: '/stock/inDetail/list',
    method: 'get',
    params: query
  })
}

// 查询入库明细详细
export function getInDetail(stockInDetailId) {
  return request({
    url: '/stock/inDetail/' + stockInDetailId,
    method: 'get'
  })
}

// 新增入库明细
export function addInDetail(data) {
  return request({
    url: '/stock/inDetail',
    method: 'post',
    data: data
  })
}

// 修改入库明细
export function updateInDetail(data) {
  return request({
    url: '/stock/inDetail',
    method: 'put',
    data: data
  })
}

// 删除入库明细
export function delInDetail(stockInDetailId) {
  return request({
    url: '/stock/inDetail/' + stockInDetailId,
    method: 'delete'
  })
}
