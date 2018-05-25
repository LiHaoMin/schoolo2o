<template>
  <div class="shopAds">
    <div class="primary_mg_hor primary_bg_white" style="height:90px">
       <mt-swipe :auto="2000" height="100%">
        <mt-swipe-item v-for="(item,index) in imgList" :key="index">
          <img :src="item.imageUrl" style="width: 100%" />
        </mt-swipe-item>
      </mt-swipe>
    </div>
  </div>
</template>
<script type="text/babel">
  import { getHeadLines } from '@/api/ApiRequest'
export default {
  name:"ShopAds",
  data() {
    return {
      imgList:[]
    };
  },
  components: {
  },
  methods: {
  },
  created() {
    getHeadLines().then(rsp => {
        for(var i = 0;i < (rsp.data.length > 5 ? 5 : rsp.data.length);i++){
            if(rsp.data[i].status == 1){
              this.imgList.push(rsp.data[i])
            }
        }

  });
  }
};
</script>
<style lang='scss'>
.shopAds {
  .row {
    background: white;
    .col_1 {
      text-align: center;
      min-height: 10rem;
      background: linear-gradient(0deg, rgb(244, 244, 244) 5%, rgb(250, 250, 250) 95%);
      margin: 1rem; // min-height: 11rem;
      margin: 1rem;
      padding: 2px 1.3rem;
      text-align: left;
      position: relative;
      &:first-of-type {
        margin-right: 0px;
      }
      &:last-of-type {
        // margin-right: 0px;
      }
      h2 {
        color: rgb(232, 25, 25);
      }
      h2,
      h3 {
        margin-top: .2rem;
      }
      img {
        margin-bottom: -1.5rem;
        bottom: 0px;
        position: absolute;
        right: 0px;
        width: 10rem;
      }
    }
    .col_2 {
      overflow: hidden;
      height: auto;
      min-height: 9rem;
      text-align: center;
      &:last-of-type {
        margin-left: 0px;
        font-size: 10px;
        border-radius: 3px;
      }
      h3 {
        margin-bottom: .5rem;
      }
      .box {
        border: 1px solid rgb(187, 187, 187);
        font-size: 1rem;
        color: gray;
        text-align: center;
        padding: 0px;
        margin-top: .5rem;
      }
      img {
        width: 90%;
        margin-bottom: 0px;
        left: 5%;
      }
    }
  }
}
</style>
