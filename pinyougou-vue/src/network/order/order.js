import {request} from '../request.js'

export function saveOrders(order,customerId) {
	return  request({
		url: '/orders/add',
		params:{
			productName:order.name,
			counts:order.count,
			price:order.price,
			isPayment:2,
			totalPrice:order.subtotal,
			consignee:order.consignee,
			address:order.address,
			phone:order.phone,
			customerId
		}
	})
}

export function getOrdersById(customerId,currentPage,pageSize) {
	return  request({
		url: '/orders/getOrdersListById',
		params:{
			customerId,
			currentPage,
			pageSize
		}
	})
}

export function getOrdersCountById(customerId) {
	return  request({
		url: '/orders/getOrdersCountById',
		params:{
			customerId
		}
	})
}


export function getOrderList(currentPage,pageSize) {
	return  request({
		url: '/orders/getOrdersList',
		params:{
			currentPage,
			pageSize
		}
	})
}

export function getOrderCount() {
	return  request({
		url: '/orders/getOrdersCount'
	})
}

export function deleteOrder(id) {
	return  request({
		url: '/orders/delete',
		params:{
	
			id
			
		}
	})
}

export function alterOrder(item) {
	return  request({
		url: '/orders/alter',
		params:item
	})
}