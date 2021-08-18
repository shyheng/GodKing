<template>
  <div>
    <el-container>
      <el-header>欢迎来到GodKing</el-header>
      <el-main>
        <div>
          账号：<el-input v-model="username" placeholder="请输入内容"></el-input>
          密码：<el-input placeholder="请输入密码" v-model="password" show-password></el-input>
          <br>
          <br>
          <div>
            <el-button type="primary" @click="login">登录</el-button>
            <el-button type="primary" plain @click="reg">注册</el-button>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  data () {
    return {
      username: '',
      password: ''
    }
  },
  methods:{
    login(){
      this.$router.push({path: "/index"})
    },
    reg(){
      this.$router.push({path: "/reg"})
    }
  }
}
</script>

<style scoped>

</style>
