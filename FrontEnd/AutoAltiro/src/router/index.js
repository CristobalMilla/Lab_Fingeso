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
            meta: ,
        }
    ],
});

export default router;