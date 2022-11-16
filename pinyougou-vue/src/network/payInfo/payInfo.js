import {request} from '../request.js'

export function savePayInfo(payInfo,customerId) {
	return  request({
		url: '/payInfo/add',
		params:{
			type:payInfo.typeCard,
			name:payInfo.cardName,
			number:payInfo.cardId,
			billAddress:payInfo.billAddress,
			expiryDate:payInfo.expiryDate,
			customerId
		}
	})
}

export function getPayInfoById(customerId) {
	return  request({
		url: '/payInfo/query',
		params:{
			
			customerId
		}
	})
}