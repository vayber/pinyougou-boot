<template>
	<div>
	<Header/>
	<keep-alive exclude="Detail,Me,Cart">
	  <router-view/>
	</keep-alive>
	<Footer/>
	</div>
</template>

<script>
import Footer from "./common/footer.vue"
import Header from "./common/header.vue"
import Content from "./common/content.vue"
	
export default {
  name: 'Home',
  components: {
   Footer,
   Header,
   Content
  }
	}
</script>

<style>
</style>
