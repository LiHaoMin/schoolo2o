<template>
  <page class="mainHome">
    <div slot="content">

      <!-- 搜索商家，商家名称 -->
      <section v-bind:style="{height:isMobile?'6rem':'4rem'}" class="primary_bg float-header input_box primary_flex_center search primary_mg" style="z-index:10;top:0px">
        <!-- <section v-bind:style="{height:isMobile?'6rem':'4rem'}" class=" float-header input_box primary_flex_center search primary_mg" > -->
        <mt-header style="background-color: rgba(38, 162, 255,0)">
          <mt-button @click="back" slot="left" icon="back"></mt-button>
        </mt-header>
        <div @click="showSearch" class="ipt_item primary_flex_center fn-12">
          <img class="icon-10" src="static/img/icon/search.png" />&nbsp;&nbsp;搜索商家，商家名称
        </div>
      </section>


      <!-- 商家列表 -->
      <section class="shopList primary_bg_white">
        <div class="primary_mg">
          <span class="title ">{{ this.$route.query.catName}}</span>
        </div>
        <div>
          <!-- 单个商家展示组件 -->
          <shopItem v-for="(item,index) in shopList" :key="index" :item="item"></shopItem>
        </div>
      </section>
      <section class="footer_line fn-13">我是有底线了</section>
    </div>
  </page>
</template>
<script type="text/babel">
  import { getCatid } from '@/api/ApiRequest'
  export default {
    name: "MainCom",
    data() {
      return {
        menuList: [],
        topStatus: "",
        wrapperHeight: 0,
        translate: 0,
        moveTranslate: 0,
        tipList: ["烧烤", "馒头", "麻辣烫", "粥", "面包", "芒果", "拉面", "酸辣粉", "冒菜", "蛋糕"],
        shopList: []
      };
    },
    components: {
      //单个商品显示
      ShopItem: r => {
        require.ensure([], () => r(require("./components/ShopItem")), "ShopItem");
      },
      //商品广告
      ShopAds: r => {
        require.ensure([], () => r(require("./components/ShopAds")), "ShopAds");
      }
    },
    methods: {
      /**
       * 显示搜索框
       */
      showSearch() {
        this.$store.commit("POP_STATUS_S", true);
      },
      /**
       * 跳转商家列表
       */
      toShopDetail(item) {
        console.log("商家列表", item);
        this.$router.push({ name: "shopDetail",query:{shopId:item} });
      },
      /**
       * 显示地址
       */
      showLocation() {
        this.$store.commit("POP_STATUS_L", true);
      }
    },
    created() {
      getCatid(this.$route.query.catId).then(rsp => {
        this.shopList=rsp.data;
      });
    }
  };
</script>
<style lang='scss'>
  .mainHome {
    .ivu-affix {
      z-index: 2;
    }
    .mint-swipe-indicators {
      .mint-swipe-indicator {
        width: 10px;
        height: 2px;
        border-radius: 1px;
        opacity: 1;
        background: gray;
      }
      .is-active {
        background: black;
      }
    }
    font-weight: 200;
    .youhui {
      width: 100%; // background: url('static/img/common/youhui.png');
      // padding: 0px 10px;
      img {
        width: calc(100% - 20px);
        margin-left: 10px;
      }
    }
    .col_item {
      min-height: 80px;
      text-align: center;
      div {
        padding-top: 5px;
        display: flex;
        justify-content: center;
        img {
          width: 4.5rem;
          height: 4.5rem;
          display: block;
        }
      }
      span {
        text-align: center;
        color: rgb(102, 102, 102);
      }
    }
    .scrllX {
      justify-content: left !important;
      position: absolute;
      z-index: 1;
      height: 50px;
      a {
        text-align: left;
        font-family: -webkit-body;
        color: white;
        margin-right: 2rem;
      }
    }
    .search {
      position: sticky;
      top: 0px;
      ::after {
        content: "";
        position: absolute;
        width: 100%;
        height: 0px;
        left: 0;
        background-image: linear-gradient(
            90deg,
            rgb(0, 170, 255),
            rgb(0, 133, 255)
        );
      }
    }
    .input_box {
      height: 4.5rem;
      text-align: center;
      justify-content: center;
      color: gray;
      .ipt_item {
        color: black;
        text-align: center;
        background: rgb(255, 255, 255);
        width: 100%;
        min-height: 3rem;
        height: 3rem; // line-height: 39px;
        justify-content: center;
        border-radius: 2px;
      }
    }
    .heard_card {
      height: auto;
      color: rgb(255, 255, 255);
      justify-content: space-between;
      padding-bottom: 0px;
      position: relative;
      z-index: 200;
      .index_left {
        align-items: center;
        height: 4rem;
        display: flex;
        -webkit-box-align: center;
        width: 60%;
        padding-top: 10px;
        span {
          font-weight: 600;
          margin: 0 5px;
          max-width: 80%;
          white-space: nowrap;
          overflow: hidden;
          text-overflow: ellipsis;
        }
      }

      .index_right {
        // width: 40%;
        display: flex;
        align-items: center;
        text-align: right;
        padding-top: 10px;
        img {
          height: 28px;
          margin: 0px 5px 0px 5px;
        }
        div {
          h2,
          p {
            font-size: 1rem;
            margin: 0px;
            font-weight: 400;
          }
        }
      }
    }
  }
</style>
