//配置路由相关的信息
import VueRouter from 'vue-router'
import Vue from 'vue'


const Login = () => import("../components/common/login/login.vue")

const Main = () => import("../components/common/login/main.vue")
const EMail = () => import("../components/common/login/childCpn/email.vue")
const Manage = () => import("../components/common/login/childCpn/manage.vue")

const Home = () => import("../components/home.vue")

const Content = () => import("../components/common/content.vue")
const Detail = () => import("../components/common/detail/detail.vue")
const Cart = () => import("../components/common/cart/cart.vue")
const Me = () => import("../components/common/me/me.vue")

const Backstage = () => import("../components/common/backstage/backstage.vue")

const Register = () => import("../components/common/register/register.vue")
const Address = () => import("../components/common/adress/address.vue")
const Payment = () => import("../components/common/payment/payment.vue")
const Order = () => import("../components/common/order/order.vue")

const Service = () => import("../components/common/service/service.vue")


const BackstageManger = () => import("../components/backstageManger/backstageManger.vue")
const OrderBackstageManger = () => import("../components/backstageManger/orderBackstageManger.vue")
const CustomerBackstageManger = () => import("../components/backstageManger/customerBackstageManger.vue")
const ProductBackstageManger = () => import("../components/backstageManger/productBackstageManger.vue")

const BackstageProductDetail = () => import("../components/backstageManger/detail/backstageProductDetail.vue")
const BackstageCustomerDetail = () => import("../components/backstageManger/detail/backstageCustomerDetail.vue")
const BackstageOrderDetail = () => import("../components/backstageManger/detail/backstageOrderDetail.vue")

const AlterCustomer = () => import("../components/backstageManger/alter/alterCustomer.vue")
const AlterOrder = () => import("../components/backstageManger/alter/alterOrder.vue")
const AlterProduct = () => import("../components/backstageManger/alter/alterProduct.vue")

const AddProduct = () => import("../components/backstageManger/add/addProduct.vue")

const ModifyPwd = () => import("../components/backstageManger/modifyPwd/modifyPwd.vue")

//1.通过Vue.use(插件),安装插件
Vue.use(VueRouter)

//解决重复点击路由跳转报错
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}



//2.创建VueRouter对象
//映射
const routes = [
  {
    path:'',
    //重定向
    redirect:'/home'
  },
  {
    path:'/home',
    component:Home,
	children:[
		{
		  path:'',
		  //重定向
		  redirect:'/content'
		},
		{
		path:'/content',
		component:Content
	    },
		{
		path:'/detail',
		name:"Detail",
		component:Detail	
		},
		{
		path:'/cart',
		component:Cart
		},
		{
		 path:'/me',
		 component:Me
		}
		]},
		
  {
    path:'/login',
    component:Login,
	children:[
	{
	  path:'',
	  //重定向
	  redirect:'/main'
	},
	{
	path:'/main',
	component:Main,
	children:[{
		path:'',
		redirect:'/email'
	},
	{
		path:'/email',
		component:EMail
	},
	{
		path:"/manage",
		component:Manage
	}
		]
	}	
	]
  },
  {
	  path:"/service",
	  component:Service
  },
  {
	  path:"/backstage",
	  component:Backstage,
	  children:[{
		 
		   path:'/register',
		   component:Register
		 },
		 {
		   path:'/address',
		   name:"Address",
		   component:Address
		 },
		 {
		   path:'/payment',
		   name:"Payment",
		   component:Payment
		 },
		 {
		   path:'/order',
		   name:"Order",
		   component:Order
		 }
	  ]
  },
  //后台管理
  {
	  path:"/backstageManger",   
	  component:BackstageManger,
	  children:[{
	  	path:'',
	  	redirect:'/orderBackstageManger'
	  },
	  {
	  	path:'/orderBackstageManger',
	  	component:OrderBackstageManger
	  },
	  {
	  	path:"/customerBackstageManger",
	  	component:CustomerBackstageManger
	  },
	  {
	  	path:"/productBackstageManger",
	  	component:ProductBackstageManger
	  },
	  	]
  },
  {
	  path:"/backstageProductDetail",
	  component:BackstageProductDetail
  },
  {
  	  path:"/backstageCustomerDetail",
  	  component:BackstageCustomerDetail
  },
  {
  	  path:"/backstageOrderDetail",
  	  component:BackstageOrderDetail
  },
  {
  	  path:"/alterCustomer",
  	  component:AlterCustomer
  },
  {
  	  path:"/alterOrder",
  	  component:AlterOrder
  },
  {
  	  path:"/alterProduct",
  	  component:AlterProduct
  },
  {
  	  path:"/addProduct",
  	  component:AddProduct
  },
  {
	  path:"/modifyPwd",
	  component:ModifyPwd
  }
]


//router 是一个机制，相当于一个管理者，它来管理路由。
// 因为routes 只是定义了一组路由，它放在哪里是静止的，
// 当真正来了请求，怎么办？ 就是当用户点击home 按钮的时候，
// 怎么办？这时router 就起作用了，它到routes 中去查找，
// 去找到对应的 home 内容，所以页面中就显示了 home 内容。


const router = new VueRouter({
   routes,
   mode:'hash',
   linkActiveClass:'active'
})


//3.将router对象传入到Vue实例中
export default router
