import {request} from '../request.js'

export function getProductList(currentPage,pageSize) {
	return  request({
		url: '/product/getProductList',
		params:{
			currentPage,
			pageSize
		}
	})
}

export function getProductListNoPage() {
	return  request({
		url: '/product/getProductListNoPage'
	})
}

export function getProductCount() {
	return  request({
		url: '/product/getProductCount'
	})
}

export function deleteProduct(id) {
	return  request({
		url: '/product/delete',
		params:{
			id
		}
	})
}

export function alterProduct(item) {
	return  request({
		url: '/product/alter',
		params:item
	})
}

