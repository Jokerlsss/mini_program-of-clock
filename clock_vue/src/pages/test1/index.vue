<template>
  <div class="container btns">
    <button class="calbtn" @click="hanleDecrement">-</button>
    <span class="calnum">{{count}}</span>
    <button class="calbtn" @click="hanleIncrement">+</button>
  </div>
</template>

<script>
import globalStore from '../../stores/global-store'

export default {
  // computed用来监控自己定义的变量，对多个变量或对象处理后返回一个值
  computed: {
    count () {
      return globalStore.state.count
    }
  },
  // 通过commit提交mutation的方式来修改state，而不要直接修改state。不然，控制台会报错，并且vue调试工具不会记录state的变化，无法调试
  methods: {
    hanleIncrement () {
      globalStore.commit('increment')
    },
    hanleDecrement () {
      globalStore.commit('decrement')
    }
  }
}
</script>

<style scoped>
.btns {
  display: flex;
  align-items: center;
}
.calnum {
  color: red;
  font-size: 32px;
}
</style>