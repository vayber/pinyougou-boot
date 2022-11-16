import {request} from '../request.js'

export function getLoginUser(userName,password) {
	return  request({
		url: '/user/login',
		params:{
			
			userName,
			password
		}
	})
}

export function alterUserPwd(id,password) {
	return  request({
		url: '/user/alterUserPwd',
		params:{
			id,
			password
		}
	})
}