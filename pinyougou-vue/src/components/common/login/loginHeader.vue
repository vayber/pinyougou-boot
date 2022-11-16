<template>
	<div id="header">
	  <div class="logo" @click="goHome">    
	      <img src="../../../assets/img/weibin.jpg" alt="">
	  </div>
		
		<div class="right" @click="adviceClick">"登录页面"改进建议</div>
	</div>
</template>

<script>
	export default{
		name:"LoginHeader",
		methods:{
			adviceClick(){
				this.$router.push("/service")
			},
			goHome(){
				this.$router.push("/")
			}
		}
	}
</script>

<style scoped="scoped">
	.logo{
		cursor: pointer;
	}
	#header{
	  height: 100px;
	  display: flex;
	  align-items: center;
	  justify-content: space-between;
	  padding: 10px 70px;
	  background-color: rgb(252, 252, 252);
	/*  border-bottom: 3px solid #666666; */
	}
	img{
		height: 100px;
		width: 300px;
	}
	.right{
		  font-size: 16px;
		  color: #666666;
		  text-decoration: none;
			cursor: pointer;
	}
	.right:hover{
		color: #FF0000;
	}
</style>
