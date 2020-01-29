<template>
  <div class="container">
    <div class="field">
      <van-field
        label="活动名称"
        placeholder="不超过5个字符"
        maxlength="5"
        @input="onChange_name"
        clearable="true"
      />
    </div>
    <!-- **** 问题未解决：选择类别放在最后选择的话，仍然判断为空 -->
    <div class="field_img">
      <van-field
        label="选择类别"
        placeholder="选择最接近的分类"
        @input="onChange_type"
        readonly="true"
        @click="showType"
        :value="typeValue"
      />
      <!-- 上拉菜单 -->
      <!-- cancel ：点击取消触发的事件 select ：点击选项触发的事件 -->
      <van-action-sheet
        :show="showActionSheet"
        :actions="actions"
        cancel-text="取消"
        @select="selectSheet"
        @cancel="closeSheet"
        description="活动类别"
        @click-overlay="closeSheet"
      />
      <!-- <van-dialog id="van-dialog" use-slot>
        <van-grid column-num="3">
      <van-grid-item icon="../../../static/images/books.jpg" text="阅读" @click="clickImg" />-->
      <!-- <van-image src="../../../static/images/books.jpg" class="actImg" /> -->

      <!-- <van-grid-item icon="../../../static/images/fruit.jpg" text="娱乐" @click="clickImg" /> -->
      <!-- <van-image src="../../../static/images/books.jpg" class="actImg" /> -->
      <!-- </van-grid-item> -->
      <!-- <van-grid-item icon="../../../static/images/run.jpg" text="运动" @click="clickImg" /> -->
      <!-- <van-image src="../../../static/images/books.jpg" class="actImg" /> -->
      <!-- </van-grid-item> -->
      <!-- </van-grid> -->
      <!-- </van-dialog> -->
    </div>
    <div class="field">
      <van-field
        label="目标天数"
        placeholder="不超过365天"
        maxlength="3"
        @input="onChange_day"
        type="number"
        clearable="true"
      />
    </div>
    <div class="add_btn">
      <van-button
        type="primary"
        round
        size="large"
        color="linear-gradient(to right, #66FFFF, #38ceb1)"
        @click="actPost"
        :disabled="flag"
      >新建</van-button>
      <van-toast id="van-toast" />
    </div>
  </div>
</template>

<script>
import Toast from '../../../dist/wx/static/vant/toast/toast'
import Dialog from '../../../dist/wx/static/vant/dialog/dialog'
export default {
  data () {
    return {
      actname: '',
      actday: '',
      userid: 1,
      flag: true,
      showActionSheet: false,
      typeValue: '',
      actions: [
        {
          name: '音乐',
          color: '#999999'
        },
        {
          name: '运动',
          color: '#999999'
        },
        {
          name: '学习',
          color: '#999999'
        },
        {
          name: '水果',
          color: '#999999'
        },
        {
          name: '娱乐',
          color: '#999999'
        }
      ]
    }
  },
  /**
   * 在每次退出页面之后，让文本框保持空值
   */
  onShow () {
    this.typeValue = ''
  },
  methods: {
    /**
     * 选择上拉菜单子选项
     */
    selectSheet: function (event) {
      this.showActionSheet = false
      this.typeValue = event.mp.detail.name
      console.log('name:', event.mp.detail.name)
    },
    /**
     * 显示上拉菜单和隐藏
     */
    showType: function () {
      this.showActionSheet = true
    },
    closeSheet: function () {
      this.showActionSheet = false
    },
    /**
     * 显示选择封面的弹窗
     */
    showImg: function () {
      Dialog.alert({
        title: '标题',
        message: '弹窗内容'
      }).then(() => {
        // on close
      })
    },
    /**
     * 在选择具体封面后关闭弹窗
     */
    clickImg: function (event) {
      console.log('event:', event)
      Dialog.close()
    },
    /**
     * 读取输入框的值并传递到data中
     * 设置flag，当输入框的值为空时，按钮为不可点击状态
     */
    onChange_name: function (event) {
      this.actname = event.mp.detail
      console.log('nameevent:', event.mp.detail)
      if (this.actname !== '' && this.actday !== '' && this.typeValue !== '') {
        this.flag = false
      } else if (this.actname === '' || this.actday === '' || this.typeValue === '') {
        this.flag = true
      }
      // event.mp.detail 为当前输入的值
    },
    onChange_day: function (event) {
      this.actday = event.mp.detail
      console.log('dayevent:', event.mp.detail)
      if (this.actname !== '' && this.actday !== '' && this.typeValue !== '') {
        this.flag = false
      } else if (this.actname === '' || this.actday === '' || this.typeValue === '') {
        this.flag = true
      }
    },
    onChange_type: function (event) {
      this.typeValue = event.mp.detail
      console.log('typeevent:', event.mp.detail)
      if (this.actname !== '' && this.actday !== '' && this.typeValue !== '') {
        this.flag = false
      } else if (this.actname === '' || this.actday === '' || this.typeValue === '') {
        this.flag = true
      }
    },
    /**
     * 将data中的值提出post请求，新增打卡活动
     * 输入框为空时，弹出提示信息
     */
    actPost: function () {
      if (this.flag === true) {
        Toast.fail('请完善信息')
        // wx.showToast({
        //   title: '请完善信息噢~',
        //   icon: 'none',
        //   duration: 2000
        // })
      } else {
        this.$httpWX.post({
          url: '/activity/insert',
          data: {
            actname: this.actname,
            actday: this.actday,
            type: this.typeValue,
            userid: this.userid
          }
        }).then(res => {
          /** redirectTo是关闭当前页面并跳转 */
          wx.redirectTo({
            url: '../successpost/main',
            success: (result) => {

            },
            fail: () => { },
            complete: () => { }
          })
          /** navigateTo是保留当前页面并跳转 */
          // wx.navigateTo({
          //   url: '../date/main',
          //   success: (result) => {

          //   },
          //   fail: () => { },
          //   complete: () => { }
          // })
          // console.log('success to insert!')
        })
      }
    }
  }
}
</script>

<style>
page {
  background: #f2f2f2;
}
</style>
<style scoped>
.container {
  justify-content: center;
  display: flex;
  flex-wrap: wrap;
  height: 100%;
}
/** 活动名称和天数输入框 */
.field {
  width: 100%;
  margin-top: 34rpx;
}
/** 图片 */
.field_img {
  width: 100%;
  margin-top: 32rpx;
}
/** 新建按钮 */
.add_btn {
  margin-top: 32rpx;
  width: 90%;
}
/** 封面图片 */
.actImg {
  width: 100rpx;
  height: 100rpx;
}
</style>