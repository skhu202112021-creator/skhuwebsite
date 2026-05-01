import { createRouter, createWebHashHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import JoinView from '../views/JoinView.vue'
import LoginTest from '../views/LoginTest.vue'
const routes = [
    {
        path: '/',
        name: 'home'
    },
    {
        path: '/login',
        name: 'login',
        component: LoginView
    },
	{
	   	path: '/logintest',
	   	name: 'logintest',
	   	component: LoginTest
	},
	{
		path: '/join',
		name: 'join',
		component: JoinView
	}
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router
