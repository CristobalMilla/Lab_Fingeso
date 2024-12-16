<template>
    <div>
      <h2>{{ vehiculo ? "Editar Vehículo" : "Añadir Nuevo Vehículo" }}</h2>
      <form @submit.prevent="guardar">
        <label>
          Marca:
          <input
            type="text"
            v-model="formData.marca"
            required
          />
        </label>
        <br />
        <label>
          Modelo:
          <input
            type="text"
            v-model="formData.modelo"
            required
          />
        </label>
        <br />
        <label>
          Año:
          <input
            type="number"
            v-model="formData.anio"
            required
          />
        </label>
        <br />
        <button type="submit">Guardar</button>
        <button type="button" @click="$emit('cancelar')">Cancelar</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    name: "FormularioVehiculo",
    props: {
      vehiculo: {
        type: Object,
        default: null,
      },
    },
    data() {
      return {
        formData: {
          marca: "",
          modelo: "",
          anio: "",
        },
      };
    },
    watch: {
      vehiculo: {
        immediate: true,
        handler(nuevoVehiculo) {
          this.formData = nuevoVehiculo
            ? { ...nuevoVehiculo }
            : { marca: "", modelo: "", anio: "" };
        },
      },
    },
    methods: {
      guardar() {
        this.$emit("guardar", { ...this.formData });
        this.formData = { marca: "", modelo: "", anio: "" }; 
      },
    },
  };
  </script>
  