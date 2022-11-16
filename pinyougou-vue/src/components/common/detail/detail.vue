<template>
	<div>
		
		<el-card class="detailCard">
		<div class="detailMain">
		  <div class="pic">
		    <img :src="item.img" alt="">
		  </div>
		  <div class="right">
		    <div class="name">名称：{{item.name}}</div>
		    <div style="margin-bottom: 20px" class="cccColor">型号：{{item.type}}</div>
		    <div class="cccColor">描述：{{item.description}}</div>
		    <el-button type="primary" class="button btn1" @click="buyClick">￥{{item.price}}</el-button>
		    <el-button type="warning" class="button btn2" @click="addCart">加入购物车</el-button>
		  </div>
		</div>
		
		<el-button round class="backBtn" @click="backClick">返回</el-button>
		</el-card>
		
	</div>
</template>

<script>
	import {mapGetters} from 'vuex'
	export default{
		name:"Detail",
		
		created() {			
			this.item = this.$route.params	
			
		},
		data(){
		  return{
		    id:'',
			item:[]	
			}
		},
		computed:{
			 ...mapGetters(['customer']),
		},	
		methods:{
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
				
				
			},
			backClick(){
				this.$router.go(-1)
			}
		}
	}
</script>

<style scoped="scoped">
	.detailCard{
	  width: 87%;
	  height: 400px;
	  background-color: white;
	  padding: 70px 100px 0 100px;
	}
	.detailMain{
	  display: flex;
	}
	.pic{
	  height: 300px;
	  width: 300px;
	  border: 2px solid rgb(223, 223, 223);
	  position: relative;
	  margin-right: 50px;
	}
	img{
	  height: 100px;
	  width: 100px;
	  position: absolute;
	  left: 50%;
	  top: 50%;
	  transform:  translate(-50%, -50%);
	   border: 2px solid rgb(223, 223, 223);
	}
	.right{
	  margin-top: 10px;
	  width: 800px;
	  position: relative;
	}
	.name {
	  font-size: 28px;
	  font-weight: 500;
	  margin-bottom: 22px;
	}
	
	.button{
	  height: 60px;
	  width: 160px;
	  font-size: 18px;
	}
	.btn1{
	  position: absolute;
	  bottom: 0px;
	}
	.btn2{
	  position: absolute;
	  left: 160px;
	  bottom: 0px;
	}
	.backBtn{
		 position: absolute;
		 right: 8%;
		 width: 10%;
	}
</style>
