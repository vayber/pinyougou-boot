<template>
	<div>
		<h1 class="title">品优购后台管理系统</h1>
		<h3 class="title">顾客详情界面</h3>
	<el-card style="width: 40%;margin: 0 auto; margin-top: 5%;">
		 <el-descriptions style="" title="顾客信息"  :column="1"  border >
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-info"></i>
		        顾客id
		      </template>
		      {{item.id}}
		    </el-descriptions-item>
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-user"></i>
		        顾客名
		      </template>
		      {{item.customerName}}
		    </el-descriptions-item>
			
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-postcard"></i>
		        e-Mail
		      </template>
		      {{item.email}}
		    </el-descriptions-item>
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-key"></i>
		       密码
		      </template>
		      {{item.emailPwd}}
		    </el-descriptions-item>
		    <el-descriptions-item>
		      <template slot="label">
		        <i class="el-icon-tickets"></i>
		        备注
		      </template>
		      <el-tag size="small">普通顾客</el-tag>
		    </el-descriptions-item>
		    
		  </el-descriptions>
		  <el-button round class="backBtn" @click="backClick">返回</el-button>
	</el-card>
	</div>
</template>

<script>
	export default{
		name:"BackstageCustomerDetail",
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
