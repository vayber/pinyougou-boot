import {request} from '../request.js'

export function customerLogin(email,emailPwd) {
	return  request({
		url: '/customer/login',
		params:{
			email,
			emailPwd
		}
	})
}

export function getCustomerList(currentPage,pageSize) {
	return  request({
		url: '/customer/getCustomerList',
		params:{
			currentPage,
			pageSize
		}
	})
}	

export function getCustomerListNoPage() {
	return  request({
		url: '/customer/getCustomerListNoPage'
	})
}

export function getCustomerCount() {
	return  request({
		url: '/customer/getCustomerCount'
	})
}


export function deleteCustomer(id) {
	return  request({
		url: '/customer/delete',
		params:{	
	
			id
		}
	})
}

export function alterCustomer(customer) {
	return  request({
		url: '/customer/alter',
		params:customer
	})
}