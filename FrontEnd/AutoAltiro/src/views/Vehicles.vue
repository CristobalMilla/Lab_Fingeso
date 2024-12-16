<template>
    <div class="vehicules-page">
      <h1>Catálogo de Vehículos</h1>
      <VehicleList />
    </div>
  </template>
  
  <script>
  import VehicleList from '../components/VehicleList.vue';
  
  export default {
    name: 'Vehicules',
    components: {
      VehicleList,
    },
  };
  </script>
