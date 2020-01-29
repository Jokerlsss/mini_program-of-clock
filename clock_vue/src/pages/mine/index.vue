<template>
  <!-- 头部个人信息 -->
  <div class="container">
    <div class="head">
      <div class="con_left">
        <van-image
          round
          width="156rpx"
          height="156rpx"
          src="https://img.yzcdn.cn/vant/cat.jpeg"
          class="headimg"
        />
      </div>
      <div class="con_mid">
        <div class="mid_top">Jokerlsss</div>
        <div class="mid_bottom">
          <span class="tipstitle">上次打卡：</span>
          <span class="tipsdate">2019.12.08</span>
        </div>
      </div>
      <div class="con_right">
        <van-image
          width="64rpx"
          height="64rpx"
          src="../../../static/images/root.png"
          class="rooticon"
        />
      </div>
    </div>
    <!-- 中间“已完成”标题栏 -->
    <div class="finish_title">
      <van-cell is-link value="查看更多历史分析" size="large" url="../echarts/main">
        <div slot="title">
          <span class="custom-title">已完成</span>
          <span>&nbsp;&nbsp;</span>
          <!-- plain：空心样式  mark：半圆角样式  round：圆角样式-->
          <van-tag size="medium" round color="#38ceb1">{{actCount}}</van-tag>
        </div>
      </van-cell>
    </div>

    <!-- 已完成的选项卡 -->
    <div class="content_finish">
      <activityok
        v-for="(item, index) in activityArr"
        :key="index"
        :actname="item.actname"
        :type="item.type"
      />
    </div>
  </div>
</template>

<script>
import activityok from '@/components/activityok'
export default {
  components: {
    activityok
  },
  data () {
    return {
      activityArr: [],
      userid: 1,
      actCount: 0
    }
  },
  onLoad () {
    this.actOkGet()
  },
  methods: {
    // 查找已完成的活动列表
    actOkGet: function () {
      this.$httpWX.get({
        url: '/activity/listById',
        data: {
          userid: this.userid,
          flag: 1
        }
      }).then(res => {
        /** activityArr 将取到的数据存进数据用于遍历 */
        let activityArr = res
        this.activityArr = activityArr
        this.actCount = activityArr.length
      })
    }
  }
}
</script>

<style>
page {
  background: #f7f7f7;
}
</style>

<style scoped>
.content_finish {
  height: auto;
  display: flex;
  flex-wrap: wrap;
  margin-bottom: 40rpx;
}
/* 顶部信息栏 */
.head {
  display: flex;
  width: 100%;
  height: 240rpx;
  background-color: white;
}
/* 顶部左侧 */
.con_left {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 35%;
  height: 100%;
}
/* 顶部中间 */
.con_mid {
  width: 50%;
  height: 100%;

  display: flex;
  flex-direction: column;
}
/* 中间上部 */
.mid_top {
  display: flex;
  flex-direction: column;
  justify-content: center;
  font-size: 48rpx;
  font-weight: bold;

  width: 100%;
  height: 50%;
}
/* 中间下部 */
.mid_bottom {
  display: flex;
  width: 100%;
  height: 50%;
}
/* 顶部右侧 */
.con_right {
  display: flex;
  justify-content: flex-end;
  width: 15%;
  height: 100%;
}
/* 头像 */
.headimg {
  align-content: center;
  justify-content: center;
}
/* 上次打卡 */
.tipstitle {
  margin-top: 40rpx;
  font-size: 28rpx;
  color: #cccccc;
}
/* 上次打卡日期 */
.tipsdate {
  margin-top: 34rpx;
  font-size: 32rpx;
  color: #38ceb1;
}
/* 设置按钮 */
.con_right {
  margin-right: 28rpx;
  margin-top: 18px;
}

/***************“已完成”标题*********** */
.finish_title {
  margin-top: 28rpx;
}
</style>