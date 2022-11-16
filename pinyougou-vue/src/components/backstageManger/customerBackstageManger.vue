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
		           @click="handleSelect( scope.row)">查看</el-button>
				   <el-button
				     size="mini"
				     @click="handleAlter( scope.row)">修改</el-button>
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
	import {getCustomerList,getCustomerCount,deleteCustomer} from "../../network/customer/customer.js"
	export default{
		name:"CustomerBackstageManger",
		activated() {
			getCustomerCount().then(res =>{
				this.count = res
			})
			getCustomerList(1,this.pageSize).then(res => {	
				this.List = res
				
			})	
		},
		data(){
			return{	
				List:[],
				Arrays:[{"label":"顾客ID",prop:"id"},
						{"label":"顾客名",prop:"customerName"},
						{"label":"邮箱",prop:"email"},
						{"label":"密码",prop:"emailPwd"}
				],
				count:10,
				pageSize:5
			}
		},
		methods:{
			handleSelect(item){
				this.$router.push({
					path:"/backstageCustomerDetail",
					query:{
						item
					}
				})
			},
			handleAlter(item){
				this.$router.push({
					path:"/alterCustomer",
					query:{
						item
					}
				})
			},
			handleDelete(index,item){
				deleteCustomer(item.id)
				this.$toast.show("删除成功！")
				this.List.splice(index,1)
			},
			currentChange(currentPage){
				getCustomerList(currentPage,this.pageSize).then(res => {
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
