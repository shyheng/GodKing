import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'

// 引入axios
import axios from 'axios'

axios.defaults.withCredentials = true

// 挂载axios
Vue.prototype.$http = axios
// 设置访问根路径
axios.defaults.baseURL = 'http://' + window.location.hostname + ':9000/'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
