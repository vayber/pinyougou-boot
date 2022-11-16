<template>
	<div >
		<el-card class="box-card">
			
			<div class="content">
			
			 <div id="leftMenu">
				<h2>商品分类</h2>
				 <div class="item" 
				 v-for="item,index in List"
				  :key="index"
				  @click="click(index)" 
				  :class="{active:i == index}"
				  >{{item}}</div>
			 </div>
			 
			 <Product :goods="currentType" />
			 
			 </div>
			 </el-card>
	</div>
</template>

<script>
	import {getProTypeList} from "../../network/proType/proType.js"
	import {getProductListNoPage} from "../../network/product/product.js"
	
	import Product from "./product/product.vue"
	
	export default{
		name:"Context",
		created() {
	
			
			getProTypeList().then(res => {				 
				for(let i in res){
					let arr = res[i].name		
					this.List.push(arr)
				}
			})
			getProductListNoPage().then(res => {
				let arr = []
				for(let j in res){
					let i = res[j]
					 arr = {
						 id:i.id,
						 name:i.name,
						 type:i.model,
						 price:i.price,
						 description:i.description,
						 img:"http://vayber.top/"+i.img,
						 count:1,
						 subtotal:i.price
					 }
				 switch (i.proTypeId){
					case 1:
					this.shorts.push(arr)
					this.currentType.push(arr)
					break;
					case 2:
					this.ethnicJewelry.push(arr)
					break;
					case 3:
					this.exquisiteJewelry.push(arr)
					break;
					case 4:
					this.collectionWorld.push(arr)
					break;
					case 5:
					this.perfumeFragrance.push(arr)
					break;
					case 6:
					this.fashionAccessories.push(arr)
					break;
					case 7:
					this.fashionJewelry.push(arr)
					break;
				 }
					
				}
				
			})
		},
		data(){
			return{
			List:[],
			//保存当前下标
			i:0,
			currentType:[],
			 shorts:[],					//奇石
			 ethnicJewelry:[],  		//民族饰品
			 exquisiteJewelry:[],		//精致珠宝
			 collectionWorld:[],		//收藏天地
			 perfumeFragrance:[],		//香水香氛
			fashionAccessories:[],		//时尚配饰
			 fashionJewelry:[]			//时尚珠宝
			  
		
		}
		},
		components:{
			Product
		},
	methods:{
		click(index){
				this.i = index
				switch (index){
					case 0:
					this.currentType = this.shorts
					break;
					case 1:
					this.currentType = this.ethnicJewelry
					break;
					case 2:
					this.currentType = this.exquisiteJewelry
					break;
					case 3:
					this.currentType = this.collectionWorld
					break;
					case 4:
					this.currentType = this.perfumeFragrance
					break;
					case 5:
					this.currentType = this.fashionAccessories
					break;
					case 6:
					this.currentType = this.fashionJewelry
					break;
				}
		}
	}
	}
</script>

<style scoped="scoped">
	.box-card{
	  margin-top: 20px;
	  width: 100%;
	  position: relative;
	  min-height: 480px; 
	}
	#leftMenu{
	  text-align: center;
	  width: 100px;
	  margin: 0 45px;
	}
	.item{
	  width: 100px;
	  float: left;
	  margin-bottom: 28px;
	  color: #666 ;
	  cursor: pointer;
	}
	.item:hover{
		color: #FF0000;
	}
	.active{
		color: #FF0000;
	}
	.content{
	  margin: 0 auto;
	  width: 1350px;
	  display: flex;
	}
</style>
