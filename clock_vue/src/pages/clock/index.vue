<template>
  <div class="container">
    <!-- 上部标题和进度条 -->
    <div class="clock_title">
      <div class="title_text">{{actname}}</div>
      <div class="title_progress">
        <van-progress :percentage="percentage" stroke-width="9" color="#38ceb1" />
      </div>
    </div>
    <!-- 日历部分 -->
    <div class="clock_date">
      <div class="calender">
        <table border="1px" cellpadding="0" cellspacing="0">
          <tbody id="idCalendar">
            <Calendar @select="select" :value="dateArr" multi="true"></Calendar>
            <!-- <calendar v-for="(item,index) of list" :key="index" /> -->
          </tbody>
        </table>
      </div>
    </div>
    <!-- 打卡按钮 -->
    <div class="clock_btn">
      <van-button
        @click="clockPost"
        type="primary"
        size="large"
        round
        custom-style="width:300rpx;height:300rpx;font-size:50rpx"
        color="linear-gradient(to right, #66ffff, #38ceb1)"
      >打 卡</van-button>
    </div>
    <van-dialog id="van-dialog" width="500rpx" />
    <!-- 数据分析 -->
    <div class="analyse">
      <div class="analysies">
        <div class="left_top">当月打卡</div>
        <div class="left_bottom">2</div>
      </div>
      <div class="analysies">
        <div class="left_top">计划打卡</div>
        <div class="left_bottom">{{actday}}</div>
      </div>
      <div class="analysies">
        <div class="left_top">总共打卡</div>
        <div class="left_bottom">{{finishday}}</div>
      </div>
    </div>
  </div>
</template>

<script>
import Calendar from 'mpvue-calendar'
import 'mpvue-calendar/src/style.css'
import globalStore from '../../stores/global-store'
import Dialog from '../../../dist/wx/static/vant/dialog/dialog'
// import Toast from '../../../dist/wx/static/vant/toast/toast'

export default {
  // 使用计算属性，获取全局变量中的userid
  computed: {
    userid () {
      return globalStore.state.userid
    },
    actid () {
      return globalStore.state.actid
    }
  },
  components: {
    Calendar
  },

  /**
   * dataArr:处理后的打卡日期数据
   * clockdates:未处理的打卡日期
   * clockToday:今日打卡日期
   */
  data () {
    return {
      dateArr: [],
      clockdates: [],
      // actid: '',
      actname: '',
      actday: '',
      clockToday: '',
      finishday: 0,
      percentage: '',
      num: 1
    }
  },
  /** 获取从主页跳转过来的活动数据：id和活动名称 */
  onLoad (option) {
    console.log('onLoad')
    // this.actid = option.actid
    this.actname = option.actname
    this.finishday = option.finishday
    this.actday = option.actday
    this.dateGet()
    this.countPercentage()
  },
  methods: {
    /**
     * 获取打卡日期，并对日期进行数据处理
     * params:用户id，活动id
     */
    dateGet: function () {
      this.$httpWX.get({
        url: '/record/listById',
        data: {
          userid: this.userid,
          actid: this.actid
        }
      }).then(res => {
        /** 在每次打开打卡页面时，将数组清空，避免不同活动间数组混乱 */
        /** 已解决：在没有打卡记录的时候，依然会报错 */
        if (res.length !== 0) {
          this.dateArr = []
          this.clockdates = []
          var list = []
          for (let i = 0; i < res.length; i++) {
            this.clockdates[i] = res[i].clockdate
          }
          // 处理数据转换成可以读取日历的格式
          for (var i = 0; i < this.clockdates.length; i++) {
            var clockdate = this.clockdates[i]
            var y = clockdate.split('-')
            // 将已经签到的日期求总数作为循环次数，分割成年月日，作为i、j、k参数传进去list，之后遍历list即可
            // 需要解决的问题：逐一读取出数据库中的签到日期并将值传递出来
            list[i] = [parseInt(y[0]), parseInt(y[1]), parseInt(y[2])]
            this.dateArr.push(list[i])
          }
        } else {
          /** dateArr 不能为空，因此设置为 1900-01-01 作为默认值，避免报错 */
          this.dateArr = ['1900 - 01 - 01']
          this.clockdates = []
        }
      })
    },
    /** 进行打卡 */
    clockPost: function () {
      /** 获取当前时间 */
      var date = new Date()
      var seperator1 = '-'
      var year = date.getFullYear()
      var month = date.getMonth() + 1
      var strDate = date.getDate()
      if (month >= 1 && month <= 9) {
        month = '0' + month
      }
      if (strDate >= 0 && strDate <= 9) {
        strDate = '0' + strDate
      }
      var clockToday = year + seperator1 + month + seperator1 + strDate

      // let clockToday = moment.utc.format('yyyy-MM-dd')
      this.clockToday = clockToday
      this.$httpWX.post({
        url: '/record/insert',
        data: {
          userid: this.userid,
          actid: this.actid,
          clockdate: this.clockToday
        }
      }).then(res => {
        /** res = 1 表示打卡成功，否则失败 */
        if (res === 1) {
          /** 通过异步弹窗，在打卡成功后点击确认再重新刷新页面 */
          Dialog.confirm({
            title: clockToday,
            message: '打卡成功！',
            asyncClose: true,
            cancelButtonText: '返回首页'
          }).then(() => {
            setTimeout(() => {
              Dialog.close()
              this.finishday++
              wx.redirectTo({
                url: '../clock/main?&actname=' + this.actname + '&finishday=' + this.finishday + '&actday=' + this.actday
              })
            }, 300)
          }).catch(() => {
            setTimeout(() => {
              Dialog.close()
              wx.switchTab({
                url: '../doing/main'
              })
            }, 300)
          })
        } else {
          wx.showToast({
            title: '不可重复打卡',
            icon: 'none',
            image: '',
            duration: 2000,
            mask: false,
            success: (result) => {

            },
            fail: () => { },
            complete: () => { }
          })
        }
      })
    },
    countPercentage: function () {
      var actday = this.actday
      var finishday = this.finishday
      // console.log('actday:', this.actday)
      // console.log('finishday:', this.finishday)
      /**
       * math.ceil  向上取整
       */
      this.percentage = Math.ceil(finishday / actday * 100)
    }
  }
}
</script>



<style scoped>
.container {
  flex-wrap: wrap;
  display: flex;
  justify-content: center;
}
/*********** 上部标题和进度条*********** */
.clock_title {
  justify-content: center;
  /* border-bottom: 1px solid #f2f2f2; */
  display: flex;
  height: 120rpx;
  width: 100%;
}
.clock_date {
  justify-content: center;
  display: flex;
  height: auto;
  width: 90%;
}
.title_text {
  display: flex;
  justify-content: center;
  flex-direction: column;
  font-size: 40rpx;
}
/* 进度条 */
.title_progress {
  margin-left: 60rpx;
  display: flex;
  justify-content: center;
  flex-direction: column;
  height: 100%;
  width: 420rpx;
}
.calender {
  width: 100%;
}
/** 打卡按钮 */
.clock_btn {
  justify-content: center;
  width: 50%;
  display: flex;
  height: auto;
}
/** 数据分析部分 */
.analyse {
  margin-top: 50rpx;
  margin-bottom: 40rpx;
  /* border-top: 1px solid #d1d1d1;
  border-bottom: 1px solid #d1d1d1; */
  height: 140rpx;
  width: 90%;
  display: flex;
}
.analysies {
  border-right: 1px solid #d1d1d1;
  border-left: 1px solid #d1d1d1;
  margin-top: 20rpx;
  margin-bottom: 20rpx;
  width: 33%;
  display: flex;
  flex-wrap: wrap;
}
.left_top {
  color: dimgray;
  justify-content: center;
  display: flex;
  height: 50rpx;
  width: 100%;
}
.left_bottom {
  justify-content: center;
  display: flex;
  height: 50rpx;
  font-size: 40rpx;
  font-weight: bold;
  width: 100%;
}
</style>