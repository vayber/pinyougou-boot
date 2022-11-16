<template>
	<div>
		<h1 class="title">品优购后台管理系统</h1>
			<h3 class="title">密码修改界面</h3>
		<el-card style="width: 40%;margin: 0 auto; margin-top: -12%;">
			
			<el-form  :model="newUser" :rules="rules" ref="modifyForm">
				
			<el-form-item class="input" prop="oldPassword">
				原密码：<el-input show-password v-model="newUser.oldPassword"></el-input>
				</el-form-item>
				
			<el-form-item class="input" prop="newPassword">
				新密码：<el-input show-password v-model="newUser.newPassword"></el-input>
				</el-form-item>
				
			<el-form-item class="input" prop="newPasswordAgain">
				再次输入：<el-input show-password v-model="newUser.newPasswordAgain"></el-input>
				</el-form-item>
			<br>
			<br>
			<div style="text-align: center;"><el-button class="alterBtn" @click="modifyPwd">提交修改</el-button></div>
			<br>
			<br>
			 <el-button round class="backBtn" @click="backClick">返回</el-button>
			 </el-form>
		</el-card>
	</div>
</template>

<script>
	import {alterUserPwd} from "../../../network/user/user.js"
	
	export default{
		name:"modifyPwd",
		activated() {
			if(sessionStorage.getItem("user") != null){
			
		this.user = JSON.parse(sessionStorage.getItem("user"))
			}
		},
		data(){
			
			const checkOldPassword = (rule, value, callback) => {
			  if (this.user.password != value) {
			    callback(new Error('请输入正确的原密码！'))
			  }
			  callback();
			}
			
			const validateNewPassword = (rule, value, callback) => {
			  if (this.newUser.newPasswordAgain !== '') {
			    this.$refs.modifyForm.validateField('validateNewPasswordAgain');
			  }
			  callback();
			}
			
			const validateNewPasswordAgain = (rule, value, callback) => {
			  if (value !== this.newUser.newPassword) {
			    callback(new Error('两次输入密码不一致!'));
			  } else {
			    callback();
			  }
			}
			
			
			return{
				user:{},
				newUser:{
				oldPassword:"",
				newPassword:"",
				newPasswordAgain:""
				},
			rules:{ 
					  oldPassword: [{ required: true, message: '请输入原密码', trigger: 'blur' },
					    { validator: checkOldPassword, trigger: 'blur' }],
					  newPassword: [ 
					    { required: true, message: '请输入新密码', trigger: 'blur' },
						{validator: validateNewPassword, trigger: 'blur' }],
					  newPasswordAgain: [
					    { required: true, message: '请再次输入密码', trigger: 'blur' },
					    { validator: validateNewPasswordAgain, trigger: 'blur' }
					  ]  
				}
			}
			
			
		},
		methods:{
			
			modifyPwd(){
				
				this.$refs.modifyForm.validate(async valid => {
				  if (!valid) return
					alterUserPwd(this.user.id,this.newUser.newPassword).then(res => {
						this.$toast.show(res)
							
						this.$router.push("/manage")	
					})
						
				})
				
				
			},
			
			backClick(){
				this.$router.go(-1)
			}
		}
	}
</script>

<style scoped="scoped">
	.title{
			  color: #B3C0D1;
			  text-align: center;
	}
	.input{
		width: 50%;
		margin: 0 auto;
		margin-top: 3%;
		color: #4395ff;
	}
	.backBtn{
		margin-top: 25px;
		 position: relative;
		 left: 80%;
		 width: 20%;
	}
	
</style>
