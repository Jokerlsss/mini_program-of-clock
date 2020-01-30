<template>
  <div class="container">
    <!-- <van-uploader :fileList="fileList" @after-read="afterRead" /> -->
    <button @click="uploadimg">上传图片</button>
  </div>
</template>


<script>
export default {
  data () {
    return {
      fileList: [
        { url: 'https://img.yzcdn.cn/vant/leaf.jpg', name: '图片1' },
        // Uploader 根据文件后缀来判断是否为图片文件
        // 如果图片 URL 中不包含类型信息，可以添加 isImage 标记来声明
        {
          url: 'http://iph.href.lu/60x60?text=default',
          name: '图片2',
          isImage: true
        }
      ]
    }
  },
  // data () {
  //   return {
  //     fileList: [
  //       { url: 'https://img.yzcdn.cn/vant/leaf.jpg' }
  //       // Uploader 根据文件后缀来判断是否为图片文件
  //       // 如果图片 URL 中不包含类型信息，可以添加 isImage 标记来声明
  //     ]
  //   }
  // },
  methods: {
    afterRead: function (event) {
      console.log('come in')
      const { file } = event.detail
      console.log('event:', event)
      // 当设置 mutiple 为 true 时, file 为数组格式，否则为对象格式
      wx.uploadFile({
        url: 'https://example.weixin.qq.com/upload', // 仅为示例，非真实的接口地址
        filePath: file.path,
        name: 'file',
        formData: { user: 'test' },
        success (res) {
          // 上传完成需要更新 fileList
          console.log('res:', res)
          const { fileList = [] } = this.data
          fileList.push({ ...file, url: res.data })
          this.setData({ fileList })
        }
      })
    },
    uploadimg: function () {
      wx.chooseImage({
        count: 1,
        sizeType: ['original', 'compressed'],
        sourceType: ['album'],
        success (res) {
          // tempFilePath可以作为img标签的src属性显示图片
          const tempFilePaths = res.tempFilePaths
          console.log('tempFilePaths:', tempFilePaths)
        }
      })
    }
  }
}
</script>

<style scoped>
.container {
  margin-top: 50rpx;
  width: 100%;
  background-color: #333333;
  height: 200rpx;
}
</style>