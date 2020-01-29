<template>
    <div class="container">
        <div><image class="container-image" src="../../static/images/success.png"></image></div>
        <div class="contain-item"><text>提交成功</text></div>
        <div class="contain-item"><text class="contianer-text"></text></div>

        <div class="contain-btn">
            <!-- <navigator url="../../pages/doing/doing" open-type="switchTab" > -->
            <!-- <button class="btn2" @click="returnStart">返回首页</button> -->
          <van-button
            type="default"
            round
            size="large"
            plain
            @click="returnStart"
            custom-style="color:#AEAEAE;border:1px solid #AEAEAE"
          >返回首页</van-button>
          <van-toast id="van-toast" />
            <!-- </navigator> -->
        </div>
    </div>
</template>


<script>
// import Toast from '../../../dist/wx/static/vant/toast/toast'
export default {
    methods: {
        // wx.switchTab 跳转到 tabBar 页面，并关闭其他所有非 tabBar 页面
        returnStart: function () {
            // console.log('come in return Start')
            wx.switchTab({
              url: '../doing/main',
              success: (result) => {

            },
            fail: () => { },
            complete: () => { }
            })
        }
    }
}
</script>

<style scoped>
/* 按钮整体样式 */
.contain-btn{
width: 90%;
margin-top: 40rpx;
}


.container{
  display: flex;
  flex-direction: column;
  width: 100%;
  align-items: center;
  justify-content: center;
  position: fixed;
}

.contain-item{
    font-size: 40rpx;
  display: flex;
  flex-direction: row;
  width: 100%;
  align-items: center;
  justify-content: center;
  margin-top: 40rpx;
}

.container-image{
  margin-top: 60rpx;
  width: 128rpx;
  height: 128rpx;
}

.btn2 {
  width: 600rpx;
  margin-top: 30rpx;
  color: #AEAEAE;
  border-radius: 100rpx; 
}

.contianer-text{
  font-size: 28rpx;
  color: #AEAEAE;
}
</style>

