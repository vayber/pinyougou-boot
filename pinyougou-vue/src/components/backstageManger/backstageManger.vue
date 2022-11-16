<template>
	<div>
	<h1 class="title">品优购后台管理系统</h1>
	<el-container style="height: 500px; border: 1px solid #eee">
	  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
	    <el-menu :unique-opened="true" default-active="1-1">
		  
	      <el-submenu index="1" >
	        <template slot="title"><i class="el-icon-menu"></i>商品管理</template>
	        <el-menu-item-group>
	         <el-menu-item index="1-1" @click="ListClick(1)"><i class="el-icon-s-order"></i>商品列表</el-menu-item>
	        </el-menu-item-group>
			<el-menu-item-group>
			 <el-menu-item index="1-2" @click="addProduct"><i class="el-icon-circle-plus"></i>新增商品</el-menu-item>
			</el-menu-item-group>
	      </el-submenu>
		  
		  
	      <el-submenu index="2" >
	        <template slot="title"><i class="el-icon-menu"></i>顾客管理</template>
	        <el-menu-item-group>
	         <el-menu-item index="2-1" @click="ListClick(2)"><i class="el-icon-s-order"></i>顾客列表</el-menu-item>  
			  </el-menu-item-group>
	      </el-submenu>
		  
		  
		  
		  <el-submenu index="3" >
		    <template slot="title"><i class="el-icon-menu"></i>订单管理</template>
		    <el-menu-item-group>
		     <el-menu-item index="3-1" @click="ListClick(3)">
				<i class="el-icon-s-order" ></i> 订单列表
			 </el-menu-item>
		    </el-menu-item-group>
			
		  </el-submenu>
		  <el-submenu index="4">
		    <template slot="title"><i class="el-icon-setting"></i>设置</template>
		  <el-menu-item-group>
			  <el-menu-item index="4-2" @click="modifyPwd"><i class="el-icon-user-solid"></i>修改密码</el-menu-item>
		   <el-menu-item index="4-1" @click="loginOut"><i class="el-icon-error"></i>退出系统</el-menu-item>
		   
		  </el-menu-item-group>
		  </el-submenu>
	    </el-menu>
	  </el-aside>
	  
	  <el-container>
	      <el-header style="text-align: right; font-size: 12px">
	        
	      </el-header>
	      
	      <el-main>			    
			<keep-alive >
			  <router-view />
			</keep-alive>
		
	      </el-main>
	    </el-container>
	  </el-container>
	  
	  
	  </div>
</template>

<script>
	
	
	
	export default{
		name:"BackstageManger",
		
		methods:{
			ListClick(index){
				switch(index){
					case 1:
					this.$router.push("/productBackstageManger")
						break;
					case 2:
					this.$router.push("/customerBackstageManger")
						break;
					case 3:
					this.$router.push("/orderBackstageManger")
						break;		
				}
			},
			addProduct(){
				this.$router.push("/addProduct")
			},
			modifyPwd(){
				this.$router.push("/modifyPwd")
			},
			loginOut(){
				this.$router.push("/manage")
			}
			
		}
		
	
	}
</script>

<style scoped="scoped">
	.el-header {
	    background-color: #B3C0D1;
	    color: #333;
	    line-height: 60px;
	  }
	  
	  
	  .el-aside {
	    color: #333;
	  }
	  .title{
		  color: #B3C0D1;
		  text-align: center;
	  }
</style>
