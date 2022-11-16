<template>
	<div>
		
 <form class="form" >
	 <div class="span">
	 	<span class="span1">支付信息</span>
	 	<span  class="span2">步骤二</span>
	 	
	 	</div>
 	<fieldset id="mey">
 		
 		<div class="align">
			<label>
			信用卡类型：
			<select style="width: 150px; height: 30px;" v-model="paymentForm.typeCard">
				<option value="0" v-show="false">请选择</option>
				<option value="1" >Card Type 1</option>
				<option value="2">Card Type 2</option>
				<option value="3">Card Type 3</option>
			</select>
		</label><br>
 		
			
 		<label>信用卡名称：<input type="text" v-model="paymentForm.cardName"  placeholder="请输入信用卡名称"/>
 		</label><br>
		
		<label>信用卡号码：<input type="text" v-model="paymentForm.cardId"  placeholder="请输入信用卡号码"/>
		</label><br>
 		
 		
 		<label>账单&nbsp;&nbsp;&nbsp;地址：<input type="text"  v-model="paymentForm.billAddress" placeholder="请输入账单地址"/>
 		</label><br>
		<label>截止&nbsp;&nbsp;&nbsp;日期：<input type="date" v-model="paymentForm.expiryDate">
    </el-date-picker>
		</label><br>
		</div>
		<br>
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
import {mapGetters} from 'vuex'
export default {
  name: "Payment",
	data(){
		return{
		addressForm:null,
		flag:false,
		
		paymentForm:{
			typeCard:"0",
			cardName:"",
			cardId:"",
			billAddress:"",
			expiryDate:""
			
		}
		}
	},
	computed:{
	   ...mapGetters(['product','productPrice'])
	   
		},
	created(){
		this.addressForm = this.$route.query.v.addressForm
		
	},
	methods:{
	  previousClick(){
		  this.$router.go(-1)
	  },
	  nextClick(){ 
		  this.$router.push({
			  path:"/order",
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
	height: 400px;
	margin:0 auto;
	line-height: 42px;
	text-align: center;
	border:2px solid #808080;
	 padding-top: 5%;  
	}
	.align{
		display: inline-block;
		text-align: left;
		
	}
	
	input{
		width: 250px;
		height: 25px;
	}
	label{
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
		margin-top: 5%;
		width: 30%;
	}
	
	.spanBtn{
		margin-right: 5%;
		margin-left: 5%;
	}
	.pay{
		color: #FF0000;
	}
</style>


