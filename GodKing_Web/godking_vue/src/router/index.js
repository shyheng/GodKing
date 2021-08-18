import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login'
import Registered from '../components/Registered'
import Index from '../components/Index'
import Table from '../components/Table'
import Notes from '../components/Notes'
import Weather from '../components/Weather'
import Personal from '../components/Personal'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/reg',
    component: Registered
  },
  {
    path: '/index',
    component: Index,
    redirect: '/table',
    children: [
      {
        path: '/table',
        component: Table
      },
      {
        path: '/notes',
        component: Notes
      },
      {
        path: '/wea',
        component: Weather
      },
      {
        path: '/per',
        component: Personal
      },
    ]
  },
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
