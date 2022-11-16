<template>
  <div class="footer">
    <div class="foot1">
      <span v-for="(item,index) in merger(foot1)" :key="index">
        {{item}}
      </span>
    </div>
    <div style="margin-bottom:5px">{{foot2}}</div>
    <div style="margin-bottom:5px">{{foot3}}</div>
  </div>
</template>

<script>
export default {
  name: 'Footer',
  data () {
    return {
      foot1: ["关于我们","联系我们","联系客服","商家入驻","营销中心","手机品优购","友情链接","销售联盟","品优购社区","English Site Contact U"],
      foot2: "地址：北京市昌平区建材城西路金燕龙办公楼一层 邮编：100096 电话：400-618-40000 传真：010-82935100 邮箱：zhanghj+itcast.cn",
      foot3: "京ICP备08001421号京公网安备110108007702"
    }
  },
  methods: {
    merger(arr){
      return arr.join(" | ").split(" ")
    }
  }
}
</script>

<style scoped>
.footer{
  margin-top: 30px;
  height: 120px;
  color: #666;
}
.foot1{
  margin: 10px 0;
}
.footer div{
  font-size: 13px;
   color: #666;
  text-align: center;
}
.footer div span{
  margin: 0 2px;
}
</style>
