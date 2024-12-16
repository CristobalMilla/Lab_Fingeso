import { createRouter, createWebHistory } from 'vue-router';

import homeView from '../views/homeViews.vue';
import AdminHome from '../views/AdminHome.vue';
import CustomerHome from '../views/CustomerHome.vue';
import AddCar from '../views/AddCar.vue';
import CarStatusSearch from '../views/CarStatusSearch.vue';
import AdvancedSearch from '../views/AdvancedSearch.vue';
import Reserve from '../views/Reserve.vue';
import Vehicles from '../views/Vehicles.vue';

const routes = [
  { path: '/', name: 'home', component: homeView },
  { path: '/admin', name: 'adminHome', component: AdminHome },
  { path: '/customer', name: 'customerHome', component: CustomerHome },
  { path: '/add-car', name: 'addCar', component: AddCar },
  { path: '/car-status', name: 'carStatusSearch', component: CarStatusSearch },
  { path: '/advanced-search', name: 'advancedSearch', component: AdvancedSearch },
  { path: '/reserve', name: 'reserve', component: Reserve },
  { path: '/vehicles', name: 'vehicles', component: Vehicles },

];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;