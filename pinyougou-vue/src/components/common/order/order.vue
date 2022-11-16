<template>
	<div>
		
		<div class="span">
			<span class="span1">订单信息</span>
			<span  class="span2">步骤三</span>			
			</div>
			<el-table class="table"
			   :data="products"
			   border
				height="250"
			   >							
			   <el-table-column
			     prop="name"
			     label="产品名称"
			     width="325">
			   </el-table-column>
							
			   <el-table-column
			     prop="count"
			     label="数量"
				  width="88">
			   </el-table-column>
							
				<el-table-column
				  prop="price"
				  label="单价"
				  width="120">
				</el-table-column>
				<el-table-column
				  prop="price"
				  label="小计"
				  width="200"
				  >
				</el-table-column>
										
			 </el-table>
			 <table class='getPrice'>
			   <tr><td>小计：</td><td>￥{{subtotal}}</td></tr>
			   <tr><td>税额：</td><td>￥{{tax}}</td></tr>
			   <tr><td>运费：</td><td>￥{{freight}}</td></tr>
			   <tr><td>总计：</td><td class="weight">￥{{totalMoney}}</td></tr>
			 </table>		
			 
			 <div class="btn">
				 <el-button type="danger" size="medium" class="button" @click="previousClick">
					 <span class="spanBtn"><<</span>Previous
					 </el-button>
				 <el-button type="danger" size="medium" class="button" @click="confirmClick">
					 Confirm<span class="spanBtn">>></span>
					 </el-button>
			 </div>
			 
	</div>
</template>

<script>
import {mapGetters} from 'vuex'
import {savePayInfo} from "../../../network/payInfo/payInfo.js"
import {saveOrders} from "../../../network/order/order.js"

	export default{
		name:"Order",	
		data() {
		      return {
		        products: [],			//商品
				addressForm:{},		//地址
				paymentForm:{}		//支付信息				
		      }
		    },
			computed:{
			   ...mapGetters(['product','cartList',"customer"]),
			   //小计
			   subtotal(){
			     return  this.products.reduce((preValve,item) => {
			       return preValve + item.price * item.count
			     },0).toFixed(2)
			   },
			   //税额
			   tax(){
				   return (this.subtotal * 0.065).toFixed(2)
			   },
				//运费
				  freight(){
					  return (10).toFixed(2)
				  },			
			   //总价格
			   totalMoney(){
				   return (parseInt(this.subtotal) +parseInt(this.tax) + parseInt(this.freight)).toFixed(2)
			   }
			   },
			   
			created() {
				this.addressForm = this.$route.query.v.addressForm
				this.paymentForm = this.$route.query.v.paymentForm
				
				
				
				
				if(Object.keys(this.product).length === 0){
				this.products = JSON.parse(JSON.stringify(this.cartList.filter( item => {
					return item.checked === true  
				 })))
					
				}else{
					this.products.push(this.product)
				}
				
			},
			methods:{
			  previousClick(){
				  this.$router.go(-1)
			  },
			  confirmClick(){
				  //保存支付信息
				 savePayInfo(this.paymentForm,this.customer.id)
				  								  
				
				 
				 let arr = {}
				 let orders = []
				 
				 for(let i in this.products){
					 arr = Object.assign(this.products[i],this.addressForm) 
					 orders.push(arr)
				 }
				 for(let i in orders){
				     saveOrders(orders[i],this.customer.id)
				}
				
				//清除商品
				 this.$store.commit("delProduct",{})
				  
				//过滤出未选中的购物车
				 let unCheckCart = this.cartList.filter( item => {
					return item.checked === false  
				 })
				 
				 
				 //清除已选中的购物车(把未选中的数组代替购物车数组)
				 this.$store.commit("delCart",unCheckCart)
				  
				  this.$toast.show("下单成功！")
				
				setTimeout(() => {this.$router.push("/me")},2000)
			  }
				}
	}
</script>

<style scoped="scoped">
	.span{
		background-color: #cccccc;
		width: 760px;
		height: 40px;
		line-height: 40px;
		margin:0 auto;
		color: #666666;
		margin-top: 2%;
	}
	
	.span2{
		margin-left: 84%;
		color: #FF0000;
	}
	.table{
		width: 50%;
		margin: 0 auto;
		
	}
	.getPrice{
	  position: relative;
	  left: 800px;
	  top: 30px;
	  margin-bottom: 70px;
	  font-size: 14px;
	  color: #666666;
	}
	.getPrice td{
	  width: 125px;
	}
	
	.weight{
	  font-weight: bolder;
	  font-size: 18px;
	  color: #FF0000;
	}
	.btn{
		text-align: center;
	}
	
	.button{
		
		width: 15%;
		
	}
	.spanBtn{
		margin-right: 5%;
		margin-left: 5%;
	}
</style>
