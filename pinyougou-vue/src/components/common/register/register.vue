<template>
	<div>
		
 <el-form class="form" :model="customer" :rules="rules" ref="registerForm">
	 <div class="span">
	 	<span class="span1">注册新用户</span>
	 	<span  class="span2">已有账号,去</span>
	 	<span  class="span3" @click="loginClick">登录</span>
	 	</div>
 	<fieldset id="mey">
 		<div class="align">
 		<el-form-item label="用户名:" prop="customerName" >
 		  <el-input   v-model="customer.customerName"  placeholder="请输入用户名"/>
 		</el-form-item>
		
		<el-form-item label="邮箱:"   prop="eMail">
		  <el-input  v-model="customer.eMail"   placeholder="请输入邮箱"/>
		</el-form-item>
		
 		<el-form-item label="密码:" prop="eMailPwd">
 		  <el-input  type="password" v-model="customer.eMailPwd"  placeholder="请输入密码"/>
 		</el-form-item>
		
		
 		<el-form-item label="再次输入密码:"  prop="eMailPwdAgain">
 		  <el-input  type="password" v-model="customer.eMailPwdAgain"   placeholder="请再次输入密码"/>
 		</el-form-item>
 		
		</div>
		<br>
		<el-button type="danger" size="medium" class="button" @click="loginClick">完成注册</el-button>
 	</fieldset>
	</el-form>
	</div>
</template>

<script>
 import {addCustomer} from "../../../network/register/register.js"

export default {
  name: "Register",
  data(){
	  //自定义验证器
	  const checkEMail = (rule, value, callback) =>{
	    const regEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])/
	    if(regEmail.test(value)){
	      return callback()
	    }
	    callback(new Error('请输入合法的邮箱！'))
	  }
	  
	  const validateEMailPwd = (rule, value, callback) => {
	    if (this.customer.eMailPwdAgain !== '') {
	      this.$refs.registerForm.validateField('eMailPwdAgain');
	    }
	    callback();
	  }
	  
	  const validateEMailPwdAgain = (rule, value, callback) => {
	    if (value !== this.customer.eMailPwd) {
	      callback(new Error('两次输入密码不一致!'));
	    } else {
	      callback();
	    }
	  } 
	  return{
		customer:{
			customerName:"",
			eMail:"",
			eMailPwd:"",
			eMailPwdAgain:""
		},
		rules:{
			//required 代表必填项   message 代表提示信息  trigger 代表 在什么时候触发校验
			  customerName: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
			  eMail: [{ required: true, message: '请输入邮箱', trigger: 'blur' },
			    { validator: checkEMail, trigger: 'blur' }],
			  eMailPwd: [ 
			    { required: true, message: '请输入密码', trigger: 'blur' },
			    { validator: validateEMailPwd, trigger: 'blur' }],
			  eMailPwdAgain: [
			    { required: true, message: '请再次输入密码', trigger: 'blur' },
			    { validator: validateEMailPwdAgain, trigger: 'blur' }
			  ]  
		}
	  }
	  
  },
  methods:{
	  loginClick(){
		  //如果验证没问题
		  this.$refs.registerForm.validate(async valid => {
		    if (!valid) return
			 addCustomer(this.customer)
			 
			 this.$toast.show("注册成功！")
			 
		     this.$router.push('/login')
		  })
		 
	  }
  }
}
</script>

<style scoped>
	
	.form{
		margin-top: 3%;
	}
	#mey{
	width: 700px;
	height: 500px;
	margin:0 auto;
	line-height: 42px;
	text-align: center;
	border:2px solid #808080;
	   
	}
	.align{
		display: inline-block;
		text-align: right;
		
	}
	
	input{
		width: 250px;
		height: 25px;
	}
	label{
		font-size: 21px;
	}
	.span{
		background-color: #cccccc;
		width: 730px;
		height: 40px;
		line-height: 40px;
		margin:0 auto;
		color: #666666;
	}
	.span2{
		margin-left: 70%;
	}
	.span3{
		cursor: pointer;
		color: #FF0000;
	}
	.button{
		margin-top: 5%;
		width: 30%;
	}
</style>
