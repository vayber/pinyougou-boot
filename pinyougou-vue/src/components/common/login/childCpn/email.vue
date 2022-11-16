<template>
	<el-form
	  class="loginForm" 
	  :style="'transform: rotateY('+ y+'deg) translate(-50%);transform-origin:center left;'">
	  <div class="backstage" @click="manageClick">管理登录</div>
	  
	  <h3 >邮箱账号登录</h3>
	 
	  <el-form-item prop="email" label-width="0">
	    <el-input 
	      class="inputItem"
	      v-model="email" 
	      placeholder="请输入您的邮箱账号" 
	      prefix-icon="el-icon-user"/>
	  </el-form-item >
	  <el-form-item  label-width="0">
	    <el-input 
	      class="inputItem" 
	      v-model="emailPwd" 
	      placeholder="请输入您的密码" 
	      prefix-icon="el-icon-lock" 
	      type='password'/>
	  </el-form-item>
	  <el-button type="danger" size="medium" class="button" @click="loginClick">登录</el-button>
	 <div class="register" @click="registerClick">免费注册</div>
	</el-form>
</template>

<script>
	import {customerLogin} from "../../../../network/customer/customer.js"
	import {mapGetters} from 'vuex'
	export default{
		name:"EMail",
		data(){
			return{
				email:"",
				emailPwd:"",
				y:0,
				i:null,
				j:null
				
			}
		},
		computed:{
			 ...mapGetters(['customer']),
		},
		methods:{
			registerClick(){
				this.$router.push("/register")
			},
			loginClick(){
			
			customerLogin(this.email,this.emailPwd).then(res =>{
				this.$store.commit("customerLogin",res)	
			})
			
			setTimeout(() => {
				if(Object.keys(this.customer).length === 0){
				    this.$toast.show("登录失败,邮箱或密码错误！")
				}else{
					this.$router.push("/home")
				}
			},100)
	
			
			
			},
			async manageClick(){
				await this.rotate()
				 setTimeout(() => {
				 	this.$router.push("/manage")
				 }, 900)
			},
			rotate(){	
				this.i = setInterval(this.frame,5) 
			},
			frame(){
				if(this.y == 90){
					clearInterval(this.i)
					this.j = setInterval(this.frame1,5)	
				}else{
					this.y++
				}
			},
			frame1(){
				if(this.y == 0){
					clearInterval(this.j)
				
				}else{
					this.y--
				}
			}
			
		}
	}
</script>

<style scoped="scoped">
	.backstage{
		 display: inline-block;
		 margin-left: 81%;
		 color:#666666 ;
		 cursor: pointer;
	}
	.backstage:hover{
		color: #FF0000;
	}
	h3{
		margin-bottom: 15%;
	}
	.loginForm{
	  background-color: white;
	  margin: 0 auto;
	  padding: 30px;
	  position: absolute;
	  top: 200px;
	  left: 80%;
	  transform: translate(-50%);
	  height: 360px;
	  width: 350px;
	 
	  text-align: center;
	}
	.button{
		margin-top: 5%;
		width: 40%;		
	}
	.register{
	  text-decoration: none;
	  color: rgb(253, 80, 80);
	  font-size: 14px;
	  display: inline-block;
	  margin-top: 45px;
	  margin-left: 240px;
	  cursor: pointer;
	}
	.dafa{
		transform: rotateY(180egd);
		transform: translate(-50%);
	}
</style>
