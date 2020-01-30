import Vue from 'vue'
import App from './index'

const app = new Vue(App)
app.$mount()

// this.$httpWX.post({
//     url: '/record/listById',
//     data: {
//         userid: 1
//     }
// }).then(res => {
//     console.log(res)
// })
