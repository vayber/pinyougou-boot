<template>
	<div>
		<h1 class="title">品优购后台管理系统</h1>
		<h3 class="title">订单修改界面</h3>
		<el-card style="width: 40%;margin: 0 auto; margin-top: 2%; font-size: 18px;padding-top: 10px; ">
			<div class="input">支付状态：
			<select style="width: 150px; height: 30px;" v-model="item.isPayment">
				<option value="1">未支付</option>
				<option value="2">已支付</option>
			</select></div>
			<div class="input">收货人：<el-input  v-model="item.consignee"></el-input></div>
			<div class="input">收货地址：<el-input  v-model="item.address"></el-input></div>
			<div class="input">联系电话：<el-input  v-model="item.phone"></el-input></div>
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
	 import {alterOrder} from "../../../network/order/order.js"
	export default{
		name:"AlterOrder",
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
				alterOrder(this.item)
				this.$toast.show("修改成功！")
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
