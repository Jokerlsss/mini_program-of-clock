<template>
  <view class="contentdetail" @click="toDetail">
    <view class="actimg">
      <view>
        <image class="actShowImg" :src="imgSrc"></image>
      </view>
      <!-- <view>
        <text class="alday">{{finishday}}</text>
        <text class="italic">/</text>
        <text class="countday">{{actday}}</text>
      </view> -->
    </view>
    <view class="acttext">
      <!-- 如果用三元表达式作为istoday的默认值呢--解决！ -->
      <!-- 未打卡和已打卡的样式、文本显示 -->
      <view class="ynclock" :style="istoday?colorgray:colorred">{{istoday?'已打卡':'未打卡'}}</view>
      <view class="acttitle">
        <image class="acticon" :src="istoday?iconSrc_finish:iconSrc_GoOn"></image>
        {{actname}}
      </view>
    </view>
  </view>
</template>

<script>
import globalStore from '../stores/global-store'
export default {
  props: {
    actday: '',
    actname: '',
    actid: '',
    finishday: '',
    istoday: '',
    type: ''
  },
  data () {
    return {
      actday: this.actday,
      actname: this.actname,
      actid: this.actid,
      finishday: this.finishday,
      istoday: this.istoday,
      type: this.type,
      istodayShow: '',
      color: '',
      colorgray: 'color:#999999',
      colorred: 'color:#FF6633',
      imgSrc: '',
      iconSrc_GoOn: '../../static/images/goon.png',
      iconSrc_finish: '../../static/images/success.png'
    }
  },
  onShow () {
    // this.isToday()
    this.showImg()
  },
  onLoad () {
    this.showImg()
    // this.isToday()
  },
  methods: {
    /** 将活动 id 存进全局变量 */
    toDetail: function () {
      const url = '../clock/main?&actname=' + this.actname + '&finishday=' + this.finishday + '&actday=' + this.actday
      globalStore.state.actid = this.actid
      wx.navigateTo({
        url: url
      })
    },
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
    // isToday: function () {
    //   // ** 问题在于，当返回 doing 页面时，先执行的是该函数，后执行读取新的列表，因此无法实时跟进刷新
    //   if (this.istoday === 1) {
    //     this.istodayShow = '已打卡'
    //     this.color = 'color:#999999'
    //   } else {
    //     this.istodayShow = '未打卡'
    //     this.color = 'color:#FF6633'
    //   }
    // }
  }
}
</script>



<style scoped>
/************进行中的打卡标签页*************/

.content {
  /* background-color: #38ceb1; */
  height: auto;
  display: flex;
  flex-wrap: wrap;
  margin-bottom: 40rpx;
}

/*打卡选项卡*/

.contentdetail {
  border-radius: 30rpx;
  margin-left: 36rpx;
  margin-top: 40rpx;
  height: 400rpx;
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
  display: flex;
  flex-direction: column;
}

/*是否打卡提示文字,320-36=284*/

.ynclock {
  color: #f63;
  font-size: 32rpx;
  margin-top: 16rpx;
  margin-left: 36rpx;
  width: 284rpx;
  height: 50rpx;
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
  /* top: 170rpx; */
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
  /* top: 170rpx; */
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
  /* top: 170rpx; */
  color: #38ceb1;
  font-size: 50rpx;
  font-family: SimHei;
  font-weight: bold;
}
/** 封面 */
.actShowImg{
height: 260rpx;
width: 320rpx;
z-index: -1;
border-radius: 30rpx 30rpx 0 0;
}
</style>