import { createRouter, createWebHistory } from "vue-router";

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
        {
            path:'/flota',
            name: 'flota',
            component: () => import('../views/flotaPage.vue'),
        },
        {
            path: '/consultaFlota',
            name: 'consultaFlota',
            component: () => import('../views/consultaFlota.vue'),
        }
    ],
});

export default router;