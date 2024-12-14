<template>
    <div>
      <h1>Gestión de la Flota</h1>
      <ListaVehiculos
        :vehiculos="vehiculos"
        @editar="seleccionarVehiculo"
        @eliminar="eliminarVehiculo"
      />
  
      <FormularioVehiculo
        :vehiculo="vehiculoSeleccionado"
        @guardar="guardarVehiculo"
        @cancelar="cancelarEdicion"
      />
    </div>
  </template>
  
  <script>

  // Busacr en el backend
  import ListaVehiculos from "../components/ListaVehiculos.vue";
  import FormularioVehiculo from "../components/FormularioVehiculo.vue";
  
  export default {
    name: "FlotaPage",
    components: {
      ListaVehiculos,
      FormularioVehiculo,
    },
    data() {
      return {
        vehiculos: [], 
        vehiculoSeleccionado: null, 
      };
    },
    methods: {
      guardarVehiculo(vehiculo) {
        if (vehiculo.id) {
          this.vehiculos = this.vehiculos.map((v) =>
            v.id === vehiculo.id ? vehiculo : v
          );
        } else {
          vehiculo.id = Date.now(); 
          this.vehiculos.push(vehiculo);
        }
        this.vehiculoSeleccionado = null;
      },
      eliminarVehiculo(id) {
        this.vehiculos = this.vehiculos.filter((v) => v.id !== id);
      },
      seleccionarVehiculo(vehiculo) {
        this.vehiculoSeleccionado = { ...vehiculo }; 
      },
      cancelarEdicion() {
        this.vehiculoSeleccionado = null;
      },
    },
  };
  </script>
  