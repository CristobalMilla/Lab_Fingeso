<template>
    <div class="customer-home">
      <h1>Inicio cliente</h1>
      <router-link to="/advanced-search">Búsqueda</router-link>
      <router-link to="/reserve">Reservar un vehículo</router-link>
      <router-link to="/vehicles">Catálogo</router-link>

    </div>
  </template>
  
  <script>
  export default {
    name: 'CustomerHome',
  };
  </script>
  