<template>
  <div class="container">
    <!-- “进行中”标题栏 -->
    <div class="head">
      <van-cell size="large">
        <div slot="title">
          <span class="custom-title">进行中</span>
          <span>&nbsp;&nbsp;</span>
          <!-- plain：空心样式  mark：半圆角样式  round：圆角样式-->
          <van-tag size="medium" round color="#38ceb1">{{actCount}}</van-tag>
        </div>
      </van-cell>
    </div>
    <!-- 循环遍历出活动列表 -->
    <!-- 待解决：添加活动属性为：今日是否打卡，用定时器，每日凌晨12点，将该状态置为未打卡状态 -->
    <div class="activity">
      <activitydoing
        v-for="(item, index) in activityArr"
        :key="index"
        :actday="item.actday"
        :actname="item.actname"
        :actid="item.actid"
        :finishday="item.finishday"
        :istoday="item.istoday"
        :type="item.type"
      ></activitydoing>
      <activityadd></activityadd>
    </div>
  </div>
</template>


<script>
import activitydoing from '@/components/activitydoing'
import activityadd from '@/components/activityadd'
import globalStore from '../../stores/global-store'

export default {
  computed: {
    userid () {
      return globalStore.state.userid
    }
  },
  data () {
    return {
      activityArr: [],
      // userid: 1,
      actCount: 0
    }
  },
  onLoad () {
    // console.log('doing:onLoad')
  },
  onShow () {
    // console.log('doing:onShow')
    this.doingGet()
  },
  methods: {
    // 获取正在进行中的活动
    // 已解决：活动状态条件应加入、活动已完成天数
    // 在活动表中加入活动已完成天数字段，每次打卡便+1
    // ******  未解决：在打卡后，返回到首页时应显示已打卡（重新加载首页）
    doingGet: function () {
      this.$httpWX.get({
        url: '/activity/listById',
        data: {
          userid: this.userid,
          flag: 0
        }
      }).then(res => {
        /** activityArr 将取到的数据存进数据用于遍历 */
        // actCount 作为活动的总数量
        let activityArr = res
        this.activityArr = activityArr
        this.actCount = activityArr.length
        console.log('***********activityArr:', this.activityArr)
      })
    }
  },
  components: {
    activitydoing,
    activityadd
  }
}
</script>


<style>
page {
  background: #f7f7f7;
}
</style>


<style scoped>
/*****  “进行中”标题栏 *****/
.head {
  margin-top: 20rpx;
}
/** 标题title */
.custom-title {
  font-size: 36rpx;
  font-family: STFangsong;
}

/******* 活动页签部分 ******/
.activity {
  height: auto;
  display: flex;
  flex-wrap: wrap;
  margin-bottom: 40rpx;
}
</style>