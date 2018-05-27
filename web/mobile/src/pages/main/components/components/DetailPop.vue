<template>
  <div class="detailPop">
    <mt-popup v-model="$parent.$parent.detailPop" position="bottom"  class="mint-popup" :modal="true">
      <mt-swipe :auto="2000" style="height: 80%">
        <mt-swipe-item v-for="(item,index) in $parent.$parent.detail.productImages" :key="index">
          <img :src="item.imageUrl" class="detail-image" />
        </mt-swipe-item>
      </mt-swipe>
      <div class="content">
        <h2>{{$parent.$parent.detail.productName}}</h2>
        <span>{{$parent.$parent.detail.productdescription}}</span>
        <div class="opt">
          <span class="price" >¥ {{$parent.$parent.detail.normalprice}}</span>
          <div class="add_content">
            <mt-button @click.stop="$parent.$parent.addToCar($event,$parent.$parent.detail,'add')" class="add_button" type="primary">+</mt-button>
          </div>
        </div>
      </div>
    </mt-popup>
  </div>
</template>
<script >
export default {
  name: "detailPop",
  data() {
    return {

    };
  },
  components: {
  },
  methods: {
    /**
     *
     */
    close() {
      this.$store.commit('POP_STATUS_L', false)
    }
  },
  props: {
    top: {
      type: Number,
      default: 0
    }
  },
  watch: {
  },
  mounted() {
  }
};
</script>
<style lang='scss' scoped>
@import 'src/assets/css/vars';
.detailPop {
  .mint-popup {
    height: 67%;
    width: 86%;
    top: 15%;
    border-radius: 3px;
    .detail-image {
      width: 100%;
    }
    .content {
      padding: $pd-lg;
      .opt {
        display: flex; //
        justify-content: space-between;
        align-items: center;
        margin-top: 20px;
        padding-right: 8px;
        .price {
          color: $warning-color;
          font-size: $fn-md;
        }
      }
    }
  }
}
</style>
