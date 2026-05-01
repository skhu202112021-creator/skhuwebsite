import { createRouter, createWebHashHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import JoinView from '../views/JoinView.vue'
import LoginTest from '../views/LoginTest.vue'
import SugangView from '../views/SugangView.vue'
import HomeView from '../views/HomeView.vue'
const routes = [
    {
        path: '/',
        name: 'home',
		component: HomeView
    },
    {
        path: '/login',
        name: 'login',
        component: LoginView
    },
	{
		path: '/join',
		name: 'join',
		component: JoinView
	},
	{
		path: '/sugang',
		name: 'sugang',
		component: SugangView
	}
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router
