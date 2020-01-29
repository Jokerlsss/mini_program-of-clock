<template>
  <div class="click-counter">
    <div class="counter-num">次数：{{num}}</div>
    <button class="counter-btn" @click="handleClick">点我呀！</button>
    <button class="counter-reset-btn" @click="handleResetClick">清零</button>
    <!--插槽-->

    <slot></slot>
  </div>
</template>

<script>
export default {
  // 增加一个可从外部传入的属性
  props: {
    initNum: {
      type: Number,
      default: 0
    }
  },
  data () {
    return {
      num: this.initNum
    }
  },

  methods: {
    handleClick () {
      this.num += 1
      this.notifyNum()
    },
    handleResetClick () {
      this.num = 0
      this.notifyNum()
    },
    notifyNum () {
      // 触发父组件自定义事件 clicknum，用于自创一个监听事件，无实际效果
      this.$emit('clicknum', {
        num: this.num
      })
    }
  }
}
</script>

<style>
.click-counter {
  display: flex;
  align-items: center;
  justify-content: center;
  border: 1px solid red;
  background-color: #ffffff;
  padding: 10px;
}

.counter-num,
.counter-btn,
.counter-reset-btn {
  flex: 1;
  margin: 3px;
}
</style>