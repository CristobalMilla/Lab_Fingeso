<template>
  <div class="vehicle-list">
    <div 
      class="vehicle-card" 
      v-for="vehicle in vehicles" 
      :key="vehicle.id"
    >
      <h3>{{ vehicle.name }}</h3>
      <p><strong>Marca:</strong> {{ vehicle.brand }}</p>
      <p><strong>Modelo:</strong> {{ vehicle.model }}</p>
      <p><strong>Precio:</strong> {{ vehicle.price }} USD</p>
      <button @click="showDetails(vehicle.id)">Ver Detalles</button>
    </div>

    <div v-if="selectedVehicle" class="vehicle-details">
      <h2>Detalles del Vehículo</h2>
      <p><strong>Nombre:</strong> {{ selectedVehicle.name }}</p>
      <p><strong>Marca:</strong> {{ selectedVehicle.brand }}</p>
      <p><strong>Modelo:</strong> {{ selectedVehicle.model }}</p>
      <p><strong>Precio:</strong> {{ selectedVehicle.price }} USD</p>
      <p><strong>Descripción:</strong> {{ selectedVehicle.description }}</p>
      <button @click="closeDetails">Cerrar Detalles</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "VehicleList",
  data() {
    return {
      vehicles: [],
      selectedVehicle: null,
    };
  },
  methods: {
    fetchVehicles() {
      setTimeout(() => {
        this.vehicles = [
          { id: 1, name: "Toyota Corolla", brand: "Toyota", model: "2020", price: 20000, description: "Un vehículo fiable y económico." },
          { id: 2, name: "Honda Civic", brand: "Honda", model: "2019", price: 22000, description: "Un coche cómodo y de buen rendimiento." },
          { id: 3, name: "Ford Mustang", brand: "Ford", model: "2022", price: 35000, description: "Un vehículo potente para los amantes de los deportes." },
        ];
      }, 500);
    },
    showDetails(id) {
      this.selectedVehicle = this.vehicles.find(vehicle => vehicle.id === id);
    },
    closeDetails() {
      this.selectedVehicle = null;
    },
  },
  mounted() {
    this.fetchVehicles();
  },
};
</script>
