<template>
	
		<el-card class="card">
			<div class="title">我的订单 ({{count}})</div>
			 <el-table class="table"
			    :data="data"
			    border
				height="250"
				empty-text="订单里空空如也,快去买一件吧~~"
			    >
				
			    <el-table-column
			      prop="productName"
			      label="商品名称"
			      width="190">
			    </el-table-column>
				
				<el-table-column
				  prop="counts"
				  label="数量"
				   width="50">
				</el-table-column>
				
				<el-table-column
				  prop="isPayments"
				  label="是否支付"
				  width="80"
				  >
				</el-table-column>
				
			    <el-table-column
			      prop="consignee"
			      label="收货人"
				   width="120">
			    </el-table-column>
				
				<el-table-column
				  prop="phone"
				  label="联系电话"
				  width="125">
				  
				</el-table-column>
				
				
				<el-table-column
				  prop="address"
				  label="地址"
				  width="220">
				</el-table-column>
				
				<el-table-column
				prop="creationDate"
				  label="下单时间"
				  width="180">
				   
				</el-table-column>
				
				<el-table-column
				prop="totalPrice"
				  label="总金额"
				  width="100">
				   
				</el-table-column>
				
			  </el-table>
			  
			  <el-pagination
			  class="page"
			   background
			   hide-on-single-page
			    layout="prev, pager, next"
			    :total="count"
			  	:page-size="pageSize"
			  	  @current-change="currentChange"
			  	>
			  </el-pagination>
			  
		</el-card>
	
</template>

<script>
	import {getOrdersById,getOrdersCountById} from "../../../network/order/order.js"
	import {mapGetters} from 'vuex'
	export default{
		name:'Me',
		created() {	
			
			getOrdersById(this.customer.id,1,this.pageSize).then(res =>{
				for(let i in res){
					if(res[i].isPayment == 1)
					 res[i].isPayments = "未支付"		
					if(res[i].isPayment == 2)
					 res[i].isPayments = "已支付"
				}
				this.data = res
			})
			
			getOrdersCountById(this.customer.id).then(res =>{
				this.count = res
			})
		},
		computed:{
		   ...mapGetters(['customer'])
		   },
		data(){
			return{
				data:[],
				count:10,
				pageSize:4
			}
		},
		methods:{
			currentChange(currentPage){
				getOrdersById(this.customer.id,currentPage,this.pageSize).then(res =>{
				for(let i in res){
					if(res[i].isPayment == 1)
					 res[i].isPayments = "未支付"		
					if(res[i].isPayment == 2)
					 res[i].isPayments = "已支付"
				}
					this.data = res
					
				})
			}
		}
	}
</script>

<style scoped="scoped">
	.title{
		font-size: 22px;
	}
	.card{
		text-align: center;
	
		}
		.table{
			width: 73%;
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
