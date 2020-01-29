<template>
  <div class="container">
    <div>计数结果{{count}}</div>
    <a href="/pages/mine/main" class="navlink">进入计数器页面</a>
  </div>
</template>

<script>
import globalStore from '../../stores/global-store'

export default {
  computed: {
    count () {
      return globalStore.state.count
    }
  }

}
</script>

<!--scoped只作用于当前组件-->
<style scoped>
.navlink {
  text-decoration: underline;
}
</style>