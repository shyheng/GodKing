<template>
  <div>
    <div>
      <el-input v-model="up_ip.up_ip" placeholder="请输入地址"></el-input>
      <el-button type="primary" @click="sub_addr">查看天气</el-button>
    </div>
    <h1>当前地址：{{ addr }}</h1>
    <h1>当前温度：{{ weatherList[0].temperature }}</h1>
    <div>
      <el-table
        :data="weatherList"
        style="width: 100%">
        <el-table-column
          prop="hour"
          label="时间\小时">
        </el-table-column>
        <el-table-column
          prop="temperature"
          label="温度\℃">
        </el-table-column>
        <el-table-column
          prop="weather"
          label="天气">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { getUserIP } from '../assets/u'
export default {
  data() {
    return {
      ip: '',
      up_ip:{
        up_ip:''
      },
      addr:'',
      weatherList:[]
    };
  },
  methods: {
    async sub_addr () {
      const { data: res } = await this.$http.get('up_ip', { params: this.up_ip })
      this.addr = res.addr
      this.weatherList = res.weatherList
      console.log(this.addr)
      console.log(this.weatherList)
    },
    async weather () {
      const { data: res } = await this.$http.get('ip', { params: this.ip })
      this.addr = res.addr
      this.weatherList = res.weatherList
    },
  },
  mounted() {
    getUserIP((ip) => {
      this.ip = ip;
    });
    this.weather()
  }
}
</script>

<style scoped>

</style>
