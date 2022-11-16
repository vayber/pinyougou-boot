<template>
  <div id="header">
    <div class="logo">    
        <img src="../../assets/img/weibin.jpg" alt="">
    </div>
	<div class="menu">
		<span class="cover" @click="click(1)"  :class="{active:this.index == 1}">首页</span>
		<span class="cover"  @click="click(2)" :class="{active:this.index == 2}">购物车</span>
		<span class="cover"  @click="click(3)" :class="{active:this.index == 3}">联系客服</span>
		<span class="cover"  @click="click(4)" :class="{active:this.index == 4}">我的</span>
	</div>
	<div v-if="flag" class="right" @click="loginClick">用户登录</div>
	<div v-else class="customer">欢迎您:
	<span class="span1">{{customer.customerName}}</span>
	<span class="span2" @click="signOutClick">退出</span></div>
  </div>
</template>

<script>
	import {mapGetters} from 'vuex'
	
export default {
  name: 'Header',
  activated() {
  	if(Object.keys(this.customer).length != 0){
		this.flag = false
	}
  },
  data(){
	return{
		index:1,
		flag:true
	}  
  },
  computed:{
  	 ...mapGetters(['customer'])
	 
  },
  methods:{
	  click(key){
		this.index = key
		if(key == 1){
			this.homeClick()
		}
		if(key == 2){
			this.cartClick()
		}
		if(key == 3){
			this.serviceClick()
		}
		if(key == 4){
			this.meClick()
		}
	  },
	  homeClick(){
		  this.$router.push("/home")
		 
	  },
	  cartClick(){
		  if(Object.keys(this.customer).length === 0){
		      this.$toast.show("请先登录")
			  this.$router.push("/login")
		  }else{
		  	this.$router.push("/cart")
		  }
		  
		  
	  },
	  serviceClick(){
		  this.$router.push("/service")
	  },
	  meClick(){
		  if(Object.keys(this.customer).length === 0){
		      this.$toast.show("请先登录")
			  this.$router.push("/login")
		  }else{
		  	this.$router.push("/me")	
		  }
	  },
	  loginClick(){
		  this.$router.push("/login")
	  },
	  signOutClick(){
		  this.$store.commit("customerSignOut",{})
		  this.flag = !this.flag
		  this.$router.push("/home")
	  }
	  
	  
  }
}
</script>

<style scoped>
#header{
  height: 100px;
  width: 100%;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-bottom: 3px solid red;
  margin-top: -15px;
}
.logo{
  height: 100px;
  width: 300px;
  margin-left: 50px;
  
}
img{
  height: 100%;
  width: 100%;
}

.menu{
	margin-right: 8%;
}

.menu span{
  margin-left: 40px;
  font-size: 18px;
}
.cover,.right{
	cursor: pointer;
}
.cover:hover,.right:hover{
	color: #FF0000;
}
.active{
	color: #FF0000;
}
.right{
	margin-right: 50px;
	 color: #666;
	}
	
.customer{
	font-size: 18px;
	margin-right: 5%;
}	
.span1{
	color:#FF0000
}

.span2{
	position: relative;
	left: 25%;
	cursor: pointer;
}
.span2:hover{
	color:#FF0000
}
</style>
