import {request} from '../request.js'

export function getProTypeList() {
	return  request({
		url: '/proType/getProTypeList'
	})
}