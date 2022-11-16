<template>
	<div>
		<h1 class="title">品优购后台管理系统</h1>
		<h3 class="title">商品详情界面</h3>
	<el-card class="detailCard">
	<div class="detailMain">
	  <div >
	    <img :src="item.img" alt="">
	  </div>
	  <div class="right">
	    <div class="name">名称：{{item.name}}</div>
	    <div class="type" >型号：{{item.model}}</div>
		<div class="price">价格：￥{{item.price}}</div>
		<div class="typeName">类别：{{item.typeName}}</div>
	    <div class="description">描述：{{item.description}}</div>
	    
	    
	  </div>
	</div>
	
	<el-button round class="backBtn" @click="backClick">返回</el-button>
	</el-card>
	</div>
</template>

<script>
	export default{
		name:"BackstageProductDetail",
		activated() {
			this.item = this.$route.query.item
		},
		data(){
			return{
				item:{}
			}
		},
		methods:{
			backClick(){
				this.$router.go(-1)
			}
		}
	}
</script>

<style scoped="scoped">
	img{
		margin-top: 25px;
		width: 100px;
		height: 120px;
		box-shadow:4px 4px 5px 3px #999;
	}
	.title{
			  color: #B3C0D1;
			  text-align: center;
	}
	.detailCard{
	  width: 50%;
	  margin:0 auto;
	  margin-top: 5%;
	}
	.detailMain{
	  display: flex;
	}
	.name {
	  font-size: 28px;
	  margin-left: 25px;
	  margin-bottom: 22px;
	}
	.type{
		margin-left: 25px;
		margin-bottom: 22px;
		font-size: 19px;
	}
	.description{
		margin-left: 25px;
		margin-bottom: 22px;
		color:blueviolet;
	}
		.price{
			margin-left: 25px;
			margin-bottom: 22px;
			color: #FF0000;
			font-size: 18px;
		}
	.typeName{
		margin-left: 25px;
		margin-bottom: 22px;
		font-size: 17.5px;
	}	
	.right{
	  margin-top: 10px;
	  width: 800px;
	  position: relative;
	}
	.backBtn{
		margin-top: 25px;
		 position: relative;
		 left: 80%;
		 width: 20%;
	}
</style>
