import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import MealsByIngredients from '../views/MealsByIngredients.vue';
import MealsByLetter from '../views/MealsByLetter.vue';
import MealsByName from '../views/MealsByName.vue';
import DefaultLayout from '../components/DefaultLayout.vue';
import GuestLayout from '../components/GuestLayout.vue';
import MealDetails from '../views/MealDetails.vue';
import Ingredients from '../views/Ingredients.vue';

const routes = [
    {
        path: '/',
        name: 'defaultLayout',
        component: DefaultLayout,
        children: [
            {
                path: '/travel-info',
                name: 'home',
                component: Home
                // redirect: '/by-name'
            },
            {
                path: '/ingredients',
                name: 'ingredients',
                component: Ingredients
            },
            {
                path: '/by-ingredients/:ingredient',
                name: 'byIngredients',
                component: MealsByIngredients
            },
            {
                path: '/by-name/:name?',
                name: 'byName',
                component: MealsByName
            },
            {
                path: '/by-letter/:letter?',
                name: 'byLetter',
                component: MealsByLetter
            }
        ]
    },
    {
        path:'/guest',
        component: GuestLayout
    },
    {
        path:'/meal/:id',
        name: 'mealDetails',
        component: MealDetails
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;