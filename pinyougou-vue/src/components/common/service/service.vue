<template>
	<div>
		<div class="me">
			<img class="img" src="../../../assets/img/me.png" alt="">
		</div>
		<el-button round class="backBtn" @click="backClick">返回</el-button>
	</div>
	
</template>

<script>
	export default{
		name:"Me",
		methods:{
			backClick(){
				this.$router.go(-1)
			}
		}
	}
</script>

<style scoped="scoped">
	.me{
		  width: 300px;
		  background-color: white;
		  height: 400px;
		  box-shadow: 0 1px 5px #ccc;
		   text-align: center;
		  margin: 0 auto;
		  margin-top: 10%;
		  }
		  .backBtn{
		  	 position: absolute;
		  	 right: 10%;
			 bottom: 5%;
		  	 width: 10%;
		  }
</style>
