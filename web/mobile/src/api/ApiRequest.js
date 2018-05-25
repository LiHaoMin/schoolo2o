import request from '@/utils/http'

export function getHeadLines() {
  return request({
    url: '/headLines/list',
    method: 'get'
  })
}

export function getShopList() {
  return request({
    url: '/shop/list',
    method: 'get'
  })
}

export function getShopCategory() {
  return request({
    url: '/shopCategory/parentList',
    method: 'get'
  })
}

export function getShop(id) {
  return request({
    url: '/shop/get?id='+id,
    method: 'get'
  })
}
