<template>
  <div class="container">
    <div class="date"></div>
    <div class="calender">
      <table border="1px" cellpadding="0" cellspacing="0">
        <tbody id="idCalendar">
          <Calendar @select="select" :value="dateArr" multi="true"></Calendar>
          <!-- <calendar v-for="(item,index) of list" :key="index" /> -->
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import Calendar from 'mpvue-calendar'
import 'mpvue-calendar/src/style.css'
import globalStore from '../../stores/global-store'

export default {
  // 使用计算属性，获取全局变量中的userid
  computed: {
    userid () {
      return globalStore.state.userid
    }
  },
  components: {
    Calendar
  },

  /**
   * dataArr:处理后的打卡日期数据
   * clockdates:未处理的打卡日期
   */
  data () {
    return {
      dateArr: [],
      clockdates: []
    }
  },
  onLoad () {
    this.dateGet()
  },

  methods: {
    /**
     * 获取打卡日期，并对日期进行数据处理
     * 待处理：
     */
    dateGet: function () {
      this.$httpWX.get({
        url: '/record/listById',
        data: {
          userid: this.userid
        }
      }).then(res => {
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
        // console.log('list:', list)
      })
    }

  }
}
</script>


<style scoped>
/* 日历控件标题周几 */
.date_head {
  display: flex;
  justify-content: center;
}
tr td {
  height: 80rpx;
  width: 14.3%;
  display: flex;
  justify-content: center;
}
</style>