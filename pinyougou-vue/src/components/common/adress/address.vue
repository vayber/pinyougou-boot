<template>
	<div>
		
 <form class="form" >
	 <div class="span">
	 	<span class="span1">送货地址</span>
	 	<span  class="span2">步骤一</span>
	 	
	 	</div>
 	<fieldset id="mey">
 		<div class="align">
 		
		<label class="label">收货人：<input type="text" v-model="addressForm.consignee"  placeholder="请输入收货姓名"/>
		</label><br>
 		
 		<label  class="label">地址：<input type="text" v-model="addressForm.address"  placeholder="请输入收货地址"/>
 		</label><br>
 		
 		<label  class="label">电话号码：<input type="text" v-model="addressForm.phone"  placeholder="请输入电话号码"/>
 		</label><br>
		
		</div>
		<br>
		<el-button type="danger" size="medium" class="button" @click="previousClick">
			<span class="spanBtn"><<</span>Previous
			</el-button>
		<el-button type="danger" size="medium" class="button" @click="nextClick">
			Next<span class="spanBtn">>></span>
			</el-button>
 	</fieldset>
	</form>
	</div>
</template>

<script>

export default {
  name: "Address",
  data(){
	return{
	addressForm:{
	consignee:"",
	address:"",
	phone:""
	}	
	}  
  },
  methods:{
	  previousClick(){
		this.$store.commit("addProduct",{})
		this.$router.go(-1)
	  },
	  nextClick(){
		  this.$router.push({
			  path:"/payment",
			  query:{
				  v: this
			  }			
		  })
	  }
  }
 
}
</script>

<style scoped>
	
	.form{
		margin-top: 3%;
	}
	#mey{
	width: 700px;
	height: 450px;
	margin:0 auto;
	line-height: 42px;
	text-align: center;
	border:2px solid #808080;
	   
	}
	.align{
		display: inline-block;
		text-align: right;
		margin-top: 8%;
	}
	
	input{
		width: 250px;
		height: 25px;
	}
	.label{
		font-size: 21px;
		
	}
	.span{
		background-color: #cccccc;
		width: 730px;
		height: 40px;
		line-height: 40px;
		margin:0 auto;
		color: #666666;
	}
	.span2{
		margin-left: 84%;
		color: #FF0000;
	}
	
	.button{
		margin-top: 10%;
		width: 30%;
	}
	
	.spanBtn{
		margin-right: 5%;
		margin-left: 5%;
	}
</style>

