<template>
	<div >
		<el-card class="card">
			
		<nav-bar class="navbar">
		  <div slot='left' v-show="delShow" >
			  <button class="btns" @click="delClick()">清空购物车</button> 
			  </div>
		  <div slot='center'  style="font-size: 19px;">购物车({{cartLength}})</div>
		  <div slot='right' v-show="manage" @click="manageClick"><button class="btn">管理</button></div>
		  <div slot='right' v-show="!manage" @click="completeClick"><button class="btn">完成</button></div>
		</nav-bar>
			
			 <el-table class="table"
			    :data="cartList"
			    border
				height="250"
				empty-text=" 购物车竟然是空的,再忙,也要记得买点什么犒劳自己~~~"
			    >
			    <el-table-column
			      prop="id"
			      label="产品ID"
			      width="80">
			    </el-table-column>
				
			    <el-table-column
			      prop="name"
			      label="产品名称"
			      width="260">
			    </el-table-column>
				
			    <el-table-column
			      prop="count"
			      label="数量"
				   width="50">
			    </el-table-column>
				
				<el-table-column
				  prop="price"
				  label="单价"
				  width="100">
				</el-table-column>
				<el-table-column
				  prop="subtotal"
				  label="小计"
				  width="165"
				  >
				</el-table-column>
				
				<el-table-column
				prop="isChecked"
				  label="选择"
				  width="50">
				   <template slot-scope="scope">
					    <el-checkbox v-model="scope.row.checked"></el-checkbox>
				  </template>
				</el-table-column>
				
				<el-table-column
				prop="isChecked"
				  label="操作"
				  width="180">
				   <template slot-scope="scope">
				  <el-button class="btn"  @click="addClick(scope.row)">+1</el-button>
				  <el-button class="btn" @click="subClick(scope.row,scope.$index)">-1</el-button>
				  </template>
				</el-table-column>
				
			  </el-table>
			  
			<div><h3>已选择{{checkLength}}件商品，合计：￥<span class="span">{{totalPrice}}</span> <button class="totalBtn" @click="checkOut">结算</button></h3></div>  
			  
		</el-card>
		
	</div>
</template>

<script>	
	import navBar from "../NavBar.vue"
	import {mapGetters} from 'vuex'
	export default{
		name:"Cart",
		data() {
		      return {
				manage:true,
				delShow:false
		      }
		    },
			computed:{
			   ...mapGetters(['cartLength','cartList']),
			   //计算总价格
			   totalPrice(){
			     return  this.$store.state.cartList.filter(item => {
			      return item.checked
			     }).reduce((preValve,item) => {
			       return preValve + item.price * item.count
			     },0).toFixed(2)
			   },
			   
			   checkLength(){
			     return this.$store.state.cartList.filter(item => item.checked === true).length
			   }
			},
			components:{
			navBar
		},
		methods:{
		  manageClick(){
		    this.delShow = !this.delShow
		    this.manage = ! this.manage
		  },
		  completeClick(){
		    this.delShow = !this.delShow
		    this.manage = ! this.manage
		  },
		  delClick(){
			const newList = []
			this.$store.commit("delCart",newList)
			
		  },
		  addClick(item){
			  this.$store.commit("addCounter",item)
		  },
		  subClick(item,index){	 
			  this.$store.commit("subCounter",{
				  item:item,
				  index:index
			  })
		  },
		  checkOut(){
			 
			  
			  this.$router.push({
				   path:"/address"
			  })
		  }
	}
	}
</script>

<style scoped="scoped">	
.navbar{
	width: 50%;
	margin: 0 auto;
	
}
.card{
	text-align: center;

	}
	.table{
		width: 61%;
		margin: 0 auto;
		
	}
	
	.btn{
		color: aliceblue;
		background-color: coral;
		border-radius: 50%;
		border: #F0F8FF;
		cursor: pointer;
		width: 60px;
		height: 30px;
	}
	
	.btns{
		color: aliceblue;
		background-color: coral;
		border-radius: 50%;
		border: #F0F8FF;
		cursor: pointer;
		width: 80px;
		height: 40px;
	}
	
	.totalBtn{
		margin-left: 10%;
		color: aliceblue;
		background-color: coral;
		background-color: coral;
		border-radius: 50%;
		border: #F0F8FF;
		cursor: pointer;
		width: 100px;
		height: 40px;
		font-size: 18px;
	}
	.span{
		font-size: 24px;
		color: coral;
	}
	
</style>
