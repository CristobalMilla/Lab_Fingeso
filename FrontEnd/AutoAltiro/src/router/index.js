import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    route: [
        {
            path: '/',
            name: 'home',
            component: () => import('../views/homeViews.vue'),
            alias : '/inicio',
        }
    ],
});

export default router;