<template>
  <div class="contentadd">
    <img src="../../static/images/addact.png" class="addimg" @click="toAdd" />
  </div>
</template>


<script>
export default {
  methods: {
    toAdd: function () {
      wx.navigateTo({
        /** 路径不应该停留在components，而是在使用了该组件的相对路径下去写 */
        /** 尚未解决：增加一个接口，让外界可以传url进来 */
        url: '../addactivity/main',
        success: (result) => {
        },
        fail: () => { console.log('fail') }
      })
    }
  }
}
</script>

<style scoped>
.contentadd {
  border-radius: 30rpx;
  margin-left: 36rpx;
  margin-top: 40rpx;
  height: 400rpx;
  width: 320rpx;
}
.addimg {
  height: 400rpx;
  width: 320rpx;
}
</style>