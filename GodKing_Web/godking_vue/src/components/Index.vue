<template>
  <el-container>
    <el-header>
      <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
               background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" router="router">
        <el-menu-item id="work" index="/table">
          作息
        </el-menu-item>
        <el-menu-item id="notes" index="/notes">
          日志
        </el-menu-item>
        <el-menu-item id="weather" index="/wea">
          天气
        </el-menu-item>
        <el-menu-item id="personal" index="/per">
          个人信息
        </el-menu-item>
      </el-menu>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
    <el-footer>
      <el-link id="home1" type="primary" href="/login">退出</el-link>
    </el-footer>
  </el-container>
</template>

<script>
import table from '../components/Table'

export default {
  data () {
    return {
      activeIndex: '1',
      isCollapse: true,
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      // console.log(key, keyPath);
    },
    handleOpen (key, keyPath) {
      // console.log(key, keyPath);
    },
    handleClose (key, keyPath) {
      // console.log(key, keyPath);
    },
  }
}
</script>

<style scoped>

</style>
