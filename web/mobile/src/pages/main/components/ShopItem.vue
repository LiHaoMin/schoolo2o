<template>
  <div @click="$parent.$parent.toShopDetail(item.id)" class="shopItem primary_mg">
    <div class="left">
      <lazy-image :src="item.shopImage" :img-class="['classname1','classname2']" :placeholder="loaddingImg" />
    </div>
    <div class="right">
      <div class="shop_detail">
        <div class="index_1 primary_flex_center">
          <h2 class="isp" style="width: 100%">
            <span class="fn-13" style="font-weight:700;color:black">{{item.shopName}}</span>
          </h2>
        </div>
        <div class="index_1 primary_flex_center">
          <h2 style="width: 100vh">
            <span>{{ item.shopDescription}}</span>
          </h2>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ShopItem",
  components: {
    Star: r => {
      require.ensure(
        [],
        () => r(require("../../../components/common/star/Star.vue")),
        "Star"
      );
    }
  },
  data() {
    return {
      down: true
    };
  },
  props:['item'],
  methods: {
    /**
     * 跳转到商家详情
     */
    toShop() {
      console.log("去商家详情"+item.id);
      this.$parent.toShopList(item.id);
    }
  }
};
</script>
<style lang="scss">
$height_size: 6.5rem;
.shopItem {
  overflow: hidden;
  padding-bottom: 0px;
  padding-top: 10px;
  position: relative;
  border-bottom: 1px solid rgb(238, 238, 238);
  background-color: rgb(255, 255, 255);
  color: rgb(102, 102, 102);
  list-style: none;
  display: flex;
  justify-content: space-between;
  .left {
    // width: 30%;
    img {
      width: 89%;
      // height: $height_size;
    }
  }
  .right {
    width: 78%;
    .shop_detail {
      height: $height_size+0.5rem;
      border-bottom: 1px dashed rgb(168, 168, 168);
      .has_before::before {
        content: "|";
        color: gray;
        margin: 0 5px;
      }
      .index_1 {
        margin-bottom: 5px;
        justify-content: space-between;
        h2 {
          width: 65%;
          overflow: hidden;
          text-overflow: ellipsis;
          white-space: nowrap;
          font-size: 1.1rem;
          font-weight: 200;
          &::last-of-type {
            margin-bottom: 5px;
          }
        }
        .isp::before {
          content: "品牌";
          background: linear-gradient(
            -139deg,
            rgb(255, 241, 0),
            rgb(255, 227, 57)
          );
          margin-right: 0.22rem;
          font-size: 1rem;
          padding: 0.3rem;
          border-radius: 0.5rem;
          width: 0.3rem;
          color: rgb(111, 63, 21);
        }
        .index_right {
          span {
            padding: 0.1rem;
            border-radius: 0.1rem;
            color: rgb(153, 153, 153);
            border: 1px solid rgb(221, 221, 221);
          }
          .c_span {
            border: none;
            padding: 0rem;
          }
          .showac {
            .icon_img {
              margin-left: 3px;
              transition: all linear 0.5s;
            }
            .fz {
              transform: rotateZ(180deg);
            }
          }
        }
      }
    }
  }
}
</style>

