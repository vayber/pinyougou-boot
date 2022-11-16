<template>
	<div class="proItem">
	  <div class="proImg">
	    <img :src="item.img" alt="" @click="detailClick">
	  </div>
	  <div class="detail">
	    <div class="proName" @click="detailClick">名称：{{item.name}}</div>
	    <div style="font-size: 14px">型号：{{item.type}}</div>
	    <div style="font-size: 14px; margin-bottom: 14px">价格：￥{{item.price}}</div>
	    <el-button type="danger" round @click="buyClick" >购买</el-button>
	    <el-button type="danger" round  @click="addCart">加入购物车</el-button>
	  </div>
	</div>
</template>

<script>
	import {mapGetters} from 'vuex'
	export default{
		name:"ProductItem",
		
		props:{
			item:""
		},
		computed:{
			 ...mapGetters(['customer']),
		},
		methods:{
			detailClick(){
				this.$router.push({
					name:"Detail",
					params:this.item
				})
			},
			buyClick(){
				if(Object.keys(this.customer).length === 0){
				    this.$toast.show("请先登录")
				}else{
				this.$store.commit("addProduct",this.item)			
				this.$router.push("/address")
			  }
			},
			addCart(){
				if(Object.keys(this.customer).length === 0){
				    this.$toast.show("请先登录")
				}else{
					const product = {}
					product.price = this.item.price
					product.subtotal = this.item.subtotal
					product.id = this.item.id
					product.name = this.item.name
					product.checked = true
					this.$store.dispatch('addCart',product).then(res => {
						 this.$toast.show(res,1500)
					})
				}
			}
		}
	}
</script>

<style scoped="scoped">
	
	.proItem{
	  width: 520px;
	  float: left;
	  margin-bottom: 20px;
	  margin-left: 30px;
	}
	.proItem{
	  display: flex;
	}
	.proImg{
	  width: 100px;
	}
	.proImg img{
	  width: 100%;
	  height: 130px;
	  border: 1px solid #666666 ;
	  cursor: pointer;
	}
	.detail{
	  margin-left: 5px;
	  font-weight: bold;
	}
	.detail div{
	  margin-bottom: 9px;
	}
	.proName{
	  cursor: pointer;
	}
	.proName:hover{
	  color: #FF0000
	}
</style>
