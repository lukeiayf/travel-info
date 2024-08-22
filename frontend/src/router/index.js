import { createRouter, createWebHistory } from 'vue-router';
import DefaultLayout from '../components/DefaultLayout.vue';
import GuestLayout from '../components/GuestLayout.vue';
import Home from '../views/Home.vue';
import TravelInfoByName from '../views/TravelInfoByName.vue';

const routes = [
    {
        path: '/',
        name: 'defaultLayout',
        component: DefaultLayout,
        children: [
            {
                path: '/',
                name: 'home',
                component: Home,
                redirect: '/by-name'
            },
            {
                path: '/by-name/:name?',
                name: 'byName',
                component: TravelInfoByName
            }
        ]
    },
    {
        path: '/guest',
        component: GuestLayout
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;