<template>
	<div>
		<h1 class="title">品优购后台管理系统</h1>
		<h3 class="title">商品修改界面</h3>
		<el-card style="width: 40%;margin: 0 auto; margin-top: 2%; font-size: 18px;padding-top: 10px; ">
			<div class="input">类别：
			<select style="width: 221px; height: 30px;" v-model="item.proTypeId">
				<option value="1">奇石</option>
				<option value="2">民族饰品</option>
				<option value="3">精致珠宝</option>
				<option value="4">收藏天地</option>
				<option value="5">香水香氛</option>
				<option value="6">时尚配饰</option>
				<option value="7">时尚珠宝</option>
				
			</select></div>
			<div class="input">商品名：<el-input  v-model="item.name"></el-input></div>
			<div class="input">型号：<el-input  v-model="item.model"></el-input></div>
			<div class="input">价格：<el-input  v-model="item.price"></el-input></div>
			<div class="input">描述：<el-input  type="textarea":rows="3" v-model="item.description"></el-input></div>
			
			<br>
			<div style="text-align: center;"><el-button class="alterBtn" @click="alterClick">提交修改</el-button></div>
			<br>
			
			 <el-button round class="backBtn" @click="backClick">返回</el-button>
		</el-card>
	</div>
</template>

<script>
	import {alterProduct} from "../../../network/product/product.js"
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
				alterProduct(this.item)
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
		
		 position: relative;
		 left: 80%;
		 width: 20%;
	}
	.alterBtn{
		
	}
	.input{
		width: 50%;
		margin: 0 auto;
		margin-top: 2.5%;
		color: #4395ff;
	}
</style>
