<template>
	<div>
		<h1 class="title">品优购后台管理系统</h1>
		<h3 class="title">顾客修改界面</h3>
		<el-card style="width: 40%;margin: 0 auto; margin-top: 2%; font-size: 18px;padding-top: 10px; ">
			<div class="input">顾客名：<el-input  v-model="item.customerName"></el-input></div>
			<div class="input">邮箱号：<el-input  v-model="item.email"></el-input></div>
			<div class="input">密码：<el-input  v-model="item.emailPwd"></el-input></div>
			<br>
			<br>
			<div style="text-align: center;"><el-button class="alterBtn" @click="alterClick">提交修改</el-button></div>
			<br>
			<br>
			 <el-button round class="backBtn" @click="backClick">返回</el-button>
		</el-card>
	</div>
</template>

<script>
	import {alterCustomer} from "../../../network/customer/customer.js" 
	export default{
		name:"AlterCustomer",	
		activated() {
			this.item = this.$route.query.item

		},
		data(){
			return{
				item:{}
			}
		},
		methods:{
			alterClick(){
				console.log(this.item)
				alterCustomer(this.item).then(res =>{
					this.$toast.show(res,1000)
				})
				setTimeout(()=>{this.$router.push({
					path:"/backstageManger"
				
				})},1000)
				
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
	.backBtn{
		margin-top: 25px;
		 position: relative;
		 left: 80%;
		 width: 20%;
	}
	.alterBtn{
		
	}
	.input{
		width: 50%;
		margin: 0 auto;
		margin-top: 5%;
		color: #4395ff;
	}
</style>
