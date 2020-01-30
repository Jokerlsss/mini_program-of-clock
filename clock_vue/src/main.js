import Vue from 'vue'
import App from './App'
import WXrequest from './utils/wx-request'
// import Fly from 'flyio/dist/npm/wx'

Vue.prototype.$httpWX = WXrequest

Vue.config.productionTip = false
App.mpType = 'app'

const app = new Vue(App)
app.$mount()

// 实例化一个fly对象
// let fly = new Fly
// Vue.prototype.$fly = fly

export default {
  // 该部分相当于原生的app.json
  config: {
    pages: ['^pages/index/main'],
    window: {
      backgroundTextStyle: 'light',
      navigationBarBackgroundColor: '#fff',
      navigationBarTitleText: '第一个小程序',
      navigationBarTextStyle: 'black'
    }
  }
}
