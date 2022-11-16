import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
import router from "./router/index.js"
import toast from "./components/common/toast/index.js"
import store from "./store/index.js"

Vue.use(ElementUI);
//注册全局使用$toast
Vue.use(toast)
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')
