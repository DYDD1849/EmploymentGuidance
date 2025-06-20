import { createRouter, createWebHistory } from 'vue-router'
import LogIn from '@/views/LogIn.vue'
import StudentIndex from '@/views/Main/StudentIndex.vue'
import Register from '@/views/Register/Register.vue'
import StudentRegister from '@/views/Register/StudentRegister.vue'
import EnterpriseRegister from '@/views/Register/EnterpriseRegister.vue'
import EnterpriseIndex from '@/views/Main/EnterpriseIndex.vue'
import ManageIndex from '@/views/Main/ManageIndex.vue'
import Message from '@/views/Message.vue'
import StudentManage from '@/views/Manage/StudentManage.vue'
import EmploymentManage from '@/views/Manage/EmploymentManage.vue'
import RecruitManage from '@/views/Manage/RecruitManage.vue'
import MessageManage from '@/views/Manage/MessageManage.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    component: LogIn
  },
  {
    path: '/StudentIndex',
    name: 'studentindex',
    component: StudentIndex
  },
  {
    path: '/EnterpriseIndex',
    name: 'enterpriseindex',
    component: EnterpriseIndex,

  },
  {
    path: '/ManageIndex',
    name: 'manageindex',
    component: ManageIndex,
        children: [
      {
        path: 'student',
        component: StudentManage
      },
      {
        path: 'employment',
        component: EmploymentManage
      },
      {
        path: 'recruit',
        component: RecruitManage
      },
    ]
  },
  {
    path: '/Register',
    name: 'Register',
    component: Register,
    children: [
      {
        path: 'student',
        component: StudentRegister
      },
      {
        path: 'enterprise',
        component: EnterpriseRegister
      }
    ]
  },
  {
    path:'/MessageManage',
    name:'MessageManage',
    component:MessageManage,
    props:(router)=>({
      enterpriseinfo:JSON.parse(router.query.enterpriseinfo)
    })
  },
  {
    path: '/Message',
    name:'Message',
    component:Message,
    props:(router)=>({
      enterpriseinfo:JSON.parse(router.query.enterpriseinfo)
    })
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
