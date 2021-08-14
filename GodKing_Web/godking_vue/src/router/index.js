import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../components/Index'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Index
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
