<template>
    <div class="admin-home">
      <h1>Administrador</h1>
      <router-link to="/add-car">Añadir un vehículo</router-link>
      <router-link to="/car-status">Buscar un vehículo</router-link>
    </div>
  </template>
  
  <script>
  export default {
    name: 'AdminHome',
  };
  </script>
  