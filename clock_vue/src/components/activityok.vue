<template>
  <view class="contentdetail">
    <view class="actimg">
      <view>
        <image class="actImg" :src="imgSrc" />
      </view>
    </view>
    <view class="acttext">
      <view class="acttitle">
        <image class="acticon" src="../../static/images/yes.png" />
        {{actname}}
      </view>
    </view>
  </view>
</template>

<script>
export default {
  props: {
    actname: '',
    type: ''
  },
  data () {
    return {
      actname: this.actname,
      type: this.type,
      imgSrc: ''
    }
  },
  onShow () {
    this.showImg()
  },
  onLoad () {
    this.showImg()
  },
  methods: {
    showImg: function () {
      if (this.type === '学习') {
        this.imgSrc = '../../static/images/books.jpg'
      } else if (this.type === '运动') {
        this.imgSrc = '../../static/images/run.jpg'
      } else if (this.type === '音乐') {
        this.imgSrc = '../../static/images/musictext.jpg'
      } else if (this.type === '水果') {
        this.imgSrc = '../../static/images/fruit.jpg'
      } else if (this.type === '娱乐') {
        this.imgSrc = '../../static/images/play.jpg'
      }
    }
  }
}
</script>

<style scoped>
/* components/activity/index.wxss */

/*打卡选项卡*/

.contentdetail {
  border-radius: 30rpx;
  margin-left: 36rpx;
  margin-top: 40rpx;
  height: 360rpx;
  width: 320rpx;
  background-color: white;
}

/*添加打卡活动选项卡*/

.contentadd {
  border-radius: 30rpx;
  margin-left: 36rpx;
  margin-top: 40rpx;
  height: 400rpx;
  width: 320rpx;
}

/*添加打卡图片*/

.addimg {
  height: 400rpx;
  width: 320rpx;
}

/*活动图片*/

.actimg {
  width: 320rpx;
  height: 260rpx;
  border-radius: 30rpx 30rpx 0 0;
  background-color: #f2f2f2;
}

/*活动文字*/

.acttext {
  height: 100rpx;
  justify-content: center;
  display: flex;
  flex-direction: column;
}

/*活动标题提示文字*/

.acttitle {
  color: #333;
  margin-left: 36rpx;
  flex-direction: row;
  font-size: 36rpx;
  width: 284rpx;
  display: flex;
}

/*活动图标*/

.acticon {
  margin-right: 20rpx;
  height: 48rpx;
  width: 48rpx;
  opacity: 0.6;
}

/**************活动图片天数记录*************/

/*已经完成天数，数字离顶部200rpx*/

.alday {
  z-index: 999;
  position: relative;
  top: 170rpx;
  margin-left: 36rpx;
  color: #38ceb1;
  font-size: 40rpx;
  font-family: SimHei;
  font-weight: bold;
}

/*斜杠*/

.italic {
  margin-left: 10rpx;
  z-index: 999;
  position: relative;
  top: 170rpx;
  color: #999;
  opacity: 0.6;
  font-size: 50rpx;
  font-family: SimHei;
  font-weight: bold;
}

/*总的目标天数*/

.countday {
  margin-left: 10rpx;
  z-index: 999;
  position: relative;
  top: 170rpx;
  color: #38ceb1;
  font-size: 50rpx;
  font-family: SimHei;
  font-weight: bold;
}

/**   */
.actImg {
  height: 260rpx;
  width: 320rpx;
  /* z-index: -1; */
  border-radius: 30rpx 30rpx 0 0;
}
</style>