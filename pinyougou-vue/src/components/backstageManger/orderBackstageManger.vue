<template>
	<div>
	<el-table
	     :data="List"
	      style="width: 100%">
		  
	      <el-table-column :prop="item.prop" :label="item.label" v-for="item,index in Arrays" :key="item.index"></el-table-column>
		  <el-table-column label="操作" width="210">
		       <template slot-scope="scope">
		         <el-button
		           size="mini"
		           @click="handleSelect(scope.row)">查看</el-button>
				   <el-button
				     size="mini"
				     @click="handleAlter(scope.row)">修改</el-button>
		         <el-button
		           size="mini"
		           type="danger"
		           @click="handleDelete(scope.$index, scope.row)">删除</el-button>
		       </template>
		     </el-table-column>
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
		</div>
</template>

<script>
	import {getOrderList,getOrderCount,deleteOrder } from "../../network/order/order.js"
	import {getCustomerListNoPage} from "../../network/customer/customer.js"
	export default{
		name:"OrderBackstageManger",
		activated() {
			getOrderCount().then(res =>{
				this.count = res
			})
			getCustomerListNoPage().then(res => {
				this.customerList = res
							
			})
			getOrderList(1,this.pageSize).then(res => {
				for(let i in res){
					if(res[i].isPayment == 1)
					 res[i].isPayments = "未支付"		
					if(res[i].isPayment == 2)
					 res[i].isPayments = "已支付"
					 for(let j in this.customerList){
					 	if(res[i].customerId === this.customerList[j].id)
					 	{
					 		res[i].customerName= this.customerList[j].customerName
					 	}
					 }
				}
				
				this.List = res
			}) 
			
			
			
		},
		data(){
			return{	
				List:[],
				customerList:[],
				Arrays:[{"label":"订单ID",prop:"id"},
						{"label":"商品名称",prop:"productName"},
						{"label":"数量",prop:"counts"},
						{"label":"支付状态",prop:"isPayments"},
						{"label":"顾客名",prop:"customerName"},
						{"label":"下单时间",prop:"creationDate"}
				],
				count:10,
				pageSize:5
			}
		},
		methods:{
			handleSelect(item){
				this.$router.push({
					path:"/backstageOrderDetail",
					query:{
						item
					}
				})
			},
			handleAlter(item){
				this.$router.push({
					path:"/alterOrder",
					query:{
						item
					}
				})
			},
			handleDelete(index,item){
				deleteOrder(item.id)
				this.$toast.show("删除成功！")
				this.List.splice(index,1)
			},
			currentChange(currentPage){
				getOrderList(currentPage,this.pageSize).then(res => {
					for(let i in res){
						if(res[i].isPayment == 1)
						 res[i].isPayments = "未支付"		
						if(res[i].isPayment == 2)
						 res[i].isPayments = "已支付"
						 for(let j in this.customerList){
						 	if(res[i].customerId === this.customerList[j].id)
						 	{
						 		res[i].customerName= this.customerList[j].customerName
						 	}
						 }
					}
					
					this.List = res
				}) 
			}
		}
		
		
		}
</script>

<style scoped="scoped">
.page{
		margin-top: 2%;
		margin-left: 35%;
	}
</style>
