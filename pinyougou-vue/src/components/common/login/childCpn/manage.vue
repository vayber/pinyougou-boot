<template>
	<el-form
	  class="loginForm" 
	  :style="'transform: rotateY('+ y+'deg) translate(-50%);transform-origin:center left;'">
	  <div class="backstage" @click="eMailClick">邮箱登录</div>
	  
	  <h3 >管理账号登录</h3>
	 
	  <el-form-item prop="email" label-width="0">
	    <el-input 
	      class="inputItem"
	      v-model="userName" 
	      placeholder="请输入您的管理员账号" 
	      prefix-icon="el-icon-user"/>
	  </el-form-item >
	  <el-form-item  label-width="0">
	    <el-input 
	      class="inputItem" 
	      v-model="password" 
	      placeholder="请输入您的密码" 
	      prefix-icon="el-icon-lock" 
	      type='password'/>
	  </el-form-item>
	  <el-button type="danger" size="medium" class="button" @click="loginClick">登录</el-button>
	 
	</el-form>
</template>

<script>
	import {getLoginUser} from "../../../../network/user/user.js"
	
	export default{
		name:"Manage",
		created() {
		},
		data(){
			return{
				userName:"",
				password:"",
				y:0,
				i:null,
				j:null,
				user:null
				
			}
		},
		methods:{
			loginClick(){
				
				
			getLoginUser(this.userName,this.password).then(res => {			
				this.user = res	
				
			})
			
			setTimeout(() => {
				if(this.user == ""){
				    this.$toast.show("登录失败,账号或密码错误！")
				}else{			
					
					sessionStorage.setItem("user",JSON.stringify(this.user))
					console.log(JSON.parse(sessionStorage.getItem("user")))
					this.$router.push("/backstageManger")
				}
			},100)
			},
			
			
			async eMailClick(){
				 this.rotate()
	
				setTimeout(() => {
					this.$router.push("/email")
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
