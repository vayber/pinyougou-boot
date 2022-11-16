<template>
	<div>
		<h1 class="title">品优购后台管理系统</h1>
		<h3 class="title">订单详情界面</h3>
	<el-card style="width: 40%;margin: 0 auto;">
		 <el-descriptions style="" title="订单信息"  :column="1"  border >
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-info"></i>
		        订单id
		      </template>
		      {{item.id}}
		    </el-descriptions-item>
			
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-shopping-bag-1"></i>
		        商品名
		      </template>
		      {{item.productName}}
		    </el-descriptions-item>
			
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-eleme"></i>
		        数量
		      </template>
		      {{item.counts}}
		    </el-descriptions-item>
			<el-descriptions-item>
			  <template slot="label">
			    <i class="el-icon-money"></i>
			   总价
			  </template>
			  {{item.totalPrice}}
			</el-descriptions-item>
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-key"></i>
		       支付状态
		      </template>
		      {{item.isPayments}}
		    </el-descriptions-item>
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-user"></i>
		       下单顾客
		      </template>
		      {{item.customerName}}
		    </el-descriptions-item>
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-date"></i>
		       下单时间
		      </template>
		      {{item.creationDate}}
		    </el-descriptions-item>
			
			<el-descriptions-item>
			  <template slot="label">
			    <i class="el-icon-location-information"></i>
			   收货地址
			  </template>
			  {{item.address}}
			</el-descriptions-item>
			
			<el-descriptions-item>
			  <template slot="label">
			    <i class="el-icon-s-custom"></i>
			   收货人
			  </template>
			  {{item.consignee}}
			</el-descriptions-item>
			
		  </el-descriptions>
		  <el-button round class="backBtn" @click="backClick">返回</el-button>
	</el-card>
	</div>
</template>

<script>
	export default{
		name:"BackstageOrderDetail",
		activated() {
			this.item = this.$route.query.item
					
		},
		data(){
			return{
				item:{}
			}
		},
		methods:{
			backClick(){
				this.$router.go(-1)
			}
		}
	}
</script>

<style scoped="scoped">
	.title{
			  color: #B3C0D1;
			  text-align: center;
	}
	.backBtn{
		margin-top: 25px;
		 position: relative;
		 left: 80%;
		 width: 20%;
	}
</style>
