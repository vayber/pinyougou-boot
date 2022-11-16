<template>
	<div>
		<LoginHeader></LoginHeader>
		<Main></Main>
		<Footer></Footer>
	</div>
</template>

<script>
	import LoginHeader from "./loginHeader.vue"
	import Main from "./main.vue"
	import Footer from "../footer.vue"
	export default{
		name:"Login",
		components:{
			LoginHeader,
			Main,
			Footer
		}
	}
</script>

<style>
</style>
