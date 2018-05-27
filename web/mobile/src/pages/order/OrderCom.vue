<template>
  <page class="orderCom">
    <mt-header slot="header" class="primary_bg" title="订单" :fixed="true">
    </mt-header>

		<!-- 订单内容区域 -->
    <div slot="content" class="order_content has-header">
      <div style="margin-top:10px;background:white" v-for="(item,index) in list" :key="index">
        <OrderItem :value="item" />
      </div>
    </div>
  </page>
</template>
<script type="text/babel">
export default {
  name: "OrderCom",
  components: {
    OrderItem: r => { require.ensure([], () => r(require('./components/OrderItem'))), "OrderItem" }
  },
  data() {
    return {
      list: this.GLOBAL.orderList
    };
  },
  methods: {
    hide() {
    }
  }
};
</script>
<style lang='scss'>
@import 'src/assets/css/vars.scss';
.orderCom {
  .primary_bg {
    z-index: 20140202;
  }
}
</style>
