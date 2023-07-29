import request from '@/utils/request'

// 查询出入库汇总列表
export function listStatistics(query) {
  return request({
    url: '/stock/statistics/list',
    method: 'get',
    params: query
  })
}

// 查询出入库汇总详细
export function getStatistics(ioStatisticsId) {
  return request({
    url: '/stock/statistics/' + ioStatisticsId,
    method: 'get'
  })
}

// 新增出入库汇总
export function addStatistics(data) {
  return request({
    url: '/stock/statistics',
    method: 'post',
    data: data
  })
}

// 修改出入库汇总
export function updateStatistics(data) {
  return request({
    url: '/stock/statistics',
    method: 'put',
    data: data
  })
}

// 删除出入库汇总
export function delStatistics(ioStatisticsId) {
  return request({
    url: '/stock/statistics/' + ioStatisticsId,
    method: 'delete'
  })
}
