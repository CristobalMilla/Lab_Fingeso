import { createRouter, createWebHistory } from "vue-router";

import homeView from '../views/homeViews.vue';
import AdminHome from '../views/AdminHome.vue';
import CustomerHome from '../views/CustomerHome.vue';
import AddCar from '../views/AddCar.vue';
import CarStatusSearch from '../views/CarStatusSearch.vue';
import AdvancedSearch from '../views/AdvancedSearch.vue';
import Reserve from '../views/Reserve.vue';
import Vehicles from '../views/Vehicles.vue';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('../views/homeViews.vue'),
            alias : '/inicio',
        },
        {
            path: '/tipoUsuario',
            name: 'tipoUsuario',
            component: () => import('../views/userType.vue'),
        },
        {
            path:'/menuPrincipalAdmin',
            name: 'menuPrincipalAdmin',
            component: () => import('../views/menuAdmin.vue'),
        },
        /*{
            path:'/flota',
            name: 'flota',
            component: () => import('../views/flotaPage.vue'),
        },*/
        {
            path: '/consultaFlota',
            name: 'consultaFlota',
            component: () => import('../views/consultaFlota.vue'),
        },
        { path: '/', name: 'home', component: homeView },
        { path: '/admin', name: 'adminHome', component: AdminHome },
        { path: '/customer', name: 'customerHome', component: CustomerHome },
        { path: '/add-car', name: 'addCar', component: AddCar },
        { path: '/car-status', name: 'carStatusSearch', component: CarStatusSearch },
        { path: '/advanced-search', name: 'advancedSearch', component: AdvancedSearch },
        { path: '/reserve', name: 'reserve', component: Reserve },
        { path: '/vehicles', name: 'vehicles', component: Vehicles },
      
    ],
});

export default router;