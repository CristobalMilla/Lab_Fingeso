<template>
  <div id="app">
    <aside class="side-menu">
      <ul>
        <li><router-link to="/">Inicio</router-link></li>
        <li v-if="isAdmin"><router-link to="/admin">Admin</router-link></li>
        <li><router-link to="/customer">Cliente</router-link></li>
        <li v-if="isAdmin"><router-link to="/add-car">Añadir un vehículo</router-link></li>
        <li v-if="isAdmin"><router-link to="/car-status">Estado del vehículo</router-link></li>

        <li><router-link to="/advanced-search">Búsqueda</router-link></li>
        <li><router-link to="/reserve">Reserva</router-link></li>
        <li><router-link to="/vehicles">Catalogo de vehículos</router-link></li>
      </ul>
    </aside>

    <div class="main-content">
      <router-view />
    </div>

    <Footer />
  </div>
</template>

<script>
import Footer from "./components/Footer.vue";

export default {
  name: "App",
  components: {
    Footer,
  },
  data() {
    return {
      isAdmin: false, 
    };
  },
  created() {
    // REquest if user is admin to know the state and what to rpompt, will be replaced by a backend get
    const userRole = localStorage.getItem('userRole'); 
    if (userRole === 'admin') {
      this.isAdmin = true; 
    }
  },
};
</script>