import {request} from '../request.js'

export function addCustomer(customer) {
	return  request({
		url: '/customer/add',
		params:{
			customerName:customer.customerName,
			eMail:customer.eMail,
			eMailPwd:customer.eMailPwd
		}
	})
}