<template>
  <div class="shop_detail_header">
    <div>
      <div v-bind:style="{background: 'linear-gradient(to bottom, #8d2812 0%, #8d2812 '+(75 - top*.2)+'%, #fff '+(73 - top*.2)+'%, #fff 100%)'}" class="shopDetail_header platfrom-header">
        <div class="back">
        </div>
        <div v-bind:style="{'opacity': (60 - Math.abs(top))/60}">
          <h2 class="title" v-bind:class="[isMobile?'mobileTitle':'']" v-bind:style="{'top':Math.abs(top)>105?'10px':40 + top*.30 + 'px','margin-left': Math.abs(top)>40?'-18px': - Math.abs(top*.3)+'px'}">{{shop.shopName}}</h2>
          <div class="heard_content">
            <img v-bind:style="{ transform: this.top < 50 ? 'scale(' + (280 + this.top) / 270 + ')' : 'scale(1)'}" :src="shop.shopImage" alt="">
            <div class="detail">
              <span>
                {{shop.shopDescription}}
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script type="text/babel">
export default {
  name: "shop_detail_header",
  components: {
  },
  data() {
    return {
    };
  },
  props: {
    top: {
      type: Number
    },
    shop:{
        type:Object
    }
  },
  methods: {
  },
  watch: {
  }
};
</script>
<style lang="scss" scoped>
@import 'src/assets/css/vars';
$height:80px;
.shop_detail_header {

  .title {
    position: absolute;
    top: 46px;
    padding: 3px;
    left: 100px;
    font-size: 14px;
    z-index: 11;
    color: rgb(255, 255, 255);
  }

  .shopDetail_header {
    color: $bg-color;
    padding: 0px $pd-md 5px $pd-md;
    width: 100%;
    min-height: 150px;
    .back {
      min-height: 40px;
    }
    .heard_content {
      display: flex;
      align-items: center;
      justify-content: space-between;
      img {
        width: $height;
        height: $height;
        box-shadow: 0px 0px 5px rgba(1, 1, 1, .3);
        margin-bottom: -10px;
      }
      .detail {
        padding-top: 10px;
        width: calc(100% - 90px);
        span {
          width: 100%;
          display: inline-block;
          text-overflow: ellipsis;
          overflow: hidden;
          white-space: nowrap;
          text-overflow: ellipsis;
          font-size: $fn-tn;
          border-radius: .2rem;
          padding: 3px;
        }
        .pinpai {
          left: 0px;
          background: linear-gradient(-139deg, rgb(255, 241, 0), rgb(255, 227, 57));
          margin-right: .22rem;
          font-size: $fn-tn;
          padding: 3px;
          border-radius: .2rem;
          width: .3rem;
          color: rgb(111, 63, 21);
        }
      }
    }
    .youhui {
      // padding-top: 2px;
      margin-top: 20px;
      font-size: $fn-sm;
      font-weight: 200;
      color: $description-color;
      display: flex;
      justify-content: space-between;
      align-items: center;
      .man {
        &::before {
          content: "满";
          background: #E33D0A;
          padding: 1px;
          border-radius: .2rem;
          color: $white-color;
          width: 20px;
          box-sizing: border-box;
          margin-right: $pd-md/2;
        }
      }
      .huodong {
        display: flex;
        align-items: center;
        img {
          margin-left: 3px;
          width: 8px;
        }
      }
    }
  }
}
</style>

