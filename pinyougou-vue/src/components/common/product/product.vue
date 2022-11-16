<template>
	<div class="product">
		<div  v-for="item,index in goods" :key="index"  class="proItem">
		  <ProductItem  :item="goods[index]"/>
		</div>
	</div>
</template>

<script>
	import ProductItem from "./productItem.vue"
	
	export default{
		name:"Product",
		created() {
			
		},
		props:{
		  goods:[]
		},
		components:{
			ProductItem
		}
	}
</script>

<style scoped="scoped">
	.product{
	  margin-top: 25px;
	  margin-left: 50px;
	  
	  flex: 1;
	}
	
</style>
