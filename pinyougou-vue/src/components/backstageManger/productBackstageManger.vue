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
	import {getProductList,getProductCount,deleteProduct} from "../../network/product/product.js"
	import {getProTypeList} from "../../network/proType/proType.js"
	export default{
		name:"ProductBackstageManger",
		activated() {
			getProTypeList().then(res =>{
					this.proType = res
					
			})
			getProductCount().then(res => {
				this.count = res
			})
			
			getProductList(1,this.pageSize).then(res => {
				
				for(let i in res){
					res[i].img = "http://vayber.top/"+res[i].img 
					for(let j in this.proType){
						if(res[i].proTypeId === this.proType[j].id)
						{
							res[i].typeName= this.proType[j].name
						}
					}
				}
				this.List = res
				
				
			})
		},
		data(){
			return{	
				List:[],
				proType:[],
				Arrays:[
						{"label":"商品名称",prop:"name"},
						{"label":"型号",prop:"model"},
						{"label":"价格",prop:"price"},
						{"label":"类别",prop:"typeName"}
				],	
				count:10,
				pageSize:5
			}
		},
		methods:{
			handleSelect(item){
				this.$router.push({
					path:"/backstageProductDetail",
					query:{
						item
					}
				})
			},
			handleAlter(item){
				this.$router.push({
					path:"/alterProduct",
					query:{
						item
					}
				})
			},
			handleDelete(index,item){
				deleteProduct(item.id)
				this.$toast.show("删除成功！")
				this.List.splice(index,1)
			},
			currentChange(currentPage){
				getProductList(currentPage,this.pageSize).then(res => {
					
					for(let i in res){
						res[i].img = "http://vayber.top/"+res[i].img 
						for(let j in this.proType){
							if(res[i].proTypeId === this.proType[j].id)
							{
								res[i].typeName= this.proType[j].name
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
