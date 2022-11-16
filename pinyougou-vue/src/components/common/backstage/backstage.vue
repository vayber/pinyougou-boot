<template>
	<div>
		<RegisterHeader/>
		<keep-alive exclude="Order">
		  <router-view/>
		</keep-alive>
	</div>
</template>

<script>
	import RegisterHeader from "../register/registerHeader.vue"
	
	export default{
		name:"Backstage",
		components:{
			RegisterHeader
		}
	}
</script>

<style>
</style>
