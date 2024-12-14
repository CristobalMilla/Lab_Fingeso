<template>
    <div>
      <h2>Flota de Vehículos</h2>
      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Año</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="vehiculo in vehiculos" :key="vehiculo.id">
            <td>{{ vehiculo.id }}</td>
            <td>{{ vehiculo.marca }}</td>
            <td>{{ vehiculo.modelo }}</td>
            <td>{{ vehiculo.anio }}</td>
            <td>
              <button @click="$emit('editar', vehiculo)">Editar</button>
              <button @click="$emit('eliminar', vehiculo.id)">Eliminar</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  export default {
    name: "ListaVehiculos",
    props: {
      vehiculos: {
        type: Array,
        required: true,
      },
    },
  };
  </script>
  