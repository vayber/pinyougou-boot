<template>
	<div>
		<h1 class="title">品优购后台管理系统</h1>
		<h3 class="title">商品添加界面</h3>
		<el-card style="width: 40%;margin: 0 auto;  font-size: 18px;padding-top: 10px; ">
			<div style="color:#FF7F50;text-align: center;">
			添加图片：	<el-upload 
					style="width: 100px%;"
				  ref="upload"
				  list-type="picture-card"
				  :auto-upload="false"
				  :action="url"
				  :data="item"
				  :limit="1"
				  :on-success="success"
				  >
				  <i class="el-icon-plus" ></i>
				   
				</el-upload>
				
			</div>
			<div class="input">商品名：<el-input  v-model="item.name"></el-input></div>
			<div class="input">型号：<el-input  v-model="item.model"></el-input></div>
			<div class="input">价格：<el-input  v-model="item.price"></el-input></div>
			<div class="input">类别：
			<select style="width: 150px; height: 30px;" v-model="item.proTypeId">
				<option value="0"  v-show="false">请选择类别</option>
				<option value="1">奇石</option>
				<option value="2">民族饰品</option>
				<option value="3">精致珠宝</option>
				<option value="4">收藏天地</option>
				<option value="5">香水香氛</option>
				<option value="6">时尚配饰</option>
				<option value="7">时尚珠宝</option>
				
			</select></div>
			<div class="input">描述：<el-input  type="textarea":rows="3" v-model="item.description"></el-input></div>
			
			<br>
			<div style="text-align: center;"><el-button class="alterBtn" @click="addClick">添加商品</el-button></div>
			<br>
			
			 <el-button round class="backBtn" @click="backClick">返回</el-button>
		</el-card>
	</div>
</template>

<script>
	export default{
		name:"AddProduct",
		data(){
			return{
				url:"http://localhost:8083/product/add",
				item:{
					name:"",
					model:"",
					price:"",
					proTypeId:0,
					description:""
				},
				
			
			}	
		},
		methods:{
			backClick(){
				this.$router.go(-1)
			},
			addClick(){	
				
				 this.$refs.upload.submit();
			},
			//文件上传成功的钩子
			success(response){
				this.$toast.show(response)
				setTimeout(()=>{this.$router.push({
				 	path:"/backstageManger"
				})},1000)
				
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
		margin-top: 2.5%;
		color:#FF7F50;
	}
	.backBtn{
		 position: relative;
		 left: 80%;
		 width: 20%;
	}
	
</style>
